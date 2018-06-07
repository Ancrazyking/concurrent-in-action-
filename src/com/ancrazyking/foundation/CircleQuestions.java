package com.ancrazyking.foundation;

/**
 * @author Ancrazyking
 * @date 2018/6/7 15:57
 * 子线程循环10次,接着主线程循环100次,接着又回到子线程10次,接着又回到主线程又循环100次,如此循环50次
 **/
public class CircleQuestions
{
    public static void main(String[] args)
    {
        Business business = new Business();
     /*   new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=1;i<=50;i++){
                    business.sub(i);
                }
            }
        }).start();

        for(int i=1;i<=50;i++){
            business.main(i);
        }*/

        for(int i=0;i<50;i++){
            int j=i;
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    business.sub(j);
                }
            }).start();

            business.main(i);

        }



    }


    static class Business
    {
        private boolean bShouldSub = true;

        /**
         * 首先执行子进程
         */
        public synchronized void sub(int i)
        {
            while (!bShouldSub)
            {
                try
                {
                    this.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++)
            {
                System.out.println("sub thread sequence of " + j + ",loop of " + i);
            }
            bShouldSub = false;
            this.notify();
        }

        public synchronized void main(int i)
        {
            while (bShouldSub)
            {
                try
                {
                    this.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 100; j++)
            {

                System.out.println("main thread sequence of " + j + ",loop of" + i);
            }
            bShouldSub = true;
            this.notify();
        }
    }
}
