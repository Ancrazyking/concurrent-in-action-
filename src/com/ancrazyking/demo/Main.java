package com.ancrazyking.demo;

/**
 * @author Ancrazyking
 * @date 2018/6/7 9:35
 **/
public class Main
{

    private static   test t=new test();

    static class thread1 extends Thread{
        @Override
        public void run()
        {
            synchronized (t){
            for(int i=0;i<10;i++){
                t.value++;
            }
            }
            String name=Thread.currentThread().getName();
            System.out.println(name+"正在执行!");
        }
    }

     static class thread2 implements Runnable{
        @Override
        public void run()
        {
            synchronized (t){
            for(int i=0;i<10;i++){
                t.value++;
            }}
            String name=Thread.currentThread().getName();
            System.out.println(name+"正在执行!");
        }
    }

    public static void main(String[] args){
        Thread t1=new thread1();
        t1.start();
        Thread t2=new Thread(new thread2());
        t2.start();
        System.out.println(t.value);


    }

}
