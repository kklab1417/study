//filename��App13_8.java
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;
public class App13_8
{
  public static void main(String[] args)
  {
    String[] names={"��ɮ ","����� ","��˽� ","ɳ����"};
    List<String> al=Arrays.asList(names);
    System.out.print("�������ڲ��෽ʽ���������");
    al.forEach(new Consumer<String>()
      {
        @Override
        public void accept(String s)
        {
           System.out.print(s);
        }
      }
    );
    System.out.print("\nʹ��Lambda���ʽ���������");  
    al.forEach((s)->System.out.print(s));
    //al.forEach(System.out::print);
  }
}
