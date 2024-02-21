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
public class Sound {
    @DocumentId
    private String id;
    private String user_id;
    private float sound;

    private Timestamp current_time;

    public Timestamp getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Timestamp current_time) {
        this.current_time = current_time;
    }
}
