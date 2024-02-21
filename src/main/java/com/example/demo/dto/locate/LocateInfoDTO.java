package com.example.demo.dto.locate;

import com.example.demo.domain.Locate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "위치 정보")
public class LocateInfoDTO {
    private Float longitude;
    private Float latitude;

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

    public Locate toLocate(String userId){
        Locate l = new Locate();
        l.setUser_id(userId);
        l.setLatitude(this.latitude);
        l.setLongitude(this.longitude);
        return l;
    }
}
