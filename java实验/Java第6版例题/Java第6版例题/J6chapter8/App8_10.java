//filename��App8_10.java
abstract class Shape
{
  protected String name;
  public Shape(String xm)
  {
    name=xm;
    System.out.print("���ƣ�"+name);
  }
  abstract public double getArea();
  abstract public double getLength();
}
class Circle extends Shape
{
  private final double PI=3.14;
  private double radius;
  public Circle(String shapeName,double r)
  {
    super(shapeName);
    radius=r;
  }
  public double getArea() 
  {
    return PI*radius*radius;
  }
  public double getLength()
  {
    return 2*PI*radius;
  }
}
class Rectangle extends Shape
{
  private double width;
  private double height;
  public Rectangle(String shapeName,double width,double height)
  {
    super(shapeName);
    this.width=width;
    this.height=height;
  }
  public double getArea()
  {
    return width*height;
  }
  public double getLength()
  {
    return 2*(width+height);
  }
}
public class App8_10 
{
  public static void main(String[] args)
  {
    Shape rect =new Rectangle("������",6.5,10.3);
    System.out.print("�����="+rect.getArea());
    System.out.println("���ܳ�="+rect.getLength());
    Shape circle=new Circle("Բ",10.2);
    System.out.print("�����="+circle.getArea());
    System.out.println("���ܳ�="+circle.getLength());
  }
}
