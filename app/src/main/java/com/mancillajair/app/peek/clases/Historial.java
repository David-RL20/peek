package com.mancillajair.app.peek.clases;

public class Historial {
    private int id;
    private int idWalker;
    private int idOwner;
    private int status;
    private String date;
    private GeoLocation start;
    private GeoLocation end;


    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    public int getIdWalker() { return idWalker; }
    public void setIdWalker(int idWalker) { this.idWalker = idWalker; }

    public int getIdOwner() { return idOwner; }
    public void setIdOwner(int idOwner) { this.idOwner = idOwner; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public GeoLocation getStart() { return start; }
    public void setStart(GeoLocation start) { this.start = start; }

    public GeoLocation getEnd() { return end; }
    public void setEnd(GeoLocation end) { this.end = end; }

    public Historial(){
        this.id = 0;
        this.idWalker=0;
        this.idOwner=0;
        this.status=0;
        this.date= "";
        this.start=new GeoLocation();
        this.end = new GeoLocation();
    }
    public Historial(int id,int idWalker,int idOwner,int status,String date,GeoLocation geoStar,GeoLocation geoEnd){
        this.id = id;
        this.idWalker=idWalker;
        this.idOwner=idOwner;
        this.status=status;
        this.date= date;
        this.start= geoStar;
        this.end = geoEnd;
    }
    public String toString(){
        return null;
    }
}
