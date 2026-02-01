package com.ui.demo.controller;


import com.ui.demo.requestdto.RequestDTO;
import com.ui.demo.responsedto.ResponseDTO;
import com.ui.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final UserService userservice;

    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registeruser(@Valid @RequestBody RequestDTO requestdto)
    {
        ResponseDTO responseDTO =userservice.registeruser(requestdto);
        return ResponseEntity.ok(responseDTO);

    }

}
