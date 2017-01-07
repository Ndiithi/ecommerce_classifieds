package com.inmobia.classified.dto;

/**
 *
 * @author Duncan Ndiithi
 */
public class Location {

    private String location;
    private int countryId;
    private String countrySymbol;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountrySymbol() {
        return countrySymbol;
    }

    public void setCountrySymbol(String countrySymbol) {
        this.countrySymbol = countrySymbol;
    }

}