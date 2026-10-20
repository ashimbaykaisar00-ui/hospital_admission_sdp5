package com.hospital.admission.model;

import java.time.LocalDateTime;

public class Patient {
    private final String id;
    private final String name;
    private final int heartRate;
    private final int painLevel; // от 1 до 10
    private final boolean isVip;
    private final LocalDateTime arrivalTime;

    public Patient(String id, String name, int heartRate, int painLevel, boolean isVip, LocalDateTime arrivalTime) {
        this.id = id;
        this.name = name;
        this.heartRate = heartRate;
        this.painLevel = painLevel;
        this.isVip = isVip;
        this.arrivalTime = arrivalTime;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getHeartRate() { return heartRate; }
    public int getPainLevel() { return painLevel; }
    public boolean isVip() { return isVip; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
}