package Exercise06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer implements Comparable<Customer> {

    private String name;
    private String email;
    private final Map<String, String> customers = new HashMap<>();


    public void addCustomer(String name, String email) {
        if(customers.containsKey(name)) {
            System.out.println("Key already exists!");
            return;
        }
        this.customers.put(name, email);
    }

    public String getEmail() {
        return email;
    }

    public void getCustomers() {
        customers.entrySet()
        .stream()
        .map(e -> Arrays.asList(e.getKey(), e.getValue()))
        .forEach(System.out::println);
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
