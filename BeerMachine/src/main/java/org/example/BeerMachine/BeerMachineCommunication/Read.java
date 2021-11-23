package org.example.BeerMachine.BeerMachineCommunication;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

public class Read {
    MachineConnection machineConnection;
    OpcUaClient client;
    private int state;
    private int defectiveCount;
    private String host = "127.0.0.1";

    public int getDefectiveCount() {
        try {
            machineConnection = new MachineConnection(host, 4840);
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.ProdDefectiveCount");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            defectiveCount = (int) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return defectiveCount;
    }

    public int checkState() {
        try {
            machineConnection = new MachineConnection(host, 4840);
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Status.StateCurrent");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            state = (int) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return state;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
}
