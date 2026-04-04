package com.github.karu3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadSpawner {
    public ExecutorService Runner = Executors.newSingleThreadExecutor();

    public <R> Future<R> Spawn(Callable<R> task) {
        Future<R> ticket = Runner.submit(task);
        return ticket;
    }

    public <R> R Wait(Future<R> ticket) {
        try {
            return ticket.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Dispose() {
        Runner.shutdown();
    }
}
