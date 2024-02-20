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

}
