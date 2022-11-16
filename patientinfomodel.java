package com.example.hopeitworks;

    public class patientinfomodel {

        Integer PatientId;
        String PatientName;

        String Wardname;
        String RoomAssigned;
        String AddmissionDate;

        public patientinfomodel(Integer PatientId, String PatientName ,String Wardname,String RoomAssigned,String AddmissionDate){

            this.PatientId=PatientId;
            this.PatientName=PatientName;
            this.Wardname=Wardname;
            this.RoomAssigned=RoomAssigned;
            this.AddmissionDate=AddmissionDate;

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

        public String getWardname() {
            return Wardname;
        }

        public void setWardname(String wardname) {
           Wardname = wardname;
        }

        public String getRoomAssigned() {
            return RoomAssigned;
        }

        public void setRoomAssigned(String roomAssigned) {
            RoomAssigned = roomAssigned;
        }

        public String getAddmissionDate() {
            return AddmissionDate;
        }

        public void setAddmissionDate(String addmissionDate) {
            AddmissionDate = addmissionDate;
        }
    }

