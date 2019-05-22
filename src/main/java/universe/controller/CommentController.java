package universe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import universe.dto.CommentDTO;
import universe.service.CommentService;

import java.util.List;

@Controller
@RequestMapping("/comm")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<List<CommentDTO>> findAll(){
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }
}
