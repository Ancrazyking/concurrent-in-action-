package com.ancrazyking.foundation;

/**
 * @author Ancrazyking
 * @date 2018/6/7 14:45
 **/
public class TraditionalThreadCommunction
{
    public static void main(String[] args)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 1; i <= 50; i++)
                {
                    synchronized (TraditionalThreadCommunction.class)
                    {
                        for (int j = 1; j <=10; j++)
                        {
                            System.out.println("sub thread sequece of " + j + ",loop of" + i);
                        }
                    }
                }

            }
        }).start();


        for (int i = 1; i <= 50; i++)
        {

            synchronized (TraditionalThreadCommunction.class)
            {
                for (int j = 1; j <= 100; j++)
                {
                    System.out.println("main thread squece of " + j + ",loop of" + i);
                }
            }
        }


    }

}
