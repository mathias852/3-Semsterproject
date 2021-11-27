package org.example.BeerMachine.BeerMachineCommunication;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

public class Read {
    MachineConnection machineConnection;
    OpcUaClient client;
    private int state;
    private int defectiveCount;
    private UShort amountToProduce;
    private UShort batchId;
    private float speed;

    public int getDefectiveCount() {
        try {
            machineConnection = new MachineConnection();
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
            machineConnection = new MachineConnection();
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

    public UShort getAmountToProduce() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:product.produce_amount");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            amountToProduce = (UShort) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return amountToProduce;
    }
    public UShort getBatchId() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:batch_id");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            batchId = (UShort) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return batchId;
    }



    public float getSpeed() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Status.MachSpeed");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            speed = (float) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return speed;
    }



}
