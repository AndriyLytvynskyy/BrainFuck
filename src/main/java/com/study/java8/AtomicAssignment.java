package com.study.java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The above example is a little more complex, but not hard to understand. The Map, which is shared, is the configuration variable of AtomicAssignment.
 * In the main() method we read the configuration initially one time and add three keys to the Map with the same value (here the current time including milliseconds).
 * Then we start a “configuration-thread” that simulates the reading of the configuration by adding all the time the current timestamp three times to the map.
 * The five worker threads then read the Map using the configuration variable and compare the three values. If they are not equal, they throw an IllegalStateException.

 You can run the program for some time and you will not see any IllegalStateException. This is due the fact that we assign the new Map to the shared configuration variable in one atomic operation:

 1 configuration = newConfig;

 We also read the value of the shared variable within one atomic step:

 1  Map<String, String> currConfig = configuration;
 As both steps are atomic, we will always get a reference to a valid Map instance where all three values are equal. If you change for example the run() method in a way that it uses the configuration variable directly instead of copying it first to a local variable, you will see IllegalStateExceptions very soon because the configuration variable always points to the “current” configuration. When it has been changed by the configuration-thread, subsequent read accesses to the Map will already read the new values and compare them with the values from the old map.
 */

public class AtomicAssignment implements Runnable {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
    private static Map<String, String> configuration = new HashMap<String, String>(); //map which is shared

    public void run() {
        for (int i = 0; i < 10000; i++) {
            Map<String, String> currConfig = configuration;
            String value1 = currConfig.get("key-1");
            String value2 = currConfig.get("key-2");
            String value3 = currConfig.get("key-3");
            if (!(value1.equals(value2) && value2.equals(value3))) {
                throw new IllegalStateException("Values are not equal.");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readConfig() {
        Map<String, String> newConfig = new HashMap<String, String>();
        Date now = new Date();
        newConfig.put("key-1", sdf.format(now));
        newConfig.put("key-2", sdf.format(now));
        newConfig.put("key-3", sdf.format(now));
        configuration = newConfig;
    }

    public static void main(String[] args) throws InterruptedException {
        readConfig();
        Thread configThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    readConfig();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "configuration-thread");
        configThread.start();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new AtomicAssignment(), "thread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        configThread.join();
        System.out.println("[" + Thread.currentThread().getName() + "] All threads have finished.");
    }
}
