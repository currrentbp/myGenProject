package com.bp.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * 关于细胞随机生存的问题
 * 其实主要学习关于栅栏
 *
 * @author currrent_bp
 * @createTime 20161230
 */
public class CellularAutomata {

    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            public void run() {
                mainBoard.commitNewValues();
            }
        });

        this.workers = new Worker[count];

        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        public void run() {
            while (!board.hasCoverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }

                try {
                    barrier.await();
                } catch (Exception e) {
                    return;
                }
            }
        }

        public boolean computeValue(int x, int y) {
            return x >= y;
        }

        public void start() {
            for (int i = 0; i < workers.length; i++) {
                new Thread(workers[i]).start();
            }
            mainBoard.waitForCovergence();
        }
    }

    private class Board {
        int x;
        int y;

        public void commitNewValues() {
        }

        public void waitForCovergence() {
        }

        public boolean hasCoverged() {
            return false;
        }

        public Board getSubBoard(int count, int i) {
            return null;
        }

        public int getMaxX() {
            return this.x;
        }

        public int getMaxY() {
            return this.y;
        }

        public void setNewValue(int x, int y, boolean computeValue) {
        }

    }

}
