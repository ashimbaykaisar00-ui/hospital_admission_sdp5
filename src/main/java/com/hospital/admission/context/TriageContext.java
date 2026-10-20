package com.hospital.admission.context;

import com.hospital.admission.model.Patient;
import com.hospital.admission.strategy.triage.TriageStrategy;

public class TriageContext {
    private TriageStrategy strategy;

    public TriageContext(TriageStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TriageStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeTriage(Patient patient) {
        return strategy.calculatePriority(patient);
    }
}