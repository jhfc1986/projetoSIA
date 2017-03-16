package com.unelev.projetosia.util;



public class join implements Runnable {

        @Override
        public void run() {
                for (int x = 1; x <= 3; x++) {
                     System.out.println("this is thread "+ Thread.currentThread().getName());
                }
        }

        public static void main(String[] args) throws Exception {
                join j1 = new join();
                Thread t1 = new Thread(j1, "1");
                Thread t2 = new Thread(j1, "2");
                Thread t3 = new Thread(j1, "3");
                t1.start();
                t1.join();
                t3.start();
                t3.join();
                t2.start();
                
               
        }
}