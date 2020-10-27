package io.superdeveloper.demo.service;

import io.superdeveloper.demo.api.model.UserModel;
import io.superdeveloper.demo.domain.UserEntity;
import io.superdeveloper.demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel findUserByUsername(String username) {
        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow();

        UserModel user = map(userEntity);
        return user;
    }

    public Long createUser(String username, String firstName, String lastName, Long age) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(username);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setAge(age);

        userEntity = userRepository.save(userEntity);
        return userEntity.getId();
    }


    private UserModel map(UserEntity from) {
        UserModel to = new UserModel();

        to.setUsername(from.getUsername());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setAge(from.getAge());

        return to;
    }

}
