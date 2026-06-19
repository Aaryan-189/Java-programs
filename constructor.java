class parent{
    parent(int x){
        System.out.println("Parent");
    }
}
class child extends parent{
    child(){
        super(10);
        System.out.println("Child");
    }
}
public class constructor{
    public static void main(String[] args) {
        child c = new child();
    }
}