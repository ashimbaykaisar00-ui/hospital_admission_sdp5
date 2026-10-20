package com.hospital.admission.strategy.triage;

import com.hospital.admission.model.Patient;

public interface TriageStrategy {
    int calculatePriority(Patient patient);
}