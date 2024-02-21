package com.example.demo.dto.soundLog;

import com.example.demo.domain.SoundLog;
import com.google.cloud.Timestamp;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "sound")
public class SoundDTO {
    private String sound;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public SoundLog toSoundLog(String userId) {
        SoundLog soundLog = new SoundLog();
        soundLog.setUser_id(userId);
        soundLog.setSound(this.getSound());
        soundLog.setCurrent_time(Timestamp.now());
        return soundLog;
    }
}
