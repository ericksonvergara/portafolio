package com.portafolio.evr.infrastructure.entrypoints.user;



import com.portafolio.evr.domain.models.user.User;
import com.portafolio.evr.domain.models.user.UserLogin;
import com.portafolio.evr.domain.models.user.UserRequest;
import com.portafolio.evr.domain.usecase.user.UserUseCase;
import com.portafolio.evr.infrastructure.adapters.security.Auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Log4j2
public class userEntryPoint {

    private final UserUseCase userUseCase;
    private final AuthService authService;


    @PostMapping("registry")
    public ResponseEntity<?> savePlayer(@RequestBody UserRequest userRequest, HttpServletResponse response) {

        try {
            String passEncode = new BCryptPasswordEncoder().encode(userRequest.getPassword());
            userRequest.setPassword(passEncode);
            User user = userUseCase.save(userRequest);
            if(user == null){
                return ResponseEntity.status(400).body("usuario ya existe");
            }
            return ResponseEntity.status(201).body(user);
        } catch (IllegalArgumentException | NullPointerException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLogin userLogin) {

        Map resp = new HashMap();
        String token = authService.login(userLogin).getToken();
        resp.put("token", token);
        return ResponseEntity.status(200).body(resp);


    }


}
