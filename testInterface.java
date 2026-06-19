import java.io.*;

interface test_interf{
    final int a = 10;
    void display();
}

class TestClass implements test_interf{

    public void display(){ 
      System.out.println("Geek"); 
    }
}

class testInterface{
    
    public static void main(String[] args){
        
        TestClass t = new TestClass();
        t.display();
        System.out.println(t.a);
    }
}
