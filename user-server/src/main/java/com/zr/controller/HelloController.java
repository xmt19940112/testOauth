package com.zr.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Principal principal){
        return "hello"+principal.getName();
    }

    @GetMapping("/admin/hello")
    public String admin(Authentication authentication){
        return "hello"+authentication.getName();
    }
    @GetMapping("/user/hello")
    public String user(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "hello"+authentication.getName();
    }

    @GetMapping("/all/hello")
    public String all(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        return "hello"+principal.getName();
    }
}
