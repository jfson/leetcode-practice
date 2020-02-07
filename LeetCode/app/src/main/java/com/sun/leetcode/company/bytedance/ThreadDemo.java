package com.sun.leetcode.company.bytedance;


/**
 * Author: jfson sun
 * Create on:  2020/2/2
 * Question:
 * Description:
 * Train of thought:
 */
public class ThreadDemo {
    public static final String TAG = ThreadDemo.class.getSimpleName();
    static Boolean isOne = true;
    static Object o = new Object(); //锁不能变
    static String[] one = {"o1", "o2", "o3", "o4", "o5", "o6"};
    static String[] two = {"t1", "t2", "t3", "t4", "t5", "t6"};

    static int oneIndex = 0, twoIndex = 0;


    //两个数组利用两个线程交替打印
    public static void startDemo() {
        new Thread(new RunnableOne()).start();
        new Thread(new RunnableTwo()).start();
    }


    static class RunnableOne implements java.lang.Runnable {

        @Override
        public void run() {
            while (oneIndex < one.length) {
                synchronized (o) {

                    if (isOne) {
                        System.out.print(one[oneIndex++] + "-");
                        isOne = false;
                    } else {
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class RunnableTwo implements java.lang.Runnable {

        @Override
        public void run() {
            while (twoIndex < two.length) {
                synchronized (o) {
                    if (!isOne) {
                        System.out.print(two[twoIndex++] + "-");
                        isOne = true;
                    } else {
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
