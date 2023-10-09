package com.example.furama.service.account;

import com.example.furama.model.account.AppUser;
import com.example.furama.repository.account.IRoleRepository;
import com.example.furama.repository.account.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.getAccountByUsername(username);

        List<String> roleNames = iRoleRepository.getRoleByUser(appUser.getId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);

                grantList.add(authority);
            }
        }

        return new User(appUser.getUsername(), appUser.getPassword(), grantList);
//    }
    }

//
//    @Override
//    public boolean add(AppUser appUser) {
//        try {
//            iUserRepository.save(appUser);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//
//    @Override
//    public boolean edit(AppUser appUser) {
//        AppUser appUser1 = findById(appUser.getId());
//        if (appUser1 == null) {
//            return false;
//        }
//        iUserRepository.save(appUser);
//        return true;
//    }
//
//    @Override
//    public boolean delete(AppUser appUser) {
//        AppUser appUser1 = findById(appUser.getId());
//        if (appUser1 == null) {
//            return false;
//        }
//        iUserRepository.delete(appUser);
//        return true;
//    }
//
//    @Override
//    public Page<AppUser> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public AppUser findById(long id) {
//        return null;
//    }
//
//    @Override
//    public UserDetails getAccountByUsername(String name) {
//        AppUser appUser = iUserRepository.getAccountByUsername(name);
//
//        List<String> roleNames = iRoleRepository.getRoleByUser(appUser.getId());
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (String role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }
//
//        return new User(appUser.getUsername(),appUser.getPassword(),grantList);
//    }
}
