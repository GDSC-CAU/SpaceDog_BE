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
}
