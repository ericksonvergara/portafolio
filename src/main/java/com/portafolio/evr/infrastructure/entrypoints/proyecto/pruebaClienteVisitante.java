package com.portafolio.evr.infrastructure.entrypoints.proyecto;


import com.portafolio.evr.domain.models.user.UserLogin;
import com.portafolio.evr.infrastructure.adapters.security.Auth.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Log4j2
public class pruebaClienteVisitante {

    private final AuthService authService;


//    @PostMapping("registry")
//    public ResponseEntity<?> savePlayer(@RequestBody UserRequest userRequest, HttpServletResponse response) {
//
//        try {
//            String passEncode = new BCryptPasswordEncoder().encode(userRequest.getPassword());
//            userRequest.setPassword(passEncode);
//            User user = userUseCase.save(userRequest);
////            response.addHeader("Authorization", "Bearer " + token);
//            return ResponseEntity.status(201).body(user);
//        } catch (IllegalArgumentException | NullPointerException e) {
//            return ResponseEntity.status(400).body(e.getMessage());
//        }
//
//    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLogin userLogin) {

        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAA");
        Map resp = new HashMap();
        //  System.out.println("passllegadoa " + new BCryptPasswordEncoder().encode(userLogin.getPassword()));
          String passEncode = new BCryptPasswordEncoder().encode(userLogin.getPassword());
        userLogin.setPassword(passEncode);
        System.out.println("passgetuserlogin" + userLogin.getPassword());
        String token = authService.login(userLogin).getToken();
        resp.put("token", token);
///            User user = userUseCase.findByEmail(userLogin.getEmail());
        return ResponseEntity.status(200).body(resp);


    }

    //
    @GetMapping("/hola")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok("HOLA");
    }


}
