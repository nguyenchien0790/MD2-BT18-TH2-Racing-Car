package rikkei.academy;

import java.util.Random;

import static rikkei.academy.Main.DISTANCE;
import static rikkei.academy.Main.STEP;

public class Car implements Runnable{
    private String name;
    public Car(String name){
        this.name = name;
    }
    @Override
    public void run() {
        int runDistane = 0;
        long startTime = System.currentTimeMillis();
        while (runDistane < DISTANCE){
            try {
                int speed = (new Random()).nextInt(20);
                runDistane += speed;
                String log = "|";
                int percentTravel = (runDistane*100)/DISTANCE;
                for (int i = 0; i < DISTANCE; i+=STEP) {
                    if (percentTravel >= i + STEP){
                        log += "=";
                    }else {
                        log += "=";
                    }

                }
                log += "|";
                System.out.println("rikkei.academy.Car"+this.name + ": "+log+ " "+Math.min(DISTANCE, runDistane) + "KM");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("rikkei.academy.Car" + this.name + "broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("rikkei.academy.Car" +this.name + "Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
