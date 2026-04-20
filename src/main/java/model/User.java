package model;

public class User {
    
    public static class Address {
        public Geo geo;
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        
        public Address() {}
    }
        public int id;
        public String name;
        public String username;
        public String email;
        public Address address;
        public String phone;
        public String website;
        public Company company;
        public User() {}
        public void userInfo() {
            System.out.println("Name: " + this.name);
            System.out.println("Phone: " + this.phone);
            System.out.println("Email: " + this.email);
            System.out.println("Company name: " + this.company.name);
        }
}
