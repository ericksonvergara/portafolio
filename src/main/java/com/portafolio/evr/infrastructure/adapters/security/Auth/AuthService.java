package com.portafolio.evr.infrastructure.adapters.security.Auth;

import com.portafolio.evr.domain.models.user.UserLogin;
import com.portafolio.evr.domain.models.user.UserRequest;
import com.portafolio.evr.infrastructure.Jwt.JwtService;
import com.portafolio.evr.infrastructure.adapters.postgres.entity.Role;
import com.portafolio.evr.infrastructure.adapters.postgres.entity.UserDBO;
import com.portafolio.evr.infrastructure.adapters.postgres.repository.user.IUserRepositoryAdpater;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepositoryAdpater userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(UserLogin request) {
        System.out.println("entra del metodo"+request.toString());
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        System.out.println("userdetai"+ user.getPassword()+"-"+user.getUsername());
        if(user != null){
            boolean coinciden = BCrypt.checkpw(request.getPassword(), user.getPassword());

            if (coinciden) {
                System.out.println("La contraseña es válida.");
            } else {
                System.out.println("La contraseña es incorrecta.");
                return AuthResponse.builder()
                        .token("user o password incorrecta")
                        .build();
            }

        }
        System.out.println("usuario obtenido"+user);
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(UserRequest request) {
        System.out.println(request);
        UserDBO user =
                UserDBO.builder()
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .email(request.getEmail())
                .secret(request.getSecret())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

}
