package com.example.demo.dto.sound;

import com.example.demo.domain.Sound;
import com.example.demo.repository.SoundRepos;
import com.google.cloud.Timestamp;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "소리 정보")
public class SoundInfoDTO {
    private Float sound;

    public Float getSound() {
        return sound;
    }

    public void setSound(Float sound) {
        this.sound = sound;
    }

    public Sound toSound(String userId){
        Sound s = new Sound();
        s.setSound(this.sound);
        s.setUser_id(userId);
        s.setCurrent_time(Timestamp.now());
        return s;
    }
}
