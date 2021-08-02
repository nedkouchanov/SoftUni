import java.util.Scanner;

public class ArrayRotation {
        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            String str=input.nextLine();
            String[] strings=str.split(" ");
            int[] arr=new int[strings.length];
            int temp=0;
            int[] new_arr=new int[arr.length];

            int n=Integer.parseInt(input.nextLine());
            n=n%arr.length;
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(strings[i]);
            }
            for(int i=0;i<n;i++){
                temp=arr[0];
                for(int a=0;a<arr.length;a++){

                    if(a<arr.length-1){
                        new_arr[a]=arr[a+1];
                    }else{
                        new_arr[arr.length-1]=temp;
                        arr=new_arr;
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }

        }
    }

