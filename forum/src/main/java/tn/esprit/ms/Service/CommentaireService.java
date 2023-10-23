package tn.esprit.ms.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ms.Entities.*;
import tn.esprit.ms.Repository.*;
import tn.esprit.ms.Repository.PostRepository;

import java.util.List;


@AllArgsConstructor
@Service
public class CommentaireService implements ICommentaireService {


    ComentaireRepository comentaireRepository;
    PostRepository postRepository;


    @Override
    public List<Commentaire> getCommentaires() {
        return comentaireRepository.findAll();
    }

    @Override
    public Commentaire getCommentaireByID(Long idCommentaire) {
        return comentaireRepository.findById(idCommentaire).get();
    }

    @Override
    public Commentaire saveCommentaire(Commentaire commentaire) {
        return comentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> saveAllCommentaires(List<Commentaire> commentaires) {
        return comentaireRepository.saveAll(commentaires);
    }

    @Override
    public String deleteCommentaire(Long idCommentaire) {
        comentaireRepository.deleteById(idCommentaire);
        return "Commentaire supprimé !";
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        Commentaire existingCommentaire = comentaireRepository.findById(commentaire.getId()).orElse(null);
        assert existingCommentaire != null;
        existingCommentaire.setUsername(commentaire.getUsername());
        existingCommentaire.setReponse(commentaire.getReponse());


        return comentaireRepository.save(existingCommentaire);
    }

    @Override
    public void assignCommentaireToPost(Long idCommentaire, Long idPost) {

        Commentaire commentaire = this.comentaireRepository.findById(idCommentaire).orElse(null);
        Post post = this.postRepository.findById(idPost).orElse(null);

        commentaire.setPost(post);
        comentaireRepository.save(commentaire);

    }
}
