package kr.danbee.junsec.service;

import kr.danbee.junsec.domain.UserCreateRequest;
import kr.danbee.junsec.domain.UserDTO;

//import velog.soyeon.security.dto.UserDTO;
//import velog.soyeon.security.dto.UserCreateRequest;

public interface UserService {
    UserDTO createUser(UserCreateRequest userCreateRequest);
}