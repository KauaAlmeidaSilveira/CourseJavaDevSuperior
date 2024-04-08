package com.devsuperior.DSCommerce.services;

import com.devsuperior.DSCommerce.entities.User;
import com.devsuperior.DSCommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(Long userId) {
        User me = userService.autheticated();
        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Não Autorizado !!");
        }
    }

}
