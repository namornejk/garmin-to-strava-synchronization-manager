package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.constants.ApiConstants;
import cz.uhk.garmintostravasynchronizationmanager.model.TokenResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import cz.uhk.garmintostravasynchronizationmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public TokenResponse codeAuth(@RequestParam(name = "code") String code) {
        UserAthlete userAthlete = userService.initAuth(code).get();
        return new TokenResponse(userAthlete.getUserToken());
    }

    @GetMapping("/me")
    public UserAthlete getUser(@RequestHeader(name = ApiConstants.HEADER_NAME) String token) {
        final String jwtToken = token.replaceAll(ApiConstants.PREFIX, "").trim();
        return userService.getUser(jwtToken);
    }
}
