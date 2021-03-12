package com.mancillajair.app.peek.clases;

import com.mancillajair.app.peek.menu.Dog;

import java.util.ArrayList;

public class Owner {
    private int id;
    private String name;
    private String email;
    private String cellphone;
    private String image;
    private double rating;
    private String street;
    private String houseNum;
    private String city;
    private String card;
    private int expirMonth;
    private int expirYear;
    private int securityCode;
    private String password;
    private ArrayList<Historial> historials;
    private ArrayList<Dog> dogs;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCellphone() { return cellphone; }
    public void setCellphone(String cellphone) { this.cellphone = cellphone; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getHouseNum() { return houseNum; }
    public void setHouseNum(String houseNum) { this.houseNum = houseNum; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCard() { return card; }
    public void setCard(String card) { this.card = card; }

    public int getExpirMonth() { return expirMonth; }
    public void setExpirMonth(int expirMonth) { this.expirMonth = expirMonth; }

    public int getExpirYear() { return expirYear; }
    public void setExpirYear(int expirYear) { this.expirYear = expirYear; }

    public int getSecurityCode() { return securityCode; }
    public void setSecurityCode(int securityCode) { this.securityCode = securityCode; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public ArrayList<Historial> getHistorials() { return historials; }
    public void setHistorials(ArrayList<Historial> historials) { this.historials = historials; }

    public ArrayList<Dog> getDogs() { return dogs; }
    public void setDogs(ArrayList<Dog> dogs) { this.dogs = dogs; }

    public Owner(){
        this.id = 0;
        this.name = "";
        this.email="";
        this.cellphone="";
        this.image="";
        this.rating=0.0;
        this.street="";
        this.houseNum="";
        this.city="";
        this.card="";
        this.expirMonth=0;
        this.expirYear=0;
        this.securityCode=0;
        this.password="";
        this.historials= new ArrayList<Historial>();
        this.dogs= new ArrayList<Dog>();
    }
    public Owner(int id,String name,String email,String cellphone,String image,double rating,String street,String houseNum,String city,
                 String card,int expirMonth ,int expirYear,int securityCode, String password,ArrayList<Historial> historials){
        this.id = id;
        this.name = name;
        this.email=email;
        this.cellphone=cellphone;
        this.image=image;
        this.rating=rating;
        this.street=street;
        this.houseNum=houseNum;
        this.city=city;
        this.card=card;
        this.expirMonth=expirMonth;
        this.expirYear=expirYear;
        this.securityCode=securityCode;
        this.password=password;
        this.historials = historials;
    }


}
