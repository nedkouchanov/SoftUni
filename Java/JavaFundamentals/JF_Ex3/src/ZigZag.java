import java.util.Scanner;

public class ZigZag {
        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            int n=Integer.parseInt(input.nextLine());
            String[] str1=new String[n];
            String[] str2=new String[n];
            for(int i=1;i<=n;i++){
                String str=input.nextLine();
                String[] str_new=str.split(" ");
                if(i%2==0){
                    str2[i-1]=str_new[0];
                    str1[i-1]=str_new[1];
                }else{
                    str1[i-1]=str_new[0];
                    str2[i-1]=str_new[1];
                }
            }
            for(int j=0;j<n;j++){
                System.out.printf("%s ",str1[j]);
            }
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.printf("%s ",str2[j]);
            }
        }
    }

