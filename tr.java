class tr {
    public static void main(String arg[]) {
        StringBuilder str = new StringBuilder("a");
        int k = 5;
        while (str.length() <= k) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                // Stop at 'z' to avoid invalid characters
                if (ch == 'z') continue;
                str.append((char)(ch + 1));
            }
        }

        return str.charAt(k);
    }
}

