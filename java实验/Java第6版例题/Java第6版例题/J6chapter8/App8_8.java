//filename��App8_8.java
class Person
{
  protected String name;
  public Person(String xm)
  {
    name=xm;
  }
}
public class App8_8
{
  public static void main(String[] args)
  {
    Person per=new Person("����");
    Class obj=per.getClass();
    System.out.println("����per��������Ϊ��"+obj);
    System.out.println("����per�Ƿ��ǽӿڣ�"+obj.isInterface());
  }
}
