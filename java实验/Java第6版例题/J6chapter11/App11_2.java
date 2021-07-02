//filename��App11_2.java
class MyThread implements Runnable
{
  private String who;
  public MyThread(String str)
  {
    who=str; 
  }
  public void run()
  {
    for(int i=0;i<5;i++)
    {
      try
      {
        Thread.sleep((int)(1000*Math.random()));
      }
      catch(InterruptedException e) 
      {
        System.out.println(e.toString());
      }
      System.out.println(who+"�������У���");
    }
  }
}
public class App11_2
{
  public static void main(String[] args)
  {
    MyThread you=new MyThread("��");
    MyThread she=new MyThread("��");
    Thread t1=new Thread(you);
    Thread t2=new Thread(she);
    t1.start();
    t2.start();
  }
}
