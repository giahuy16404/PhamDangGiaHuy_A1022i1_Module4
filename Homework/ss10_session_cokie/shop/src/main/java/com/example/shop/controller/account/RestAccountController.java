package com.example.shop.controller.account;
import com.example.shop.dto.account.UserRoleDto;
import com.example.shop.model.account.AppRole;
import com.example.shop.model.account.AppUser;
import com.example.shop.model.account.UserRole;
import com.example.shop.service.account.imlp.IRoleService;
import com.example.shop.service.account.imlp.IUserRoleService;
import com.example.shop.service.account.imlp.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api/account")
public class RestAccountController {
//    @Autowired
//    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IUserRoleService iUserRoleService;

    @GetMapping("/list")
    public ResponseEntity<Page<UserRole>> getList(@RequestParam int page,
                                                  @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserRole> getAllAccount = iUserRoleService.findAll(pageable);
        if (getAllAccount.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllAccount, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> create(@RequestBody @Valid UserRoleDto userRoleDto, BindingResult bindingResult) {
        new UserRoleDto().validate(userRoleDto, bindingResult);
        Map<String, Object> errorInput = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorInput.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorInput, HttpStatus.BAD_REQUEST);
        }
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(userRoleDto, userRole);

        //Thêm user
        AppUser appUser = new AppUser();
        appUser.setUsername(userRole.getUser().getUsername());
        appUser.setPassword(userRole.getUser().getPassword());
        iUserService.add(appUser);
        errorInput.put("message", "successful");

        //Thêm User và Role của họ
        List<AppRole> appRoleList = new ArrayList<>(userRoleDto.getRole());
        for (AppRole r : appRoleList) {
            UserRole newUserRole = new UserRole();
            newUserRole.setUser(appUser);
            newUserRole.setRole(r);
            iUserRoleService.add(newUserRole);
        }

        return new ResponseEntity<>(errorInput, HttpStatus.OK);
    }

    @GetMapping("/list-role")
    public ResponseEntity<List<AppRole>> getRole() {
        List<AppRole> appRoleList = iRoleService.findAll();
        if (appRoleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appRoleList, HttpStatus.OK);
    }

    @PostMapping("/find-by-name-user")
    public ResponseEntity<Page<UserRole>> findBy(@RequestBody @RequestParam int page,
                                                  @RequestParam int size,
                                                 @RequestParam String name
                                                 ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserRole> getAllAccount = iUserRoleService.findByName(pageable,name);
        if (getAllAccount.isEmpty()) {
            System.out.println("-------------------------No Content");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println("-------------------------OK");
        return new ResponseEntity<>(getAllAccount, HttpStatus.OK);
    }


}
