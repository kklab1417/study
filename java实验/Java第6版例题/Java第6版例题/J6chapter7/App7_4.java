//filename��App7_4.java
class Cylinder
{
  private double radius;
  private int height; 
  private double pi=3.14;
  public Cylinder(double r, int h)
  {
    radius=r;
    height=h;
  }
  double area()
  {
    return pi* radius* radius;
  }
  double volume()
  {
    return area()*height;
  }
}
public class App7_4
{
  public static void main(String[] args)
  {
    Cylinder volu=new Cylinder(3.5, 8);
    System.out.println("Բ�������="+ volu.area());
    System.out.println("Բ�������="+volu.volume());
  }
}
