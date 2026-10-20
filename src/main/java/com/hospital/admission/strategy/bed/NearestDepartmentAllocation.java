package com.hospital.admission.strategy.bed;

import com.hospital.admission.model.Bed;
import com.hospital.admission.model.Patient;
import java.util.List;

public class NearestDepartmentAllocation implements BedAllocationStrategy {
    @Override
    public Bed allocateBed(Patient patient, List<Bed> availableBeds) {
        return availableBeds.stream()
                .filter(b -> !b.isOccupied() && "ER".equals(b.getDepartmentName()))
                .findFirst()
                .orElse(null);
    }
}
