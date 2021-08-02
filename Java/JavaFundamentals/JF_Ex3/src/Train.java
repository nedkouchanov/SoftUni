import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(scan.nextLine());
            arr[i]= count;
            sum+=arr[i];
        }
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
