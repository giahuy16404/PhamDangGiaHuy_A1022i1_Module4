package com.example.furama.rest_controller.account;

import com.example.furama.dto.acountDto.UserRoleDto;
import com.example.furama.jwt.JwtUtility;
import com.example.furama.model.account.AppRole;
import com.example.furama.model.account.AppUser;
import com.example.furama.model.account.UserRole;
import com.example.furama.model.customer.CustomerType;
import com.example.furama.payload.reponse.JwtResponse;
import com.example.furama.payload.request.LoginRequest;
import com.example.furama.service.account.imlp.IRoleService;
import com.example.furama.service.account.imlp.IUserRoleService;
import com.example.furama.service.account.imlp.IUserService;
import com.example.furama.util.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/form")

public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("Calling authenticateUser...");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRoleDto userRole) {
        System.out.println("Vô rồi");
        try {
            String newPassword = EncrytedPasswordUtils.encrytePassword(userRole.getPassword());
            userRole.setPassword(newPassword);
            AppUser appUser = new AppUser(0, userRole.getUsername(), userRole.getPassword(),userRole.getGmail());
            AppUser newAppUser = iUserService.add(appUser);
                iUserRoleService.add(new UserRole(0L, userRole.getRole(), newAppUser));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FOUND);

        }
    }

    @GetMapping("/getRole")
    public ResponseEntity<List<AppRole>> getServiceType() {
        List<AppRole> checkRole = iRoleService.findAll();
        if (checkRole != null) {
            return new ResponseEntity<>(checkRole, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}