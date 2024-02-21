package com.example.demo.dto.user;

import com.example.demo.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "사용자 등록 request")
public class UserCreateReq {
    private String dog_name;
    private String email;
    private Float max_lat;
    private Float max_long;
    private Float min_lat;
    private Float min_long;

    public User toUser() {
        User user = new User();
        user.setDog_name(this.dog_name);
        user.setEmail(this.email);
        user.setMax_lat(this.max_lat != null ? this.max_lat : 0);
        user.setMax_long(this.max_long != null ? this.max_long : 0);
        user.setMin_lat(this.min_lat != null ? this.min_lat : 0);
        user.setMin_long(this.min_long != null ? this.min_long : 0);
        return user;
    }
}
