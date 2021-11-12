package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {

    @PostMapping("/tokensExchange")
    public ResponseEntity tokenExchange(@RequestParam(name="code") String code, @RequestParam(name="refreshToken") String refreshToken){
        return ResponseEntity.ok().build();
    }

}
