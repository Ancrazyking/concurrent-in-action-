package com.ancrazyking.foundation;

/**
 * @author Ancrazyking
 * @date 2018/6/7 22:21
 **/
public class ThreadTest
{


    public static void main(String[] args){
        Business business=new Business();

        for(int i=1;i<=50;i++)
        {
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





}
