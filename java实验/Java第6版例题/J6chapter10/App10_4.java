//filename��App10_4.java
import java.io.*;
public class App10_4
{
  public static void main(String[] args)
  {
    try
    {
      byte[] b=new byte[128];
      System.out.print("�������ַ���");
      int count=System.in.read(b);
      System.out.println("������ǣ�");
      for(int i=0;i<count;i++)
        System.out.print(b[i]+ " ");
      System.out.println();
      for(int i=0;i<count-2;i++)
        System.out.print((char)b[i]+ "  ");
      System.out.println();
      System.out.println("������ַ�����Ϊ"+count);
      Class InClass=System.in.getClass();
      Class OutClass=System.out.getClass();
      System.out.println("in���ڵ����ǣ�"+InClass.toString());
      System.out.println("out���ڵ����ǣ�"+OutClass.toString());
    }
    catch(IOException e) { }
  }
}
