//filename��Out.java   ��13.3
public class Out
{
  private int age;
  public class Student
  {
    String name;
    public Student(String n,int a)
    {
      name=n;
      age=a;
    }
    public void output()
    {
      System.out.println("������"+this.name+"�����䣺"+age);
    }
  }
  public void output()
  {
    Student stu=new Student("��  ��",24);
    stu.output();
  }
  public static void main(String[] args)
  {
    Out g=new Out();
    g.output();
  }
}
