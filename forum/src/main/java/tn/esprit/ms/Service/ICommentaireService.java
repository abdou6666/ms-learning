package tn.esprit.ms.Service;

import tn.esprit.ms.Entities.Commentaire;

import java.util.Date;
import java.util.List;

public interface ICommentaireService {


    public List<Commentaire> getCommentaires();

    public Commentaire getCommentaireByID(Long idCommentaire);

    public Commentaire saveCommentaire(Commentaire commentaire);
    public List<Commentaire> saveAllCommentaires(List<Commentaire> commentaires);

    public String deleteCommentaire(Long idCommentaire);

    public Commentaire updateCommentaire(Commentaire commentaire);

    public void assignCommentaireToPost (Long idCommentaire, Long idPost);




}
