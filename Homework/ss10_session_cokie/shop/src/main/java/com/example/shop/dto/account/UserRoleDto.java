package com.example.shop.dto.account;

import com.example.shop.model.account.AppRole;
import com.example.shop.model.account.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class UserRoleDto implements Validator {
    private AppUser appUser;
    private List<AppRole> appRole;

    public UserRoleDto(AppUser appUser, List<AppRole> appRole) {
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public List<AppRole> getRole() {
        return appRole;
    }

    public void setRole(List<AppRole> appRole) {
        this.appRole = appRole;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
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
