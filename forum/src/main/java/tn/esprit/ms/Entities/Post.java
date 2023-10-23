package tn.esprit.ms.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String content;



    @ManyToOne
    @JsonIgnore
    private Forum forum;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    private Set<Commentaire> commentaires;

}
