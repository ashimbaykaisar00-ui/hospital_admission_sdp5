package com.hospital.admission.model;

public class Bed {
    private final String bedId;
    private final String departmentName;
    private final boolean isIcu; // Койка интенсивной терапии / реанимации
    private final boolean isOccupied;

    public Bed(String bedId, String departmentName, boolean isIcu, boolean isOccupied) {
        this.bedId = bedId;
        this.departmentName = departmentName;
        this.isIcu = isIcu;
        this.isOccupied = isOccupied;
    }

    public String getBedId() { return bedId; }
    public String getDepartmentName() { return departmentName; }
    public boolean isIcu() { return isIcu; }
    public boolean isOccupied() { return isOccupied; }
}