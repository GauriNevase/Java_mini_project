package com.example.hopeitworks;

public class bedinfomodel {
    Integer BedId;
    Integer PatientId;
    String PatientName;
    Integer BedOccupancy;
    Integer Age;

    public bedinfomodel(Integer BedId, String PatientName , Integer PatientId, Integer BedOccupancy, Integer Age){

        this.PatientId= PatientId;
        this.PatientName= PatientName;
        this.BedId= BedId;
        this.BedOccupancy= BedOccupancy;
        this.Age= Age;
    }

    public Integer getBedId() {
        return BedId;
    }

    public void setBedId(Integer bedId) {
        BedId = bedId;
    }

    public Integer getPatientId() {
        return PatientId;
    }

    public void setPatientId(Integer patientId) {
        PatientId = patientId;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public Integer getBedOccupancy() {
        return BedOccupancy;
    }

    public void setBedOccupancy(Integer bedOccupancy) {
        BedOccupancy = bedOccupancy;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
