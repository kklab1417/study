//filename��UDPServer.java
import java.net.*;
import java.io.*;
public class UDPServer
{
  public static void main(String[] args)
  {
    UDPServer frm=new UDPServer();
  }
  String strbuf=" ";
  SerThread st;
  public UDPServer()
  {
    st=new SerThread();
    st.start();
  }
}
class SerThread extends Thread
{
  public SerThread() {}
  public void run()
 {
    String str1;
    try
    {
      DatagramSocket skt=new DatagramSocket(8000); 
      System.out.print("����������");
       System.out.println(InetAddress.getLocalHost().getHostName());
      while(true)
      {
        byte[] inBuf=new byte[256];
        DatagramPacket pkt;
        pkt=new DatagramPacket(inBuf,inBuf.length); 
        skt.receive(pkt);
        str1=new String(pkt.getData());
        str1=str1.trim();
        if(str1.length()>0)
        {
          int pot=pkt.getPort();
          System.out.println("Զ�̶˿ڣ�"+pot);
          System.out.println("�������ѽ��յ���Ϣ��"+str1);
        }
      }
    }catch (IOException e) { return;  }
  }
}
