//filename��App8_4.java
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
}
public class App8_4
{
  public static void main(String[] args)
  {
    Student stu=new Student("������",24, "����");
    stu.show();
  }
}
