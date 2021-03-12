package com.mancillajair.app.peek.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mancillajair.app.peek.MainActivity;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.loaders.DogsLoader;

public class Dog extends AppCompatActivity {
    private int id;
    private String name;
    private String image;
    private String dogFriendly;
    private String peopleFriendly;
    private String size;
    private String breed;
    private String gender;
    private String drooling;
    private String playful;
    private String vaccines;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        new DogsLoader(this, 3).execute();
        ImageView ivIconGoToSearch,ivIconHome,ivIconMessage,ivIconProfile;
        //nav
        ivIconGoToSearch = (ImageView) findViewById(R.id.ivIconSearch);
        ivIconHome = (ImageView)findViewById(R.id.ivIconHome);
        ivIconMessage = (ImageView)findViewById(R.id.ivIconMessage);
        ivIconProfile = (ImageView)findViewById(R.id.ivIconProfile);

        ivIconGoToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToSearch = new Intent(Dog.this, Search.class);
                startActivity(intentGoToSearch);
            }
        });

        ivIconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToHome = new Intent(Dog.this, MainActivity.class);
                startActivity(intentGoToHome);
            }
        });
        ivIconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToMessage = new Intent(Dog.this, Messages.class);
                startActivity(intentGoToMessage);
            }
        });
        ivIconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToProfile = new Intent(Dog.this, Profile.class);
                startActivity(intentGoToProfile);
            }
        });
    }

    private int idOwner;
    private String description;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDogFriendly() { return dogFriendly; }
    public void setDogFriendly(String dogFriendly) { this.dogFriendly = dogFriendly; }

    public String getPeopleFriendly() { return peopleFriendly; }
    public void setPeopleFriendly(String peopleFriendly) { this.peopleFriendly = peopleFriendly; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDrooling() { return drooling; }
    public void setDrooling(String drooling) { this.drooling = drooling; }

    public String getPlayful() { return playful; }
    public void setPlayful(String playful) { this.playful = playful; }

    public String getVaccines() { return vaccines; }
    public void setVaccines(String vaccines) { this.vaccines = vaccines; }

    public int getIdOwner() { return idOwner; }
    public void setIdOwner(int idOwner) { this.idOwner = idOwner; }

    public Dog(int id,String name,String image,String dogFriendly, String peopleFriendly,String size,String breed,String gender,String drooling, String playful,String vaccines,String description,int idOwner){
        this.id = id;
        this.name = name;
        this.image = image;
        this.dogFriendly=dogFriendly;
        this.peopleFriendly=peopleFriendly;
        this.size=size;
        this.breed=breed;
        this.gender=gender;
        this.drooling=drooling;
        this.playful=playful;
        this.vaccines=vaccines;
        this.idOwner=idOwner;
        this.description=description;
    }
    public Dog(){
        this.id = 0;
        this.name = "";
        this.image = "";
        this.dogFriendly= "";
        this.peopleFriendly="";
        this.size= "";
        this.breed= "";
        this.gender= "";
        this.drooling= "";
        this.playful= "";
        this.vaccines= "";
        this.idOwner=0;
        this.description= "";
    }
}
