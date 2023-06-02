package fr.orionbs.experience_project.adapter.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LifeApiAdapter {

    @GetMapping(path = "/")
    @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
    public String getLife() {
        return "Experience Project is on !";
    }

}
