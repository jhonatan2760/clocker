package com.jhonatansouza.clocker.clocker.dto.response;

import java.time.LocalDateTime;

public class GasResponse {

    public GasResponse() {
    }

    private int ppm;
    private LocalDateTime timeStamp;

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
