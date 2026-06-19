public class arm10000 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            int temp = i, sum = 0, digits = String.valueOf(i).length();
            while (temp > 0) {
                sum += Math.pow(temp % 10, digits);
                temp /= 10;
            }
            if (sum == i) System.out.print(i + " ");
        }
    }
}