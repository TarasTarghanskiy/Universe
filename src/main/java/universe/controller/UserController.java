package universe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    ResponseEntity<String> helloUser() {
        return new ResponseEntity<>("Hello World, user!", HttpStatus.OK);
    }
}
