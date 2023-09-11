package com.portafolio.evr.domain.usecase.user;

import com.portafolio.evr.domain.models.gateways.IUserRepository;
import com.portafolio.evr.domain.models.user.User;
import com.portafolio.evr.domain.models.user.UserRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase {
    private final IUserRepository iUserRepository;

    public User save(UserRequest userRequest){
        User user =findByEmail(userRequest.getEmail());
        if(user != null){
            return null;
        }
        return iUserRepository.save(userRequest);
    }

    public User findByEmail(String  email){
        return iUserRepository.findByEmail(email);
    }
}
