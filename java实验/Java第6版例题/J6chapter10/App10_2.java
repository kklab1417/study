//filename��App10_2.java
import java.io.*;
public class App10_2
{
  public static void main(String[] args) throws IOException
  {
    try(
      FileInputStream fi=new FileInputStream("�羰.jpg");
      FileOutputStream fo=new FileOutputStream("�羰1.jpg");
    )
    {
      System.out.println("�ļ��Ĵ�С="+fi.available());
      byte[] b=new byte[fi.available()];
      fi.read(b);
      fo.write(b);
      System.out.println("�ļ��ѱ�������������");
    }
  }
}
