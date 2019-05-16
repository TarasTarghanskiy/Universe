package universe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import universe.dto.UserDTO;
import universe.entity.enums.Role;
import universe.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class BaseController {
    @Autowired
    UserService userService;

    @GetMapping("/h1")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/h2")
    ResponseEntity<String> hello2() {
        return new ResponseEntity<>("Hello World2!", HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/h3")
    ResponseEntity<String> hello3() {
        return new ResponseEntity<>("Hello World3!", HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/admin")
    ResponseEntity<String> helloAdmin() {
        return new ResponseEntity<>("Hello World, admin!", HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/user")
    ResponseEntity<String> userAdmin() {
        return new ResponseEntity<>("Hello World, user!", HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/create")
    public ResponseEntity<String> create(){
        for (int i = 0; i < 10; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername("username"+i);
            userDTO.setName("name"+i);
            userDTO.setPassword("password"+i);
            userDTO.setEnable(true);
            userDTO.setRoles(Collections.singleton(Role.USER));
            userService.save(userDTO);
        }
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/";
        }
        return "redirect:/user/";
    }
}
