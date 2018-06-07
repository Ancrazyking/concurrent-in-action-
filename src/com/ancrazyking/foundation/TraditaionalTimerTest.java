package com.ancrazyking.foundation;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Ancrazyking
 * @date 2018/6/7 11:08
 * 传统定时器类的使用
 **/
public class TraditaionalTimerTest
{
    public static void main(String []args){
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("bombing!");
            }
        },10000,3000);
        while(true){
            System.out.println(new Date().getSeconds());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
