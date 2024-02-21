package com.example.demo.domain;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    @DocumentId
    private String id;
    private String dog_name;
    private String email;
    private float max_lat;
    private float max_long;
    private float min_lat;
    private float min_long;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDog_name() {
        return dog_name;
    }

    public void setDog_name(String dog_name) {
        this.dog_name = dog_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getMax_lat() {
        return max_lat;
    }

    public void setMax_lat(float max_lat) {
        this.max_lat = max_lat;
    }

    public float getMax_long() {
        return max_long;
    }

    public void setMax_long(float max_long) {
        this.max_long = max_long;
    }

    public float getMin_lat() {
        return min_lat;
    }

    public void setMin_lat(float min_lat) {
        this.min_lat = min_lat;
    }

    public float getMin_long() {
        return min_long;
    }

    public void setMin_long(float min_long) {
        this.min_long = min_long;
    }
}
