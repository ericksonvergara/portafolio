package com.portafolio.evr.domain.models.gateways;

import com.portafolio.evr.domain.models.user.User;
import com.portafolio.evr.domain.models.user.UserRequest;
import com.portafolio.evr.infrastructure.adapters.postgres.entity.UserDBO;

public interface IUserRepository {
    User findByEmail(String email);
    User save(UserRequest userRequest);

    UserDBO findByEmailSecurity (String email);
}
