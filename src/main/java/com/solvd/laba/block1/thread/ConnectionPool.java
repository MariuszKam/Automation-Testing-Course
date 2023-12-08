package com.solvd.laba.block1.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static volatile ConnectionPool instance;
    private final BlockingQueue<SimpleConnection> connections;
    private static final int POOL_SIZE = 5;

    private static int connectionNum = 1;

    public ConnectionPool() {
        connections = new ArrayBlockingQueue<>(POOL_SIZE);
        initialization();
    }

    public static ConnectionPool getInstance() {
        ConnectionPool result = instance;
        if (result == null) {
            synchronized (ConnectionPool.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ConnectionPool();
                }
            }
        }
        return result;
    }

    private void initialization() {
        for (int i = 0; i < POOL_SIZE; i++) {
            connections.add(new SimpleConnection(i));

        }
    }

    public SimpleConnection getConnection() throws InterruptedException {
//        if (connections.size() >= 5) {
//            connections.add(new SimpleConnection(connectionNum));
//            connectionNum++;
//        }
        return connections.take();
    }

    public void releaseConnection(SimpleConnection simpleConnection) {
        connections.offer(simpleConnection);
    }

}
