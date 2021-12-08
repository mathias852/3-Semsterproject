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
    private int stopReason;
    private int defectiveCount;
    private float amountToProduce;
    private float batchId;
    private float speed;
    private int totalAmountProduced;

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
            stopReason = (int) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return stopReason;
    }

    public int checksStopState() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.StopReason.Value");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            state = (int) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return state;
    }



    public Float getAmountToProduce() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Status.Parameter[1].Value");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            amountToProduce = (Float) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return amountToProduce;
    }
    public float getBatchId() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Status.Parameter[0].Value");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            batchId = (float) variant.getValue();
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

    public int getTotalAmountProduced() {
        try {
            machineConnection = new MachineConnection();
            machineConnection.connect();
            client = machineConnection.getClient();

            NodeId nodeId = NodeId.parse("ns=6;s=::Program:Cube.Admin.ProdProcessedCount");

            DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            totalAmountProduced = (int) variant.getValue();
            client.disconnect();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return totalAmountProduced;
    }





}
