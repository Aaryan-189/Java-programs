interface Shape{
    void area();
}
class Circle implements Shape{
    int r;
    Circle(int r){
        this.r =  r;
    }
    public void area(){
        System.out.println("Circle Area = "+ (3.14*r*r));
    }
}
class Rectangle implements Shape{
    int l;
    int b;
    Rectangle(int l, int b){
        this.l =  l;
        this.b = b;
    }
    public void area(){
        System.out.println("Rectangle Area = "+ (l*b));
    }
}
public class interface0 {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(5,4);
        Shape s2 = new Circle(7);
        s1.area();
        s2.area();
    }
}