package cz.uhk.garmintostravasynchronizationmanager.controller;

import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import cz.uhk.garmintostravasynchronizationmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(){}

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/code")
    public ResponseEntity<UserAthlete> codeAuth(@RequestParam(name = "code")String code){
        UserAthlete userAthlete = userService.initAuth(code).get();

        ResponseEntity<UserAthlete> response = ResponseEntity.ok()
                .header("authorization", userAthlete.getUserToken())
                .body(userAthlete);

        return response;
    }

    @PostMapping("/me")
    public UserAthlete getUser(@RequestParam(name = "userToken")String userToken){
        return userService.getUser(userToken);
    }
}
