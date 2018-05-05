package com.jamestown.security.api.controller;

import com.jamestown.microdemo.intf.service.util.SecurityConstants;
import com.jamestown.model.dto.Login;
import com.jamestown.model.dto.SessionToken;
import com.jamestown.security.api.service.AuthServiceProcessor;
import com.jamestown.security.api.service.SessionTokenServiceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = SecurityConstants.SECURITY_BASE_PATH)
@RestController
public class AuthController {

    @Autowired
    private AuthServiceProcessor authService;

    @Autowired
    private SessionTokenServiceProcessor sessionTokenServiceProcessor;

    @GetMapping
    public String helloWorld() {
        return "Auth controller is works";
    }

    @PostMapping(SecurityConstants.SECURITY_LOGIN)
    public @ResponseBody SessionToken getLogin(@RequestBody Login login) {
        try {
            SessionToken sessionToken = authService.login(login);
            return sessionTokenServiceProcessor.save(sessionToken);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping(SecurityConstants.SECURITY_LOGOUT)
    public @ResponseBody SessionToken logout(@RequestBody SessionToken sessionToken){
        sessionTokenServiceProcessor.delete(sessionToken);
        return sessionToken;
    }


    @PostMapping(SecurityConstants.SECURITY_VERIFY_TOKEN + "/{permission}/{group}")
    public @ResponseBody SessionToken verifyToken(@RequestBody SessionToken sessionToken, @PathVariable String permission,
                                                  @PathVariable String group){
        return sessionTokenServiceProcessor.verifyToken(sessionToken, permission, group);
    }


}
