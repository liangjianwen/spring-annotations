package com.ljw.test;

import com.ljw.service.ThreadTestService;
import org.junit.Test;

public class ThreadTest {

    @Test
    public void test1() throws InterruptedException {
        new Thread(new Thread1(), "Thread-1").start();
        new Thread(new Thread2(), "Thread-2").start();
        Thread.sleep(50000);
    }

    class Thread1 implements Runnable{
        public void run() {
            synchronized (ThreadTestService.test){
                System.out.println("Thread 1------>>>>get the lock.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1----------->>>release the lock.");
            }
        }
    }

    class Thread2 implements Runnable{
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2----->>>>print the string");
            synchronized (ThreadTestService.test){
                System.out.println(ThreadTestService.test);
            }
        }
    }
}
