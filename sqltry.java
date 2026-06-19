class sqltry{
    public static void main(String[] args){
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver Loaded Successfully!");
} catch (ClassNotFoundException e) {
    System.out.println("Driver Not Found: " + e.getMessage());
}
    }
}