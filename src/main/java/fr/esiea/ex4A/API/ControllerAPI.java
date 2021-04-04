package fr.esiea.ex4A.API;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ControllerAPI {
    private final AgifyService agifyService;

    public ControllerAPI(AgifyService agifyService) { this.agifyService = agifyService; }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody InfoUtilisateur userInfo) throws IOException {
        System.out.println(userInfo);
        this.agifyService.addUser(userInfo);
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<InfoUtilisateur> getMatchingUsers(@RequestParam(name = "userName", required = true) String name, @RequestParam(name = "userCountry", required = true) String country) {
        List<InfoUtilisateur> userList = this.agifyService.matchUser(name, country);
        return userList;
    }
}
