//filename��App13_4.java
public class App13_4
{
  public static void main(String[] args)
  {
    (
      new Inner()
      {
        void setName(String n)
        {
          name=n;
          System.out.println("������"+name);
        }
      }
    ).setName("��  ��");
  }
  static class Inner
  {
    String name;
  }
}
