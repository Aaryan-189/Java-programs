class parent{
    String name = "Aaryan";
    parent(){
        System.out.println("Parent");
    }
    void show(){
        System.out.println("Parent Class");
    }
}
class child extends parent{
    String name = "Harsh";
    child(){
        super();
        System.out.println("Child");
    }
    void namep(){
        System.out.println("Parent Name : "+ super.name);
    }
    void namec(){
        System.out.println("Child Name : "+ this.name);
    }
    void display(){
        this.show();
        super.show();
    }
}
public class this_super{
    public static void main(String[] args) {
        child c = new child();
        c.namep();
        c.namec();
        c.display();
    }
}