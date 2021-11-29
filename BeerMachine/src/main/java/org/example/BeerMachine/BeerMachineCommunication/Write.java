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
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.w3c.dom.Node;

public class Write {
    private MachineConnection machineConnection;
    private OpcUaClient client;

    public void reset() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId change_request = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            NodeId command = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(command, DataValue.valueOnly(new Variant(1))).get();
            client.writeValue(change_request, DataValue.valueOnly(new Variant(true))).get();
            client.disconnect();
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    public void startBatch(Float batchId, float machine_speed, int type_id, float amount) {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId mach_speed_node = NodeId.parse("ns=6;s=::Program:Cube.Command.MachSpeed");
            client.writeValue(mach_speed_node, DataValue.valueOnly(new Variant(machine_speed))).get();

            NodeId batchIdNode = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[0].Value");
            client.writeValue(batchIdNode, DataValue.valueOnly(new Variant(batchId))).get();


            NodeId type_id_node = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[1].Value");
            client.writeValue(type_id_node, DataValue.valueOnly(new Variant(type_id))).get();

            NodeId amount_node = NodeId.parse("ns=6;s=::Program:Cube.Command.Parameter[2].Value");
            client.writeValue(amount_node, DataValue.valueOnly(new Variant(amount))).get();


            NodeId command = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(command, DataValue.valueOnly(new Variant(2))).get();

            NodeId change_request = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            client.writeValue(change_request, DataValue.valueOnly(new Variant(true))).get();
            client.disconnect();
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    public void stop() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId change_request = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            NodeId command = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(command, DataValue.valueOnly(new Variant(3))).get();
            client.writeValue(change_request, DataValue.valueOnly(new Variant(true))).get();
            client.disconnect();
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    public void abort() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId change_request = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            NodeId command = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(command, DataValue.valueOnly(new Variant(4))).get();
            client.writeValue(change_request, DataValue.valueOnly(new Variant(true))).get();
            client.disconnect();
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    public void clear() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId change_request = NodeId.parse("ns=6;s=::Program:Cube.Command.CmdChangeRequest");
            NodeId command = NodeId.parse("ns=6;s=::Program:Cube.Command.CntrlCmd");
            client.writeValue(command, DataValue.valueOnly(new Variant(5))).get();
            client.writeValue(change_request, DataValue.valueOnly(new Variant(true))).get();
            client.disconnect();
        }
        catch(Throwable ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Write write = new Write();
        write.startBatch(1f, 600, 0, 1000);
        //write.reset();
    }
}
