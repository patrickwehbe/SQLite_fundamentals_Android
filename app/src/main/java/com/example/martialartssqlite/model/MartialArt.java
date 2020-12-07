package com.example.martialartssqlite.model;

public class MartialArt {
    private int martialArtId;
    private String martialArtname;
    private double martialArtPrice;
    private String martialArtColor;


    public MartialArt(int id, String name, double price, String color){
        setMartialArtId(id);
        setMartialArtname(name);
        setMartialArtPrice(price);
        setMartialArtColor(color);

    }

    public int getMartialArtId() {
        return martialArtId;
    }

    public String getMartialArtname() {
        return martialArtname;
    }

    public double getMartialArtPrice() {
        return martialArtPrice;
    }

    public String getMartialArtColor() {
        return martialArtColor;
    }

    public void setMartialArtId(int martialArtId) {
        this.martialArtId = martialArtId;
    }

    public void setMartialArtname(String martialArtname) {
        this.martialArtname = martialArtname;
    }

    public void setMartialArtPrice(double martialArtPrice) {
        this.martialArtPrice = martialArtPrice;
    }

    public void setMartialArtColor(String martialArtColor) {
        this.martialArtColor = martialArtColor;
    }
    @Override
    public String toString(){
        return getMartialArtId() + " " + getMartialArtname() + " " + getMartialArtPrice() + " " + getMartialArtColor() +  " ";

    }
}
