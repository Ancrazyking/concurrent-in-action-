package com.ancrazyking.foundation;

/**
 * @author Ancrazyking
 * @date 2018/6/7 12:39
 * 这是一个多线程,由于同时操作不同的,进程间的互斥
 **/
public class TraditionalThreadSynchronized
{

    public static void main(String[] args)
    {

        Outputer outputer = new Outputer();
        //启动线程1
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    outputer.output("wangafeng");
                }
            }
        }).start();

        //启动线程2
        //启动线程1
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    outputer.output("ancrazyking");
                }
            }
        }).start();


    }


    /**
     * 锁的时候要锁的是同一个对象
     */

    static class Outputer
    {
       /* public void output(String name)
        {
            int len = name.length();
            synchronized (Outputer.class)
            {
                for (int i = 0; i < len; i++)
                {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }*/


/*        public void output(String name)
        {
            int len = name.length();

            //好像是只要锁住同一个对象就行
            synchronized (String.class){
                for (int i = 0; i < len; i++)
                {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }*/

        /**
         * synchronized的两种用法
         * synchronized()括号里面放入对象
         * synchronized修饰方法
         * @param name
         */
        public synchronized  void output(String name){
            int len = name.length();
            for (int i = 0; i < len; i++)
            {
                System.out.print(name.charAt(i));
            }
            System.out.println();

        }
    }
}

