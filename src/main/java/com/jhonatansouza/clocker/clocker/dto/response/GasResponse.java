package com.jhonatansouza.clocker.clocker.dto.response;

import com.jhonatansouza.clocker.clocker.model.GasEntity;

import java.time.LocalDateTime;

public class GasResponse {

    public GasResponse() {
    }

    private Long idPulse;
    private int ppm;
    private String timeStamp;

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp.toString();
    }

    public Long getIdPulse() {
        return idPulse;
    }

    public void setIdPulse(Long idPulse) {
        this.idPulse = idPulse;
    }

    public static GasResponse fromEntity(GasEntity gasEntity){
        GasResponse gasResponse = new GasResponse();
        gasResponse.setIdPulse(gasEntity.getId());
        gasResponse.setPpm(gasEntity.getPpm());
        gasResponse.setTimeStamp(gasEntity.getTimeStamp());
        return gasResponse;
    }
}
