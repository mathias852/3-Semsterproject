package org.example.BeerMachine.BeerMachineCommunication;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Communication {


    public static void main(String[] args) {
        Write write = new Write();
        Read read = new Read();

        float speed = 0;
        int type_id;
        float amount = 100;
        int batchId = 0;

        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter("data.csv");
            csvWriter.append("Type");
            csvWriter.append(",");
            csvWriter.append("Speed");
            csvWriter.append(",");
            csvWriter.append("Amount");
            csvWriter.append(",");
            csvWriter.append("BadCount");
            csvWriter.append("\n");

        
        List<String[]> data = new ArrayList<>();


        for (int i = 4; i < 6; i++) {
            type_id = i;
            float percentageIncrement = 0.8f;
            float speedTo = 0;

            switch (type_id) {
                case(0):
                    speed = TypeSpeed.Pilsner.getTypeValue();
                    break;
                case(1):
                    speed = TypeSpeed.Wheat.getTypeValue();
                    break;
                case(2):
                    speed = TypeSpeed.IPA.getTypeValue();
                    break;
                case(3):
                    speed = TypeSpeed.Stout.getTypeValue();
                    break;
                case(4):
                    speed = TypeSpeed.Ale.getTypeValue();
                    break;
                case(5):
                    speed = TypeSpeed.Alcohole_Free.getTypeValue();
                    break;
            }

            for (int j = 0; j < 2; j++) {
                batchId = i + 1;
                speedTo = (speed * percentageIncrement);

                percentageIncrement += 0.1;
                //write.startBatch(batchId, speedTo, type_id, amount);

                int time = 0;
                while(read.checkState() == 6) {
                    try {
                        System.out.println("Checking state (" + time + " seconds) " +
                                "[Type: " + type_id + " Speed: " + speedTo + " Amount: " + amount + "]");
                        Thread.sleep(5000);
                        time += 5;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                write.reset();
                boolean resetting = false;
                while(read.checkState() !=4) {
                    try {
                        if (!resetting) {
                            System.out.print("Resetting machine");
                            resetting = true;
                        } else {
                            System.out.print(".");
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                System.out.println("\nState after reset: "+read.checkState());
                String[] dataArray = new String[]{String.valueOf(type_id), String.valueOf(Math.round(speedTo)),
                        String.valueOf(amount), String.valueOf(read.getDefectiveCount())};
                data.add(dataArray);
            }
        }


        for (String[] datas : data) {
                csvWriter.append(String.join(",", datas));
                csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
