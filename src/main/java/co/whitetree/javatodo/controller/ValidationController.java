package co.whitetree.javatodo.controller;

import co.whitetree.javatodo.dto.ValidationRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    @GetMapping("/validation")
    public String requestQueryString(@Valid ValidationRequest request) {
        return "id: " + request.getId() + ", code: " + request.getCode();
    }
}
