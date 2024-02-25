package com.example.demo.domain;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class SoundLog {
    @DocumentId
    private String id;
    private String user_id;
    private String sound;
    private Timestamp current_time;

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

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Timestamp getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Timestamp current_time) {
        this.current_time = current_time;
    }
}
