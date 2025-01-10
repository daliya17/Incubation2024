package Java8.Streams;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address( String city) {
        this.street = "123 Main St";
        this.city = city;
        this.state = "state";
        this.zip = "43567";
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
