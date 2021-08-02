import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String string=input.nextLine();
        String string2=input.nextLine();
        String[] strArray=string.split(" ");
        String[] strAraray2=string2.split(" ");
        for (int i=0;i<strAraray2.length;i++){
            for(int j=0;j<strArray.length;j++){
                if(strAraray2[i].equals(strArray[j])){
                    System.out.printf("%s ",strAraray2[i]);
                }
            }
        }

    }
}