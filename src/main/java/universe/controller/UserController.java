package universe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    ResponseEntity<String> helloUser() {
        return new ResponseEntity<>("Hello World, user!", HttpStatus.OK);
    }

//    @RequestMapping("/profile")
//    public String defaultAfterLogin(HttpServletRequest request) {
//        if (request.isUserInRole("ADMIN") || request.isUserInRole("USER") ) {
//            return "redirect:/profile";
//        }
//        return "redirect:/login";
//    }
}
