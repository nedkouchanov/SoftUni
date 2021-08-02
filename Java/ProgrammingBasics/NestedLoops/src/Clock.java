public class Clock {
    public static void main(String[] args) {
        for (int big = 0; big < 24; big++) {
            for (int small = 0; small < 60; small++) {
                System.out.printf("%d:%d%n", big, small);
            }
        }
    }
}
