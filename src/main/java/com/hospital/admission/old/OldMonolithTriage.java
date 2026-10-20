package com.hospital.admission.old;

import com.hospital.admission.model.Patient;

public class OldMonolithTriage {
    public int calculatePriority(Patient patient, String triageType) {
        switch (triageType) {
            case "EMERGENCY":
                int score = patient.getPainLevel() * 10;
                if (patient.getHeartRate() > 120 || patient.getHeartRate() < 50) {
                    score += 50;
                }
                return score;
            case "VIP":
                return patient.isVip() ? 100 : 10;
            case "FCFS":
            default:
                return 0;
        }
    }
}
