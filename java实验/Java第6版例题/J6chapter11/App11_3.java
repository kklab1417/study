//filename��App11_3.java
//��App11_1��MyThread����ڴ˴�
public class App11_3
{
  public static void main(String[] args)
  {
    MyThread you=new MyThread("��");
    MyThread she=new MyThread("��");
    you.start();
    try{
      you.join();
    }
    catch(InterruptedException e) {}
    she.start();
    try{
      she.join();
    }
    catch(InterruptedException e) {}
    System.out.println("������main()���н�����");
  }
}
