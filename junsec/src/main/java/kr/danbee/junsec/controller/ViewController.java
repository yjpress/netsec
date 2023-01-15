package kr.danbee.junsec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//import velog.soyeon.security.repository.UserRepository;
//import velog.soyeon.security.dto.UserDTO;

import kr.danbee.junsec.domain.UserDTO;
import kr.danbee.junsec.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final UserRepository userRepository;


    @GetMapping("/")
    String home() {
        return "pages/home";
    }
    @GetMapping("/login")
    String loginView() {
        return "login/login";
    }
    @GetMapping("/success")
    String successView() {
        return "success";
    }

    @GetMapping("/fail")
    String failView() {
        return "fail";
    }
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/admin")
    ModelAndView adminView() {
        List<UserDTO> userDTOList = userRepository.findAll().stream().map(u -> UserDTO.builder().id(u.getId()).email(u.getEmail()).password(u.getPassword()).userRole(u.getUserRole()).build()).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("/admin");
        modelAndView.addObject("userList", userDTOList);
        return modelAndView;
    }

    @GetMapping("/my")
    ModelAndView myView(Authentication authentication) {
        UserDTO userDTO = Optional.ofNullable(userRepository.findByEmail(authentication.getName()))
                .map(u -> UserDTO.builder().id(u.getId()).email(u.getEmail()).password(u.getPassword()).userRole(u.getUserRole()).build())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        ModelAndView modelAndView = new ModelAndView("/my");
        modelAndView.addObject("userDTO", userDTO);

        return modelAndView;
    }

    @GetMapping("/signup")
    String signupView() {
        return "login/signup";
    }


}