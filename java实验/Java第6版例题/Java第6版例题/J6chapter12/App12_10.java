//filename��App12_10.java
import java.util.*;
public class App12_10
{
  public static void main(String[] args)
  {
    Set<String> hs=new HashSet<String>();
    hs.add("��  ɮ");
    hs.add("�����");
    hs.add("��˽�");
    hs.add("ɳ����");
    hs.add("������");
    TreeSet<String> ts=new TreeSet<String>(hs);
    System.out.println("�����ϣ�"+ts);
    System.out.println("�����ϵĵ�һ��Ԫ�أ�"+ts.first());  
    System.out.println("���������һ��Ԫ�أ�"+ts.last());
    System.out.println("haedSet(�����)��Ԫ�أ�"+ts.headSet("�����"));
    System.out.println("tailSet(�����)��Ԫ�أ�"+ts.tailSet("�����"));
    System.out.println("ceiling (ɳ)��Ԫ�أ�"+ts.ceiling ("ɳ"));
  }
}
