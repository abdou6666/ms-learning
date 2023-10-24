package tn.lastdance.posts.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.posts.entity.User;
import tn.lastdance.posts.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users",consumes = "application/json",produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user, KeycloakAuthenticationToken auth) {
        KeycloakPrincipal<KeycloakSecurityContext> principal =
                (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");

        System.out.println(context.getToken());
        System.out.println(context);
        System.out.println(hasUserRole);
        if (hasUserRole) {
            return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public List<User> getUsers(){
         return userService.getUsers();
    }

    @PutMapping("{id}")
    public User updatePost(@RequestBody User post, @PathVariable("id") Long id){
        return userService.updateUser(post);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<User>> deletePost(@PathVariable("id") Long id){
        Optional<User> deleteUser = userService.deleteUser(id);
        if(deleteUser.isPresent()){
            return ResponseEntity.ok(deleteUser);
        }
        return ResponseEntity.notFound().build();
    }
}
