import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Father {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Размер на присъдата?(Год. Мес. Дни)");
        String time = scan.nextLine();
        System.out.println("Дата?(гггг-мм-дд)");
        String date = scan.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            //Setting the date to the given date
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] tokens = time.split("\\s+");
        int years = Integer.parseInt(tokens[0]);
        int months = Integer.parseInt(tokens[1]);
        int days = Integer.parseInt(tokens[2]);
        double timeInDays = (years * 365) + (months * 30) + days;
        System.out.println("Опасен рецидив?(Да/Не)");
        String tip = scan.nextLine().toLowerCase();
        if (tip.equals("да")) {
            timeInDays = Math.floor(timeInDays * (2.0 / 3.0));
        } else if (tip.equals("не")) {
            timeInDays = Math.floor(timeInDays / 2.0);
        }
        double yearsTo = Math.floor(timeInDays / 365);
        double monthsTo = Math.floor((timeInDays - (yearsTo * 365)) / 30);
        double daysTo = Math.floor((timeInDays - (yearsTo * 365) - monthsTo * 30));
        System.out.printf("Необходим минимум %.0f год. %.0f мес. %.0f дни.%n", yearsTo, monthsTo, daysTo);
        c.add(Calendar.DAY_OF_MONTH, (int) timeInDays);
        String newDate = sdf.format(c.getTime());
        System.out.println("Дата, на която придобива право на УПО: "+newDate);
    }
}
