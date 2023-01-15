package kr.danbee.junsec.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//import velog.soyeon.security.repository.UserRepository;
//import velog.soyeon.security.entity.Users;

import kr.danbee.junsec.domain.Users;
import kr.danbee.junsec.repository.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String userEmail) {
        return Optional.ofNullable(userRepository.findByEmail(userEmail)).orElseThrow(() -> new BadCredentialsException("이메일 주소를 확인해주세요."));
    }

}