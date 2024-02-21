package com.example.demo.dto.soundLog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogIdDTO {
    private String logId;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}
