import java.util.*;

class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

public class SortAddress {
    public static void main(String[] args) {
        List<Address> addresses = Arrays.asList(
            new Address("Mumbai", "India"),
            new Address("New York", "USA"),
            new Address("Delhi", "India"),
            new Address("New York", "Canada"),
            new Address("Berlin", "Germany")
        );

        addresses.sort(
            Comparator.comparing(Address::getCity)
                      .thenComparing(Address::getCountry)
        );

  
        addresses.forEach(System.out::println);
    }
}
