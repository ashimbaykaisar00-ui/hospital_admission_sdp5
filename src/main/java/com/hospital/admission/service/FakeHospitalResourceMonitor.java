package com.hospital.admission.service;

public class FakeHospitalResourceMonitor implements HospitalResourceMonitor {
    private final int availableIcuBeds;
    private final boolean emergencyMode;

    public FakeHospitalResourceMonitor(int availableIcuBeds, boolean emergencyMode) {
        this.availableIcuBeds = availableIcuBeds;
        this.emergencyMode = emergencyMode;
    }

    @Override
    public int getAvailableIcuBeds() {
        return availableIcuBeds;
    }

    @Override
    public boolean isEmergencyModeActive() {
        return emergencyMode;
    }
}