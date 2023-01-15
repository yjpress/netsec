package kr.danbee.junsec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import velog.soyeon.security.PackageDto;
//import velog.soyeon.security.dto.UserCreateRequest;
//import velog.soyeon.security.service.impl.UserServiceImpl;

import kr.danbee.junsec.domain.PackageDto;
import kr.danbee.junsec.domain.UserCreateRequest;
import kr.danbee.junsec.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public PackageDto getPackageDto() {

        PackageDto packageDto = new PackageDto();
        packageDto.setNew(false);

        return packageDto;
    }

    @PostMapping("/signup")
    public void createUser(UserCreateRequest userCreateRequest, HttpServletResponse response) throws IOException {
        userService.createUser(userCreateRequest);
        response.sendRedirect("/login");
    }

    @PostMapping("/logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        response.sendRedirect("/login");
    }


}