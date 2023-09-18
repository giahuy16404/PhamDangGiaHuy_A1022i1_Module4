package com.example.test_1.dto;

import com.example.test_1.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CustomerDto implements Validator {
    private Long id;

    private CustomerType customerType;
    private String name;
    private String birthday;
    private boolean gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    public CustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerDto(Long id, CustomerType customerType, String name,
                       String birthday, boolean gender, String idCard, String phone, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (customerDto.getName().isEmpty()) {
            errors.rejectValue("name", null, "tên không được để trống!");
        } else if (!customerDto.getName().matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)?$")) {
            errors.rejectValue("name", null, "tên ko đúng định dạng!");
        }
        if (customerDto.getPhone().isEmpty()) {
            errors.rejectValue("phone", null, "SDT không đúng định dạng!");
        } else if (!customerDto.getPhone().matches("(090|091|\\+8490|\\+8491)\\d{7}$")) {
            errors.rejectValue("phone", null, "SDT không đúng định dạng!");
        }
        if (customerDto.getEmail().isEmpty()) {
            errors.rejectValue("email", null, "Email không đưuọc để trống!");
        } else if (!customerDto.getEmail().matches("^[a-z A-Z 0-9]+@gmail\\.com$")) {
            errors.rejectValue("email", null, "Email không đúng định dạng!");
        }
    }
}
