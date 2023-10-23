package tn.esprit.ms.Controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ms.Entities.Commentaire;
import tn.esprit.ms.Service.CommentaireService;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin
public class CommentaireController {


    CommentaireService commentaireService;


    @GetMapping("/commentaires")
    private List<Commentaire> getCommentaires() {
        return commentaireService.getCommentaires();
    }

    @GetMapping("/getCommentaireByID/{idComm}")
    private Commentaire getCommentaireByID(Long idComm){
        return commentaireService.getCommentaireByID(idComm);
    }

    @PostMapping("/addCommentaire")
    private Commentaire saveCommentaire(@RequestBody Commentaire commentaire){
        return commentaireService.saveCommentaire(commentaire);
    }

    @PostMapping("/addCommentaires")
    private List<Commentaire> saveCommentaires(@RequestBody List<Commentaire> commentaires){
        return commentaireService.saveAllCommentaires(commentaires);
    }

    @DeleteMapping("/DeleteCommentaire/{idComm}")
    private String deleteCommentaire(@PathVariable Long idComm) {
        return commentaireService.deleteCommentaire(idComm);
    }

    @PutMapping("/updateCommentaire")
    public Commentaire updateCommentaire (@RequestBody Commentaire commentaire){
        return commentaireService.updateCommentaire(commentaire);
    }





    }




