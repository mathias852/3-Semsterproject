package org.example.BeerMachine.BeerMachineCommunication;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athil
 */

import java.util.Arrays;
import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned;

public class Subscription {
    private MachineConnection machineConnection;
    private OpcUaClient client;

    private String host = "127.0.0.1";

    public void checkStateCurrent() {
        try
        {
            machineConnection = new MachineConnection(host, 4840);
            machineConnection.connect();
            client = machineConnection.getClient();




            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Status.StateCurrent");

            // what to read
            ReadValueId readValueId = new ReadValueId(nodeId, AttributeId.Value.uid(), null, null);

            // create a subscription @ 250ms
            UaSubscription subscription = client.getSubscriptionManager().createSubscription(250.0).get();

            // important: client handle must be unique per item
            UInteger clientHandle = subscription.getSubscriptionId();
            MonitoringParameters parameters = new MonitoringParameters(
                    clientHandle,
                    250.0,     // sampling interval
                    null,       // filter, null means use default
                    Unsigned.uint(10),   // queue size
                    true        // discard oldest
            );

            // creation request
            MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(readValueId, MonitoringMode.Reporting, parameters);


            // setting the consumer after the subscription creation
            UaSubscription.ItemCreationCallback onItemCreated =  (item, id) -> item.setValueConsumer(Subscription::onSubscriptionValue);


            List<UaMonitoredItem> items = subscription.createMonitoredItems(TimestampsToReturn.Both, Arrays.asList(request), onItemCreated).get();

            for (UaMonitoredItem item : items) {
                if (item.getStatusCode().isGood()) {
                    System.out.println("item created for nodeId=" + item.getReadValueId().getNodeId());
                } else{
                    System.out.println("failed to create item for nodeId=" + item.getReadValueId().getNodeId() + " (status=" + item.getStatusCode() + ")");
                }
            }

            // let the example run for 2 hours then terminate (equivalent to simulation time limit)
            Thread.sleep(7200000L);
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static void onSubscriptionValue(UaMonitoredItem item, DataValue value) {
        int state_value = (int) value.getValue().getValue();
        System.out.println("subscription value received: item="+ item.getReadValueId().getNodeId() + ", value=" + state_value);
        if (state_value == 4) {

        }
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
}
