package com.hospital.admission.strategy.bed;

import com.hospital.admission.model.Bed;
import com.hospital.admission.model.Patient;
import com.hospital.admission.service.HospitalResourceMonitor;
import java.util.List;

public class SeverityBasedAllocation implements BedAllocationStrategy {
    private final HospitalResourceMonitor resourceMonitor;

    public SeverityBasedAllocation(HospitalResourceMonitor resourceMonitor) {
        this.resourceMonitor = resourceMonitor;
    }

    @Override
    public Bed allocateBed(Patient patient, List<Bed> availableBeds) {
        boolean needIcu = patient.getPainLevel() >= 8 && resourceMonitor.getAvailableIcuBeds() > 0;
        return availableBeds.stream()
                .filter(b -> !b.isOccupied())
                .filter(b -> b.isIcu() == needIcu)
                .findFirst()
                .orElse(null);
    }
}
