package com.ui.demo.service;


import com.ui.demo.entity.User;
import com.ui.demo.repository.UserRepository;
import com.ui.demo.requestdto.RequestDTO;
import com.ui.demo.responsedto.ResponseDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordencoder;

    //constructor injection
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordencoder) {
        this.userRepository = userRepository;
        this.passwordencoder = passwordencoder;
    }

    @Override
    public ResponseDTO registeruser(@org.jetbrains.annotations.NotNull RequestDTO requestDTO)
    {
        //checking email
        if(userRepository.existsByEmail(requestDTO.getEmail()))
        {
            throw new RuntimeException("Email already existed");
        }
        //checking username
        if(userRepository.existsByUsername(requestDTO.getUsername()))
        {
            throw new RuntimeException("Username already existed");
        }
        User user=new User();
        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(passwordencoder.encode(requestDTO.getPassword()));

        User saveduser=userRepository.save(user);
        ResponseDTO responsedto=new ResponseDTO();
        responsedto.setEmail(requestDTO.getEmail());
        responsedto.setUsername(requestDTO.getUsername());
        responsedto.setId(saveduser.getId());


        return responsedto;
    }
}
