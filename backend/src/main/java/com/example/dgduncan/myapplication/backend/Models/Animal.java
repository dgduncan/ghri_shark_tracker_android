package com.example.dgduncan.myapplication.backend.Models;

import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Animal {

    @Id
    public Long id;

    public String common_name;

    public String date;

    public GeoPt location;

    @Index
    public String name;

    @Index
    public boolean recent;

    public int sequence;

    public String sex;

    public String size;

    public String species;

    public String tagging_video;

    public Animal(){}

    public Animal(String common_name, String date,  GeoPt location, String name, boolean recent, Integer sequence,
                  String sex, String size, String species, String tagging_video)
    {
        this.common_name = common_name;
        this.date = date;
        this.location = location;
        this.name = name;
        this.recent = recent;
        this.sequence = sequence;
        this.sex = sex;
        this.size = size;
        this.species = species;
        this.tagging_video = tagging_video;
    }

}