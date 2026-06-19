class NegException extends RuntimeException {
    public NegException(String m) {
        super(m);
    }
}

class ExceptionDEMO{
    static void check(int num) {
        if (num < 0) {
            throw new NegException("Number is negative.");
        } else {
            System.out.println("Number is positive.");
        }
    }
    public static void main(String[] args){
        int num = -5;
        try {
            check(num);
        } 
        catch (NegException e) { 
            System.out.println("Exception: " + e.getMessage());
        } 
        finally { 
            System.out.println("Bye");
        }
    }
} 