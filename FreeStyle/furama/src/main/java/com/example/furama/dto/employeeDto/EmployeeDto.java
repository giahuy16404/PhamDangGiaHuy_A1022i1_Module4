package com.example.furama.dto.employeeDto;

import com.example.furama.model.account.AppUser;
import com.example.furama.model.employee.Division;
import com.example.furama.model.employee.EducationDegree;
import com.example.furama.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeDto implements Validator {
    private long id;
    private String name;
    private String birthDay;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    private AppUser appUser;

    public EmployeeDto(long id, String name, String birthDay, String idCard,
                       double salary, String phone, String email, String address,
                       Position position, EducationDegree educationDegree, Division division, AppUser appUser) {
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

    public EmployeeDto() {
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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDTO = (EmployeeDto) target;
        if (employeeDTO.getName().isEmpty()) {
            errors.rejectValue("name", null, "Không được để trống");
        }
    }
}