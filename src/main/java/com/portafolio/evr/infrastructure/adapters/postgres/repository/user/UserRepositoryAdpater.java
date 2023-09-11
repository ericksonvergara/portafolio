package com.portafolio.evr.infrastructure.adapters.postgres.repository.user;


import com.portafolio.evr.domain.models.gateways.IUserRepository;
import com.portafolio.evr.domain.models.user.User;
import com.portafolio.evr.domain.models.user.UserRequest;
import com.portafolio.evr.infrastructure.adapters.postgres.entity.UserDBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Repository
public class UserRepositoryAdpater implements IUserRepository {

    private final IUserRepositoryAdpater iUserRepositoryAdpater;
    @Override
    public User findByEmail(String email) {
        Optional<UserDBO> userDBO = iUserRepositoryAdpater.findByEmail(email);
        log.info("este es el token2: {}", userDBO.toString());
        return userDBO.map(dbo -> User.builder()
                .name(dbo.getName())
                .email(dbo.getEmail())
                .password(dbo.getPassword())
                .secret(dbo.getSecret())
                .build()).orElse(null);

    }

    @Override
    public User save(UserRequest userRequest) {

        UserDBO userDBORe = UserDBO.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .secret(userRequest.getSecret())
                .password(userRequest.getPassword())
                .build();

        UserDBO userDBO = iUserRepositoryAdpater.save(userDBORe);

        return  User.builder()
                .id(userDBO.getId())
                .name(userDBO.getName())
                .email(userDBO.getEmail())
                .secret(userDBO.getSecret())
                .password(userDBO.getPassword())
                .build();
    }

    @Override
    public UserDBO findByEmailSecurity(String email) {
        Optional<UserDBO> userDBO = iUserRepositoryAdpater.findByEmail(email);
        log.info("este es el token2: {}", userDBO.toString());
        return userDBO.get();
    }
}
