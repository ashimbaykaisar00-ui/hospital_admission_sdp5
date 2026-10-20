package com.hospital.admission.strategy.triage;

import com.hospital.admission.model.Patient;

public class EmergencySeverityTriage implements TriageStrategy {
    @Override
    public int calculatePriority(Patient patient) {
        int score = patient.getPainLevel() * 10;
        if (patient.getHeartRate() > 120 || patient.getHeartRate() < 50) {
            score += 50;
        }
        return score;
    }
}