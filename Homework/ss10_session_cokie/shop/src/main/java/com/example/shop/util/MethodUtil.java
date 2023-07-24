package com.example.shop.util;

import com.example.shop.model.account.Role;
import com.example.shop.model.account.User;
import com.example.shop.model.account.UserRole;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

public class MethodUtil {
    public static Page<UserRole> groupRolesForUsers(Page<UserRole> page) {
        List<String> roleList = new ArrayList<>();
        List<Long> check = new ArrayList<>();
        for (UserRole userRole : page) {
            String roleName = userRole.getRole().getName();
            if (!roleList.contains(roleName)) {
                roleList.add(roleName);
                if (roleList.size() == 2) {
                    break;
                }
            }
        }

        if (roleList.size() >= 2) {
            String role1 = roleList.get(0);
            String role2 = roleList.get(1);

            for (UserRole userRole : page) {
                String roleName = userRole.getRole().getName();
                check.add(userRole.getUser().getId());
                if (roleName.equals(role1)) {
                    userRole.getRole().setName(roleName + "," + role2);
                } else if (roleName.equals(role2)) {
                    userRole.getRole().setName(roleName + "," + role1);
                }
            }
        }
        return page;
    }

}
