package com.hospital.admission.service;

public interface HospitalResourceMonitor {
    int getAvailableIcuBeds();
    boolean isEmergencyModeActive();
}