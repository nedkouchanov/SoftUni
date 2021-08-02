public class MultiplicationTable {
    public static void main(String[] args) {
        for (int first = 1; first < 11; first++) {
            for (int second = 1; second < 11; second++) {
                int result = first * second;
                System.out.printf("%d * %d = %d%n", first, second, result);
            }
        }
    }
}