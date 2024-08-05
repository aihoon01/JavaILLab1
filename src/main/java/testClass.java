import java.util.Arrays;

public class testClass {
    public static void main(String[] args) {
        System.out.println(initials("John Doe"));
    }
    public static String initials(String names){
        String[] nameArray = names.split(" ");
        String firstnames="";
        for(String name: nameArray) {
            Character initial = name.charAt(0);
            firstnames = firstnames+initial+".";
        }
        return firstnames.substring(0, firstnames.length()-1);
    }

    public static int prices(int[] priceList){
        int total = 0;
        for(int price: priceList) {
            total += price;
        }
        return total;
    }
}
