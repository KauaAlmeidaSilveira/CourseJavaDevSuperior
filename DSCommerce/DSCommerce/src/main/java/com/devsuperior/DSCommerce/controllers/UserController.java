package com.devsuperior.DSCommerce.controllers;

import com.devsuperior.DSCommerce.DTO.UserDTO;
import com.devsuperior.DSCommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> findById() {
        UserDTO userDTO = userService.getMe();
        return ResponseEntity.ok(userDTO);
    }

}
