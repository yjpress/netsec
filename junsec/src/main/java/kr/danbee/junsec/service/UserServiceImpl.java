package kr.danbee.junsec.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.danbee.junsec.domain.UserCreateRequest;
import kr.danbee.junsec.domain.UserDTO;
import kr.danbee.junsec.domain.Users;
import kr.danbee.junsec.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        Users users = userRepository.save(
                Users.builder().password(bCryptPasswordEncoder.encode(userCreateRequest.getPassword())).email(userCreateRequest.getEmail()).userRole(userCreateRequest.getUserRole()).build());
        return UserDTO.builder().id(users.getId()).password(users.getPassword()).userRole(users.getUserRole()).email(users.getEmail()).build();
    }

}