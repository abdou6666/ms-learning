package tn.lastdance.posts.entity;

import lombok.*;

import javax.persistence.*;

//@Data
//@Builder
//@Document(collation = "posts")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users_table")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
}
