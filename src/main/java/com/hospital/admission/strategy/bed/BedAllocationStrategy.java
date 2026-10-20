package com.hospital.admission.strategy.bed;

import com.hospital.admission.model.Bed;
import com.hospital.admission.model.Patient;
import java.util.List;

public interface BedAllocationStrategy {
    Bed allocateBed(Patient patient, List<Bed> availableBeds);
}
