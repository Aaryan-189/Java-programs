class MyEx extends Exception { MyEx(String msg) { super(msg); } }

public class ExceptionKeywords {
    static void check(boolean fail) throws MyEx { 
        if (fail) throw new MyEx("Failed!"); 
    }

    public static void main(String[] args) {
        try { 
            check(true); 
        } catch (MyEx e) { 
            System.out.println("Caught: " + e.getMessage()); 
        } finally { 
            System.out.println("Finally block executed."); 
        }
    }
}