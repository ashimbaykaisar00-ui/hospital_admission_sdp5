package com.hospital.admission.context;

import com.hospital.admission.model.Bed;
import com.hospital.admission.model.Patient;
import com.hospital.admission.strategy.bed.BedAllocationStrategy;
import java.util.List;

public class BedAllocationContext {
    private BedAllocationStrategy strategy;

    public BedAllocationContext(BedAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(BedAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public Bed executeAllocation(Patient patient, List<Bed> availableBeds) {
        return strategy.allocateBed(patient, availableBeds);
    }
}
