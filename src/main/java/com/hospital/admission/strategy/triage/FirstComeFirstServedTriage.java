package com.hospital.admission.strategy.triage;

import com.hospital.admission.model.Patient;
import java.time.Duration;
import java.time.LocalDateTime;

public class FirstComeFirstServedTriage implements TriageStrategy {
    @Override
    public int calculatePriority(Patient patient) {
        long minutesWaiting = Duration.between(patient.getArrivalTime(), LocalDateTime.now()).toMinutes();
        return (int) Math.max(0, minutesWaiting);
    }
}