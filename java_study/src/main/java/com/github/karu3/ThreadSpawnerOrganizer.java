package com.github.karu3;

import java.util.HashMap;
import java.util.Map;

public class ThreadSpawnerOrganizer {
    public Map<String, ThreadSpawner> spawners;

    public ThreadSpawnerOrganizer() {
        spawners = new HashMap<String, ThreadSpawner>();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                Dispose();
            }
        });
    }

    private void Dispose() {
        System.out.println("Shutting down...");

        for (ThreadSpawner spawner : spawners.values()) {
            spawner.Dispose();
        }
    }
}
