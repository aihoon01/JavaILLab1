package Exercise06;

public class Main {
    public static void main(String[] args) {
        var customer = new Customer();

        for(int i=0; i<10; i++) {
            int index =(int) (Math.random()*1000);
            customer.addCustomer("Stephen " + String.valueOf(index), "spka199@gmail.com");
        }
        customer.getCustomers();
    }
}
