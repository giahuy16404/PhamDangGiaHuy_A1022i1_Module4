package com.example.shop.dto.account;

import com.example.shop.model.account.Role;
import com.example.shop.model.account.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public class UserRoleDto implements Validator {
    private User user;
    private List<Role> role;

    public UserRoleDto(User user, List<Role> role) {
        this.user = user;
        this.role = role;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRoleDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
