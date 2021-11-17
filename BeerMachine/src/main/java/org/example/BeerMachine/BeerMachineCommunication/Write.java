package org.example.BeerMachine.BeerMachineCommunication;/*
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
            MachineConnection machineConnection = new MachineConnection("127.0.0.1", 4840);
            machineConnection.connect();
            OpcUaClient client = machineConnection.getClient();

            NodeId change_request = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");

            NodeId command = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");

            NodeId command_machSpeed = NodeId.parse("ns=6;s=::Program:Cube.Command.MachSpeed");
            client.writeValue(command_machSpeed, DataValue.valueOnly(new Variant(500f))).get();

            NodeId batch_id = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[0].Value");
            client.writeValue(batch_id, DataValue.valueOnly(new Variant(1))).get();

            NodeId type_id = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[1].Value");
            client.writeValue(type_id, DataValue.valueOnly(new Variant(0))).get();

            NodeId amount = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[2].Value");
            client.writeValue(amount, DataValue.valueOnly(new Variant(40000f))).get();


            client.writeValue(command, DataValue.valueOnly(new Variant(2))).get();
            client.writeValue(change_request, DataValue.valueOnly(new Variant(true))).get();
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }
}
