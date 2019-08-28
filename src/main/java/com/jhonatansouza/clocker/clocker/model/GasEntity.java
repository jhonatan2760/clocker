package com.jhonatansouza.clocker.clocker.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "GasEntity")
@Table(name = "GasEntity")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gas_seq", sequenceName = "gas_seq")
public class GasEntity {

    private Long id;
    private int ppm;
    private LocalDateTime timeStamp;
    private DeviceEntity deviceEntity;

    @Id
    @GeneratedValue(generator = "gas_seq", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    @CreationTimestamp
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @ManyToOne
    public DeviceEntity getDeviceEntity() {
        return deviceEntity;
    }

    public void setDeviceEntity(DeviceEntity deviceEntity) {
        this.deviceEntity = deviceEntity;
    }
}
