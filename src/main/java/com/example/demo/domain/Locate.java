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
public class Locate {
    @DocumentId
    private String id;
    private String user_id;
    private Float longitude;
    private Float latitude;
}
