package infra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/public")
    public String publicEndpoint() { return "public"; }

    @GetMapping("/private")
    public String privateEndpoint() { return "secret"; }
}
