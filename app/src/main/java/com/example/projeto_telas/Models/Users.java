package com.example.projeto_telas.Models;

import org.json.JSONObject;

public class Users {
        private int id;
        private String name;
        private String username;
        private String email;
        Address AddressObject;
        private String phone;
        private String website;
        Company CompanyObject;


        public Users(int id, String name, String username, String email, Address AddressObject, String phone, String website, Company CompanyObject) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.AddressObject = AddressObject;
        this.phone = phone;
        this.website = website;
        this.CompanyObject = CompanyObject;
    }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public Address getAddress() {
            return AddressObject;
        }

        public String getPhone() {
            return phone;
        }

        public String getWebsite() {
            return website;
        }

        public Company getCompany() {
            return CompanyObject;
        }


        public void setId( int id ) {
            this.id = id;
        }

        public void setName( String name ) {
            this.name = name;
        }

        public void setUsername( String username ) {
            this.username = username;
        }

        public void setEmail( String email ) {
            this.email = email;
        }

        public void setAddress( Address addressObject ) {
            this.AddressObject = addressObject;
        }

        public void setPhone( String phone ) {
            this.phone = phone;
        }

        public void setWebsite( String website ) {
            this.website = website;
        }

        public void setCompany( Company companyObject ) {
            this.CompanyObject = companyObject;
        }

    public Users(JSONObject json) {
        this.name = "";
        this.username = "";
        this.email = "";
        this.AddressObject = new Address(); // Inicialização padrão
        this.phone = "";
        this.website = "";
        this.CompanyObject = new Company(); // Inicialização padrão

        try {
            this.id = json.getInt("id");
            this.name = json.getString("name");
            this.username = json.getString("username");
            this.email = json.getString("email");
            this.phone = json.getString("phone");
            this.website = json.getString("website");

            JSONObject addressJson = json.getJSONObject("address");
            this.AddressObject = new Address();
            JSONObject companyJson = json.getJSONObject("company");
            this.CompanyObject = new Company();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class Company {
        private String name;
        private String catchPhrase;
        private String bs;


        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setName( String name ) {
            this.name = name;
        }

        public void setCatchPhrase( String catchPhrase ) {
            this.catchPhrase = catchPhrase;
        }

        public void setBs( String bs ) {
            this.bs = bs;
        }
    }

    public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        Geo GeoObject;


        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public Geo getGeo() {
            return GeoObject;
        }


        public void setStreet( String street ) {
            this.street = street;
        }

        public void setSuite( String suite ) {
            this.suite = suite;
        }

        public void setCity( String city ) {
            this.city = city;
        }

        public void setZipcode( String zipcode ) {
            this.zipcode = zipcode;
        }

        public void setGeo( Geo geoObject ) {
            this.GeoObject = geoObject;
        }
    }
    public class Geo {
        private String lat;
        private String lng;



        public String getLat() {
            return lat;
        }

        public String getLng() {
            return lng;
        }

           public void setLat( String lat ) {
            this.lat = lat;
        }

        public void setLng( String lng ) {
            this.lng = lng;
        }
    }
}
