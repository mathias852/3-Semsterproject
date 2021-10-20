/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athil
 */

import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

public class Write {
    public static void main(String[] args) {
        try 
        {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(endpoints.get(0));

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();

            NodeId changeRequestNode = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");

            /*NodeId node3Id = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[1].Value");
            client.writeValue(node3Id, DataValue.valueOnly(new Variant(0f))).get();
            NodeId node2Id = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[2].Value");
            client.writeValue(node2Id, DataValue.valueOnly(new Variant(30000f))).get();
            NodeId node4Id = NodeId.parse("ns=6;s=::Program:Cube.Command.MachSpeed");
            client.writeValue(node4Id, DataValue.valueOnly(new Variant(600f))).get();*/

            //Start
            /*NodeId controlNode = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(controlNode, DataValue.valueOnly(new Variant(2))).get();
            client.writeValue(changeRequestNode, DataValue.valueOnly(new Variant(true))).get();*/

            //Maintenance
            NodeId controlNode = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(controlNode, DataValue.valueOnly(new Variant(1))).get();
            client.writeValue(changeRequestNode, DataValue.valueOnly(new Variant(true))).get();

            client.writeValue(controlNode, DataValue.valueOnly(new Variant(2))).get();
            client.writeValue(changeRequestNode, DataValue.valueOnly(new Variant(true))).get();

            client.writeValue(controlNode, DataValue.valueOnly(new Variant(3))).get();
            client.writeValue(changeRequestNode, DataValue.valueOnly(new Variant(true))).get();

            client.writeValue(controlNode, DataValue.valueOnly(new Variant(4))).get();
            client.writeValue(changeRequestNode, DataValue.valueOnly(new Variant(true))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }
}
