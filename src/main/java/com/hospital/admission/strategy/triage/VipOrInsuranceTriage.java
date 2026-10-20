package com.hospital.admission.strategy.triage;

import com.hospital.admission.model.Patient;

public class VipOrInsuranceTriage implements TriageStrategy {
    @Override
    public int calculatePriority(Patient patient) {
        return patient.isVip() ? 100 : 10;
    }
}