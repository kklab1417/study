//filename��App8_2.java
class Person
{
  private String name; 
  private int age; 
  public Person()
  {
    System.out.println("������Person����޲ι��췽��");
  }
  public Person(String name, int age)
  {
    System.out.println("������Person����вι��췽��");
    this.name=name;
    this.age=age;
  }
  public void show()
  {
    System.out.println("������"+name+"  ���䣺"+age);
  }
}
class Student extends Person
{
  private String department;
  public Student()
  {
    System.out.println("������ѧ������޲ι��췽��Student()");
  }
  public Student (String name,int age,String dep)
  {
    super(name,age);
    department=dep;
    System.out.println("����"+department +"��ѧ��");
    System.out.println("������ѧ������вι��췽��Student(String name,int age,String dep) ");
  }
}
public class App8_2
{
  public static void main(String[] args)
  {
    Student stu1=new Student();
    Student stu2=new Student("��С��",23, "��Ϣϵ");
    stu1.show();
    stu2.show();
  }
}
