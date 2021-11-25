package org.example.BeerMachine.BeerMachineCommunication;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athil
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned;

import javax.xml.crypto.Data;

import static com.google.common.collect.Lists.newArrayList;

public class Subscription extends Thread {
    private MachineConnection machineConnection;
    private OpcUaClient client;
    private String node;
    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;
    private float humidity;
    private float temperature;
    private float vibrations;
    private int stopReason;

    public Subscription(String node) {
        this.node = node;
    }
    @Override
    public void run() {
        getValue(node);
    }

    public void getValue(String node) {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::" + node);

            // what to read
            ReadValueId readValueId = new ReadValueId(nodeId, AttributeId.Value.uid(), null, null);

            // create a subscription @ ?ms
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
            //UaSubscription.ItemCreationCallback onItemCreated =  (item, id) -> item.setValueConsumer(Subscription::onSubscriptionValue);

            //List<UaMonitoredItem> items = subscription.createMonitoredItems(TimestampsToReturn.Both, Arrays.asList(request), onItemCreated).get();

            List<UaMonitoredItem> items = subscription.createMonitoredItems(TimestampsToReturn.Both, newArrayList(request)).get();

            UaMonitoredItem itemm = items.get(0);
            itemm.setValueConsumer(v -> {
                switch (node) {
                    case("Program:Inventory.Barley"):
                        setBarley((Float) v.getValue().getValue());
                        break;
                    case("Program:Inventory.Hops"):
                        setHops((Float) v.getValue().getValue());
                        break;
                    case("Program:Inventory.Malt"):
                        setMalt((Float) v.getValue().getValue());
                        break;
                    case("Program:Inventory.Wheat"):
                        setWheat((Float) v.getValue().getValue());
                        break;
                    case("Program:Inventory.Yeast"):
                        setYeast((Float) v.getValue().getValue());
                        break;
                    case("Program:Data.Value.RelHumidity"):
                        if (!(v.getValue().getValue() instanceof Short)) {
                            setHumidity((Float) v.getValue().getValue());
                        }
                        break;
                    case("Program:Data.Value.Temperature"):
                        setTemperature((Float) v.getValue().getValue());
                        break;
                    case("Program:Data.Value.Vibration"):
                        setVibrations((Float) v.getValue().getValue());
                        break;
                    case("Program:Cube.Admin.StopReason.Value"):
                        setStopReason((Integer) v.getValue().getValue());
                        break;
                }
            });

            /*for (UaMonitoredItem item : items) {
                if (item.getStatusCode().isGood()) {
                    System.out.println("item created for nodeId=" + item.getReadValueId().getNodeId());
                } else{
                    System.out.println("failed to create item for nodeId=" + item.getReadValueId().getNodeId() + " (status=" + item.getStatusCode() + ")");
                }
            }*/

            // let the example run for 2 hours then terminate (equivalent to simulation time limit)
            Thread.sleep(7200000L);
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static void onSubscriptionValue(UaMonitoredItem item, DataValue value) {
        float state_value = (float) value.getValue().getValue();
        System.out.println("subscription value received: item="+ item.getReadValueId().getNodeId() + ", value=" + state_value);
    }

    //Getters & Setters for live data
    public float getBarley() {
        return barley;
    }
    public void setBarley(float barley) {
        this.barley = barley;
    }
    public float getHops() {
        return hops;
    }
    public void setHops(float hops) {
        this.hops = hops;
    }
    public float getMalt() {
        return malt;
    }
    public void setMalt(float malt) {
        this.malt = malt;
    }
    public float getWheat() {
        return wheat;
    }
    public void setWheat(float wheat) {
        this.wheat = wheat;
    }
    public float getYeast() {
        return yeast;
    }
    public void setYeast(float yeast) {
        this.yeast = yeast;
    }

    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public float getVibrations() {
        return vibrations;
    }
    public void setVibrations(float vibrations) {
        this.vibrations = vibrations;
    }
    public int getStopReason() {
        return stopReason;
    }
    public void setStopReason(int stopReason) {
        this.stopReason = stopReason;
    }
}
