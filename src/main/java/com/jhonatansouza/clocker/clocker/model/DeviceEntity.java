package com.jhonatansouza.clocker.clocker.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(sequenceName = "device_entity_seq",
        name = "device_entity_seq",
        initialValue = 1,
        allocationSize = 1)
public class DeviceEntity {

    @Id
    @GeneratedValue(generator = "device_entity_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "device_name")
    private String name;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "is_active")
    private boolean status;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
