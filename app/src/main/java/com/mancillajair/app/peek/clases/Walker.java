package com.mancillajair.app.peek.clases;

import java.util.ArrayList;

public class Walker {
    private int id;
    private String name;
    private String email;
    private String cellphone;
    private String image;
    private double rating;
    private String street;
    private int houseNum;
    private String city;
    private String card;
    private int expirMonth;
    private int expirYear;
    private int securityCode;
    private String password;
    private GeoLocation currentLocation;
    private String size;
    private String breed;
    private String playful;
    private String dogFriendly;
    private String peopleFriendly;
    private String description;
    private String gender;
    private String vaccines;
    private String drooling;
    private double priceSmall;
    private double priceMedium;
    private double priceBig;
    private double time;
    private double distance;
    private GeoLocation star;
    private GeoLocation end;
    private ArrayList<Historial> historial;


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

    public int getHouseNum() { return houseNum; }
    public void setHouseNum(int houseNum) { this.houseNum = houseNum; }

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

    public GeoLocation getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(GeoLocation currentLocation) { this.currentLocation = currentLocation; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public String getPlayful() { return playful; }
    public void setPlayful(String playful) { this.playful = playful; }

    public String getDogFriendly() { return dogFriendly; }
    public void setDogFriendly(String dogFriendly) { this.dogFriendly = dogFriendly; }

    public String getPeopleFriendly() { return peopleFriendly; }
    public void setPeopleFriendly(String peopleFriendly) { this.peopleFriendly = peopleFriendly; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getVaccines() { return vaccines; }
    public void setVaccines(String vaccines) { this.vaccines = vaccines; }

    public String getDrooling() { return drooling; }
    public void setDrooling(String drooling) { this.drooling = drooling; }

    public double getPriceSmall() { return priceSmall; }
    public void setPriceSmall(double priceSmall) { this.priceSmall = priceSmall; }

    public double getPriceMedium() { return priceMedium; }
    public void setPriceMedium(double priceMedium) { this.priceMedium = priceMedium; }

    public double getPriceBig() { return priceBig; }
    public void setPriceBig(double priceBig) { this.priceBig = priceBig; }

    public GeoLocation getStar() { return star; }
    public void setStar(GeoLocation star) { this.star = star; }

    public GeoLocation getEnd() { return end; }
    public void setEnd(GeoLocation end) { this.end = end; }

    public ArrayList<Historial> getHistorial() { return historial; }
    public void setHistorial(ArrayList<Historial> historial) { this.historial = historial; }
    public  Walker(int a){

    }
    public Walker(){
        this.id = 0;
        this.name = "";
        this.email="";
        this.cellphone="";
        this.image="";
        this.rating=0.0;
        this.street="";
        this.houseNum=0;
        this.city="";
        this.card="";
        this.expirMonth=0;
        this.expirYear=0;
        this.securityCode=0;
        this.password="";
        this.currentLocation = new GeoLocation();
        this.size="";
        this.breed="";
        this.playful="";
        this.dogFriendly="";
        this.peopleFriendly="";
        this.description="";
        this.gender="";
        this.vaccines="";
        this.drooling="";
        this.priceSmall=0.0;
        this.priceMedium=0.0;
        this.priceBig=0.0;
        this.distance=0.0;
        this.time=0.0;
        this.star = new GeoLocation();
        this.end= new GeoLocation();
        this.historial = new ArrayList<Historial>();
    }
    public Walker(int id,String name,String email,String cellphone,String image,double rating,String street,int houseNum,String city,
                  String card,int expirMonth ,int expirYear,int securityCode, String password, GeoLocation currentLoc,String size,String breed,
                  String playful,String dogFriendly,String peopleFriendly,String description,String gender,String vaccines ,String drooling
                  ,double priceSmall,double time, double distance, double priceMedium,double priceBig,GeoLocation star,GeoLocation end,ArrayList<Historial> historial){
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
        this.currentLocation =currentLoc;
        this.size=size;
        this.breed=breed;
        this.playful=playful;
        this.dogFriendly=dogFriendly;
        this.peopleFriendly=peopleFriendly;
        this.description=description;
        this.gender=gender;
        this.vaccines=vaccines;
        this.drooling=drooling;
        this.priceSmall=priceSmall;
        this.priceMedium=priceMedium;
        this.priceBig=priceBig;
        this.distance = distance;
        this.time = time;
        this.star = star;
        this.end= end;
        this.historial = historial;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
