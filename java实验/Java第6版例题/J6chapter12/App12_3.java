//filename App12_3.java
class GenMet<T>
{
  private T t;
  public T getObj()
  {
    return t;
  }
  public void setObj(T t)
  {
    this.t=t;
  }
  public <U> void display(U u)
  {
    System.out.println("����������Ͳ���T��"+t.getClass().getName());
    System.out.println("���ͷ��������Ͳ���U��"+u.getClass().getName());
  }
}
public class App12_3
{
  public static void main(String[] args)
  {
    GenMet<Integer> gen=new GenMet<Integer>();
    gen.setObj(5);
    System.out.println("��һ�������");
    gen.display("�����ı�");
    System.out.println("�ڶ��������");
    gen.display(8.0);
  }
}
