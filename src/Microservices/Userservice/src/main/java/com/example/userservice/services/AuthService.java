package com.example.userservice.services;

import com.example.userservice.dtos.*;
import com.example.userservice.models.Role;
import com.example.userservice.models.Session;
import com.example.userservice.models.SessionStatus;
import com.example.userservice.models.User;
import com.example.userservice.respositories.UserRepository;
import com.example.userservice.respositories.SessionRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.MultiValueMapAdapter;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final SessionRepository sessionRepository;

   // private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    public AuthService(UserRepository userRepository, SessionRepository sessionRepository) {
     //   this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public UserDto signUp(SignUpRequestDto signUpRequestDto) {
        User user = new User();
        user.setName(signUpRequestDto.getUsername());
        user.setEmail(signUpRequestDto.getEmail());
      //  user.setPassword(bCryptPasswordEncoder.encode(signUpRequestDto.getPassword()));
        userRepository.save(user);
        return UserDto.from(user);
    }

    public ResponseEntity<UserDto> login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail()).get();
        if (user == null) {
            throw new RuntimeException("User not found");
        }
//        if (!bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
        String token = RandomStringUtils.randomAlphanumeric(64);
        MacAlgorithm macAlgorithm = Jwts.SIG.HS256;
//        String messsage  = "{\n" +
//                "  \"email\": \"djjfj33@gmail.com\",\n" +
//                "  \"name\": \"Daliya\"\n" +
//                "}";
        Map<String,Object> jsonForJwt = new HashMap<>();
        jsonForJwt.put("email", user.getEmail());
        jsonForJwt.put("name", user.getName());
        jsonForJwt.put("id", user.getId());
        jsonForJwt.put("role", user.getRoleSet());
        jsonForJwt.put("createdAt", Date.from(new Date().toInstant()));
        jsonForJwt.put("expiresAt", Date.from(new Date().toInstant().plusSeconds(3600)));
        jsonForJwt.put("Ip","");
        // for extra security you can add the ip address of the user in the jwt token, the resource server can validate the ip address of the user

      //  byte[] content = messsage.getBytes(StandardCharsets.UTF_8);

        // create the compact serialized JWS string
//        token = Jwts.builder()
//                .content(content,"text/plain")
//                .signWith(secretKey, macAlgorithm)
//                .compact();
        token = Jwts.builder()
                .claims(jsonForJwt)
                .signWith(SECRET_KEY, macAlgorithm)
                .compact();

        Session session = new Session();
        session.setUser(user);
        session.setToken(token);
        session.setExpiresAt(Date.from(new Date().toInstant().plusSeconds(3600)));
        session.setSessionStatus(SessionStatus.ACTIVE);
        sessionRepository.save(session);

        UserDto userDto = UserDto.from(user);

        MultiValueMapAdapter<String, String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add(HttpHeaders.SET_COOKIE, "auth-token:" + token);

        return new ResponseEntity<>(userDto, headers, org.springframework.http.HttpStatus.OK);
    }

    public void logout(LogoutRequestDto logoutRequestDto) {
        Session session = sessionRepository.findByToken(logoutRequestDto.getToken());
        if (session == null) {
            throw new RuntimeException("Session not found");
        }
        session.setSessionStatus(SessionStatus.INACTIVE);
        sessionRepository.save(session);
    }

    public SessionStatus validateToken(String token, Long userId) {
        Optional<Session> session = sessionRepository.findByTokenAndUser_Id(token, userId);
        if (session.isEmpty()) {
           return SessionStatus.INACTIVE;
        }
        if (session.get().getSessionStatus() == SessionStatus.INACTIVE) {
            return SessionStatus.INACTIVE;
        }
        if (!Objects.equals(session.get().getUser().getId(), userId)) {
            throw new RuntimeException("Invalid user");
        }
        MacAlgorithm macAlgorithm = Jwts.SIG.HS256;
        SecretKey secretKey = macAlgorithm.key().build();
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseSignedClaims(token);
        String email = (String) claimsJws.getPayload().get("email");
        List<Role> roles = (List<Role>) claimsJws.getPayload().get("roles");
        String name = (String) claimsJws.getPayload().get("name");
        Long id =(Long) claimsJws.getPayload().get("id");
        System.out.println(email);
        System.out.println(name);
        System.out.println(id);
        System.out.println(roles);
        return SessionStatus.ACTIVE;
    }
}
