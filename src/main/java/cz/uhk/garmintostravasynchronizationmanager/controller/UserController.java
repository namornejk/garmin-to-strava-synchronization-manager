package cz.uhk.garmintostravasynchronizationmanager.controller;

import cz.uhk.garmintostravasynchronizationmanager.constants.ApiConstants;
import cz.uhk.garmintostravasynchronizationmanager.model.RequestCode;
import cz.uhk.garmintostravasynchronizationmanager.model.UserTokenResponse;
import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import cz.uhk.garmintostravasynchronizationmanager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api(value = "User", tags = "User")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Authenticate user", description = "Authenticate user via Strava auth code", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User authenticated", content = @Content(schema = @Schema(implementation = UserTokenResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error"),
    })
    @PostMapping("/auth")
    public UserTokenResponse codeAuth(@RequestBody() RequestCode requestCode) {
        UserAthlete userAthlete = userService.initAuth(requestCode.getCode());
        return new UserTokenResponse(userAthlete.getUserToken(), userAthlete);
    }

    @Operation(summary = "User detail", description = "Get information about me", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User detail info", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserAthlete.class)))),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal error"),
    })
    @GetMapping("/me")
    public UserAthlete getUser(@RequestHeader(name = ApiConstants.HEADER_NAME) String token) {
        final String jwtToken = token.replaceAll(ApiConstants.PREFIX, "").trim();
        return userService.getUser(jwtToken);
    }
}
