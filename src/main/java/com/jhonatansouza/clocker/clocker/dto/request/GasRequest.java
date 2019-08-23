package com.jhonatansouza.clocker.clocker.dto.request;

import com.jhonatansouza.clocker.clocker.model.GasEntity;

public class GasRequest {

    private int ppm;
    public int getPpm() {
        return ppm;
    }
    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public GasEntity toEntity(){
        GasEntity gas = new GasEntity();
        gas.setPpm(this.ppm);
        return gas;
    }

}
