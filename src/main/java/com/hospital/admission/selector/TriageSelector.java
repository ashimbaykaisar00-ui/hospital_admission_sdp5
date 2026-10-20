package com.hospital.admission.selector;

import com.hospital.admission.service.HospitalResourceMonitor;
import com.hospital.admission.strategy.triage.*;

public class TriageSelector {
    private final HospitalResourceMonitor resourceMonitor;

    public TriageSelector(HospitalResourceMonitor resourceMonitor) {
        this.resourceMonitor = resourceMonitor;
    }

    public TriageStrategy selectStrategy(boolean isVip, boolean isMassCasualty) {
        if (isMassCasualty || resourceMonitor.isEmergencyModeActive()) {
            return new EmergencySeverityTriage();
        }
        if (isVip) {
            return new VipOrInsuranceTriage();
        }
        return new FirstComeFirstServedTriage();
    }
}