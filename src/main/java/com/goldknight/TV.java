package com.goldknight;

public class TV {

    private String name;
    private String country;
    private int channel;

    public TV(String name, String country, int channel) {
        this.name = name;
        this.country = country;
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
