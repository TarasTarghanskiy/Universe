package universe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import universe.dto.CommentDTO;
import universe.dto.PublicationDTO;
import universe.service.CommentService;
import universe.service.PublicationService;
import universe.service.UserService;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pub")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public String openPublication(@PathVariable long id, Model model){
        PublicationDTO publicationDTO = publicationService.findById(id);
        model.addAttribute("pub", publicationDTO);

        List<CommentDTO> commentDTOList = commentService.findByPublication(publicationDTO.getId());
        model.addAttribute("comments", commentDTOList);
        return "publication";
    }

    @GetMapping("/all")
    public ResponseEntity<List<PublicationDTO>> findAll(){
        return new ResponseEntity<>(publicationService.findAll() , HttpStatus.OK);
    }

    @GetMapping("/page")
    public String findByPage(
            @PageableDefault Pageable pageable,
            Model model){
        model.addAttribute("publications", publicationService.findAllByPage(pageable));
        return "publications";
    }
}
