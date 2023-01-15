package kr.danbee.junsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.danbee.junsec.domain.Users;
//import velog.soyeon.security.entity.Users;

@Repository
public interface UserRepository extends JpaRepository <Users, Long> {
    Users findByEmail(String email);
    
    /* 유효성 검사 - 중복 체크
	 * 중복 : true
	 * 중복이 아닌 경우 : false
	 * 
	 * 참조: https://velog.io/@jyleedev/%EC%9C%A0%ED%9A%A8%EC%84%B1%EA%B2%80%EC%82%AC
	 */
	//boolean existsByUsername(String username);
	//boolean existsByNickname(String nickname);
	boolean existsByEmail(String email);
}