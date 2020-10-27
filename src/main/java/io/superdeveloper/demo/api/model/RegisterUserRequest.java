package io.superdeveloper.demo.api.model;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String username;
    private String firstName;
    private String lastName;
    private Long age;
}
