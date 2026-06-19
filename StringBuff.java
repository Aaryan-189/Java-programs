public class StringBuff {
    public static void main(String[] args) {
        // create StringBuffer
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb);
        sb.insert(6, "Beautiful ");
        System.out.println(sb);
        sb.replace(6, 16, "To This ");
        System.out.println(sb);
        sb.delete(6, 14);
        System.out.println(sb);
        
    }
}