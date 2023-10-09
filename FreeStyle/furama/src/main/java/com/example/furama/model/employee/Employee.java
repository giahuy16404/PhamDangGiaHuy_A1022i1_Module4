package com.example.furama.model.employee;

import com.example.furama.model.account.AppUser;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    private String name;

    @Column(columnDefinition = "DATE")
    private String birthDay;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false, referencedColumnName = "username")
    private AppUser appUser;

    public Employee() {
    }

    public Employee(long id, String name, String birthDay, String idCard, double salary,
                    String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, AppUser appUser) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", idCard='" + idCard + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", position=" + position +
                ", educationDegree=" + educationDegree +
                ", division=" + division +
                ", user=" + appUser +
                '}';
    }
}
