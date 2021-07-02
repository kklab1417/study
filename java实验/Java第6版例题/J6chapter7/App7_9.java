//filename��App7_9.java
class Cylinder
{
  private static int num=0; 
  private static double pi=3.14; 
  private double radius;
  private int height;
  public Cylinder(double r,int h) 
  {
    radius=r;
    height=h;
    num++;
  }
  public static void count()
  {
    System.out.println("������"+num+"������");
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
public class App7_9
{
  public static void main(String[] args)
  {
    Cylinder.count();
    Cylinder volu1=new Cylinder(2.5,3);
    volu1.count();
    System.out.println("Բ��1�����="+volu1.volume());
    Cylinder volu2=new Cylinder(1.0,2);
    Cylinder.count();
    System.out.println("Բ��2�����="+volu2.volume());
  }
}
