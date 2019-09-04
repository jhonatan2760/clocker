package com.jhonatansouza.clocker.clocker.dto.response;

import java.time.LocalDateTime;

public class MeanResponse {

    private Double mean;
    private LocalDateTime timestamp;

    public MeanResponse(Double mean){
        this.mean = mean;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
