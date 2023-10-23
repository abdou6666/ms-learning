package tn.lastdance.cours.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.lastdance.cours.Response.CommentResponse;

@FeignClient(name = "comments-service", url = "http://localhost:8085", path = "/comments-service")
public interface CommentClient {

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentResponse> getAddressByEmployeeId(@PathVariable("id") Long id);

}

