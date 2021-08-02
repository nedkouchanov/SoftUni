public class da {
    public static void main(String[] args) {
        int count = 1000;
        for (int i = 1; i < count; i++) {
            if (i > 900) {
                count--;
            }
            for (int j = 1; j < i; j++) {
                if (j % 200 == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
