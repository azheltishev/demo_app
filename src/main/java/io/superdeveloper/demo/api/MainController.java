package io.superdeveloper.demo.api;

import io.superdeveloper.demo.api.model.RegisterUserRequest;
import io.superdeveloper.demo.api.model.RegisterUserResponse;
import io.superdeveloper.demo.api.model.UserModel;
import io.superdeveloper.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/get-user/{username}")
    public ResponseEntity<UserModel> getUser(@PathVariable String username) {
        UserModel user = userService.findUserByUsername(username);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/create-user")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest request) {
        Long userId = userService
                .createUser(request.getUsername(), request.getFirstName(), request.getLastName(), request.getAge());

        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(userId);

        return ResponseEntity.ok(response);
    }
}
