package com.example.demo.domain;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Locate {
    @DocumentId
    private String id;
    private String user_id;
    private Float longitude;
    private Float latitude;

    private Timestamp current_time;

    public Timestamp getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Timestamp current_time) {
        this.current_time = current_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
