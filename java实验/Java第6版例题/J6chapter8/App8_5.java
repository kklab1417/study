//filename��App8_5.java
class Person
{
  protected String name;
  protected int age;
  public Person(String name, int age)
  {
    this.name=name;
    this.age=age;
  }
  protected void show()
  {
    System.out.println("������"+name+"  ���䣺"+age);
  }
}
class Student extends Person
{
  private String department;
  public Student (String name,int age,String dep)
  {
    super(name,age);
    department=dep;
  }
  protected void show()
  {
    System.out.println("ϵ��"+ department);
  }
  public void subShow()
  {
    System.out.println("����������");
  }
}
public class App8_5
{
  public static void main(String[] args)
  {
    Person per=new Student("������",24, "����");
    per.show();
    //per.subShow();
  }
}
