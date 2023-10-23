package tn.lastdance.cours.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.lastdance.cours.Entity.Cours;
import tn.lastdance.cours.Reposiroty.CoursRepository;
import tn.lastdance.cours.Response.CommentResponse;
import tn.lastdance.cours.Response.CourResponse;
import tn.lastdance.cours.feignClient.CommentClient;

import java.util.Optional;

@Service
public class CourService {
    @Autowired
    private CoursRepository employeeRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CommentClient commentClient;
    public CourResponse getEmployeeById(Long id) {
        Optional<Cours> employee = employeeRepo.findById(Long.valueOf(id));
        CourResponse employeeResponse = mapper.map(employee, CourResponse.class);

        // Using FeignClient
        ResponseEntity<CommentResponse> addressResponse = commentClient.getAddressByEmployeeId((id));
        employeeResponse.setCommentResponse(addressResponse.getBody());

        return employeeResponse;
    }
}
