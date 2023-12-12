package com.solvd.laba.block1.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.solvd.laba.block1.thread.Main.logger;

public class ConnectionPool {
    private static volatile ConnectionPool instance;
    private final BlockingQueue<SimpleConnection> connections;
    private static final int MAX_POOL_SIZE = 5;
    private static int currentConnections = 1;


    private ConnectionPool() {
        connections = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
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


    public synchronized SimpleConnection getConnection() throws InterruptedException {
        if (connections.isEmpty()) {
            if (currentConnections <= MAX_POOL_SIZE) {
                SimpleConnection sp = new SimpleConnection(currentConnections);
                connections.add(sp);
                currentConnections++;
                logger.info("{} created", sp);
            }
        }
        SimpleConnection connection = connections.take();
        logger.info("Connected by {} ", connection);
        return connection;
    }

    public void releaseConnection(SimpleConnection simpleConnection) {
        logger.info("{} released", simpleConnection);
        connections.offer(simpleConnection);
    }

}