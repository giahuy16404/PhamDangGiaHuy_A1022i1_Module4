package com.model;

public class Medical {
    private int id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String travelInformation;
    private String vehicleNumber;
    private String numberOfSeats;
    private StarDay starDay;
    private EndDay endDay;
    private String travelTest;
    private Contacts contacts;
    private String contactDetails;
    private String phone;
    private String email;
    private Symptom symptom;
    private String exposureHistory;

    public Medical() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public StarDay getStarDay() {
        return starDay;
    }

    public void setStarDay(StarDay starDay) {
        this.starDay = starDay;
    }

    public EndDay getEndDay() {
        return endDay;
    }

    public void setEndDay(EndDay endDay) {
        this.endDay = endDay;
    }

    public String getTravelTest() {
        return travelTest;
    }

    public void setTravelTest(String travelTest) {
        this.travelTest = travelTest;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public String getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String exposureHistory) {
        this.exposureHistory = exposureHistory;
    }

    public Medical(int id, String name, String yearOfBirth, String gender, String nationality, String idCard, String travelInformation, String vehicleNumber, String numberOfSeats, StarDay starDay, EndDay endDay, String travelTest, Contacts contacts, String contactDetails, String phone, String email, Symptom symptom, String exposureHistory) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.numberOfSeats = numberOfSeats;
        this.starDay = starDay;
        this.endDay = endDay;
        this.travelTest = travelTest;
        this.contacts = contacts;
        this.contactDetails = contactDetails;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.exposureHistory = exposureHistory;
    }

    @Override
    public String toString() {
        return "Medical{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", idCard='" + idCard + '\'' +
                ", travelInformation='" + travelInformation + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", numberOfSeats='" + numberOfSeats + '\'' +
                ", starDay=" + starDay +
                ", endDay=" + endDay +
                ", travelTest='" + travelTest + '\'' +
                ", contacts=" + contacts +
                ", contactDetails='" + contactDetails + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", symptom=" + symptom +
                ", exposureHistory='" + exposureHistory + '\'' +
                '}';
    }
}
