package com.solvd.laba.block1.thread;


import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        //2 Thread using Runnable and Thread

        Runnable action = () -> {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        };

        Thread threadOne = new Thread(action, "One");
        Thread threadTwo = new Thread(action, "Two");

        threadOne.start();
        threadTwo.start();

        //Pool with size 5
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Thread[] threads = new Thread[7];
        for (Thread thread: threads) {
            thread = new Thread(() -> task(connectionPool));
            thread.start();
        }

        //CompletableFuture
        CompletableFuture<Void>[] completableFutures = new CompletableFuture[7];

        for (int i = 0; i < completableFutures.length; i++) {
            completableFutures[i] = CompletableFuture.runAsync(() -> task(connectionPool));
        }

        CompletableFuture<Void> allTasksFuture = CompletableFuture.allOf(completableFutures);
        allTasksFuture.join();
    }

    private static void task(ConnectionPool connectionPool) {
        try {
            SimpleConnection connection = connectionPool.getConnection();
            System.out.println(connection);
            Thread.sleep(4000);
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
