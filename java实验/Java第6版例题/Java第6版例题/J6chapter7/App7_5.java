//filename��App7_5.java
class Cylinder
{
  private double radius;
  private int height; 
  private double pi=3.14;
  String color;
  public Cylinder()
  {
    radius=1;
    height=2;
    color="��ɫ";
  }
  public Cylinder(double r, int h, String str)
  {
    radius=r;
    height=h;
    color=str;
  }
  public void setColor()
  {
    System.out.println("��Բ������ɫΪ��"+color);
  }
  double area()
  {
    return pi*radius*radius;
  }
  double volume()
  {
    return area()*height;
  }
}
public class App7_5
{
  public static void main(String[] args)
  {
    Cylinder volu1=new Cylinder();
    System.out.println("Բ��1�����="+ volu1.area());
    System.out.println("Բ��1���="+volu1.volume());
    volu1.setColor();
    Cylinder volu2=new Cylinder(2.5,8,"��ɫ");
    System.out.println("Բ��2�����="+ volu2.area());
    System.out.println("Բ��2���="+volu2.volume());
    volu2.setColor();
  }
}
