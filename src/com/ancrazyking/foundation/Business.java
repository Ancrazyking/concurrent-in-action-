package com.ancrazyking.foundation;

/**
 * @author Ancrazyking
 * @date 2018/6/7 22:16
 **/
public class Business
{
    private boolean bShoudSub=false;
    /**
     * 子线程循环10次
     * @param i
     */
    public synchronized void sub(int i){
      while(bShoudSub){
          try
          {
              this.wait();
          } catch (InterruptedException e)
          {
              e.printStackTrace();
          }
      }

      for(int j=1;j<=10;j++){
          System.out.println("子线程循环"+j+"次,"+"目前总循环"+i+"次");
      }
      bShoudSub=true;
      this.notify();
    }


    /**
     * 主线程循环100次
     * @param i
     */
    public synchronized void main(int i){

        while(!bShoudSub){
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


        for(int j=1;j<100;j++){
            System.out.println("主线程循环"+j+"次,"+"目前总循环"+i+"次");
        }

        bShoudSub=false;
        this.notify();
    }

}
