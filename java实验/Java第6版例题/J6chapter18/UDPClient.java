//filename��UDPClient.java
import java.net.*;
import java.io.*;
public class UDPClient
{
  public static void main(String[] args)
  {
    UDPClient frm=new UDPClient();
  }
  CliThread ct;
  public UDPClient()
  {
    ct=new CliThread();
    ct.start();
  }
}
class CliThread extends Thread
{
  public CliThread() {}
  public void run()
 {
    String str1;
    String serverName="cgj-PC";
    System.out.println("�뷢����Ϣ����������"+serverName +"��");
    try
    {
      DatagramSocket skt=new DatagramSocket();
      DatagramPacket pkt;
      while(true)
      {
        BufferedReader buf;
        buf=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("��������Ϣ��");
        str1=buf.readLine();
        byte[] outBuf=new byte[str1.length()];
        outBuf=str1.getBytes();
        InetAddress address=InetAddress.getByName(serverName); 
        pkt=new DatagramPacket(outBuf,outBuf.length,address,8000);
        skt.send(pkt);
      }
    }catch(IOException e) {}
  }
}
