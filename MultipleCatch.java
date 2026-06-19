class MultipleCatch{
    public static void main(String[] args){
        try{
            try{
                int a =10/0;
            }
            catch(ArithmeticException e){
                System.out.println("Error"+e.getMessage());
            }
            try{
                int arr[] = new int[5];
                arr[10] = 50;
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Error"+e.getMessage());
            }
        }
        catch(NullPointerException e){
            System.out.println("Error"+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
        System.out.println("Done");
    }
}
