package com.mancillajair.app.peek.clases;
public class Request {
    private int walker;
    private int owner;
    private String image;
    private String status;
    private String[] img_dogs;
    private String address;
    private String name;

    public int getWalker() { return walker; }
    public void setWalker(int walker) { this.walker = walker; }

    public int getOwner() { return owner; }
    public void setOwner(int owner) { this.owner = owner; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String[] getImg_dogs() { return img_dogs; }
    public void setImg_dogs(String[] img_dogs) { this.img_dogs = img_dogs; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Request(int walker, int owner, String image, String status, String[] img_dogs, String address, String name) {
        this.walker = walker;
        this.owner = owner;
        this.image = image;
        this.status = status;
        this.img_dogs = img_dogs;
        this.address = address;
        this.name = name;
    }

    public Request(){
        this.walker = 0;
        this.owner = 0;
        this.image = "";
        this.status = "";
        this.address = "";
        this.name = "";
    }
}
