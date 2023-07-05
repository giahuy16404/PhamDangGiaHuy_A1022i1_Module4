package com.example.blog.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
public class UserDto implements Validator {
    private String name;
    private String email;
    private String gender;
    private String phoneNumber;
    private String age;

    public UserDto(String name, String email, String gender, String phoneNumber, String age) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public UserDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getName().isEmpty()) {
            errors.rejectValue("name", null, "Khong dc de trong!");
        } else if (userDto.getName().length() < 5 || userDto.getName().length() > 45) {
            errors.rejectValue("name", null, "Do dai phai lon hon 5 và be hon 45!");
        }

        if (userDto.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", null, "Khong dc de trong!");
        } else if (!userDto.getPhoneNumber().matches("\\b(0\\d{9}|0\\d{2}[-.\\s]?\\d{3}[-.\\s]?\\d{4})\\b")) {
            errors.rejectValue("phoneNumber", null, "Khong dung dinh dang sdt!");
        }

        if (userDto.getAge().isEmpty()) {
            errors.rejectValue("age", null, "Khong dc de trong!");
        } else if (!userDto.getAge().matches("^(?:1[89]|[2-9]\\d|1\\d{2}|[2-9]\\d{2}|\\d{4,})$")) {
            errors.rejectValue("age", null, "Tuổi phải lớn hơn hoặc bằng 18!");
        }

        if (userDto.getEmail().isEmpty()) {
            errors.rejectValue("email", null, "Khong dc de trong!");
        } else if (!userDto.getEmail().matches("^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*@gmail\\.com$")) {
            errors.rejectValue("email", null, "Email không đunúng định dạng!");
        }
    }
}
