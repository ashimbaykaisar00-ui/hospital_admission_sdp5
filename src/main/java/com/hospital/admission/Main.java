package com.hospital.admission;

import com.hospital.admission.context.BedAllocationContext;
import com.hospital.admission.context.TriageContext;
import com.hospital.admission.model.Bed;
import com.hospital.admission.model.Patient;
import com.hospital.admission.selector.TriageSelector;
import com.hospital.admission.service.FakeHospitalResourceMonitor;
import com.hospital.admission.service.HospitalResourceMonitor;
import com.hospital.admission.strategy.bed.NearestDepartmentAllocation;
import com.hospital.admission.strategy.bed.SeverityBasedAllocation;
import com.hospital.admission.strategy.triage.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HospitalResourceMonitor resourceMonitor = new FakeHospitalResourceMonitor(3, false);

        Patient patient = new Patient("P-101", "Kaisar", 135, 9, true, LocalDateTime.now().minusMinutes(45));

        List<Bed> beds = List.of(
                new Bed("B-01", "ER", false, false),
                new Bed("B-02", "ICU", true, false),
                new Bed("B-03", "General", false, false)
        );

        System.out.println("=== 1. Ручное переключение стратегий в TriageContext ===");
        TriageContext triageContext = new TriageContext(new EmergencySeverityTriage());
        System.out.println("Emergency Strategy score: " + triageContext.executeTriage(patient));

        triageContext.setStrategy(new FirstComeFirstServedTriage());
        System.out.println("First-Come-First-Served score: " + triageContext.executeTriage(patient));

        triageContext.setStrategy(new VipOrInsuranceTriage());
        System.out.println("VIP Strategy score: " + triageContext.executeTriage(patient));

        System.out.println("\n=== 2. Автоматический выбор стратегии через TriageSelector ===");
        TriageSelector selector = new TriageSelector(resourceMonitor);
        TriageStrategy autoStrategy = selector.selectStrategy(patient.isVip(), false);
        triageContext.setStrategy(autoStrategy);
        System.out.println("Selected Strategy Priority Score: " + triageContext.executeTriage(patient));

        System.out.println("\n=== 3. Назначение койки (Семья 2) ===");
        BedAllocationContext bedContext = new BedAllocationContext(new NearestDepartmentAllocation());
        Bed allocatedBed1 = bedContext.executeAllocation(patient, beds);
        System.out.println("Nearest Department Bed: " + (allocatedBed1 != null ? allocatedBed1.getBedId() : "None"));

        bedContext.setStrategy(new SeverityBasedAllocation(resourceMonitor));
        Bed allocatedBed2 = bedContext.executeAllocation(patient, beds);
        System.out.println("Severity-based Bed: " + (allocatedBed2 != null ? allocatedBed2.getBedId() : "None"));
    }
}