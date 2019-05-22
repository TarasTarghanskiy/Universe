package universe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import universe.dto.CommentDTO;
import universe.dto.PublicationDTO;
import universe.dto.UserDTO;
import universe.entity.enums.Role;
import universe.service.CommentService;
import universe.service.PublicationService;
import universe.service.UserService;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private PublicationService publicationService;

    @Autowired
    CommentService commentService;

    @GetMapping("/create")
    public String createTestDate() {

        if(userService.userExist("user")) return "redirect:/home";

        UserDTO userDTO = new UserDTO();
        userDTO.setRoles(Collections.singleton(Role.USER));
        userDTO.setEnable(true);
        userDTO.setName("user name");
        userDTO.setUsername("user");
        userDTO.setPassword("u");
        userDTO.setRating(100);
        userService.save(userDTO);

        PublicationDTO publicationDTO;
        for (int m = 0; m < 20; m++) {
            publicationDTO = new PublicationDTO();
            publicationDTO.setText("some text");
            publicationDTO.setName("name of publication");
            publicationDTO.setUserDTO(userService.findUserByName("user"));
            publicationService.save(publicationDTO);
        }

        for (int i = 0; i < 10; i++) {
            commentService.createWithPublication(
                    "some stupid text",
                    publicationService.findById(1).getId(),
                    userDTO.getId());
        }

        return "redirect:/";
    }

//    @GetMapping("/ch/{id}")
//    public ResponseEntity<String> change ( @PathVariable("id") long id, @PathParam("text") String s){
//        commentService.change(s, id);
//        return new ResponseEntity<>("changed", HttpStatus.OK);
//    }
}
