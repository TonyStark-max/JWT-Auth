package com.somu.LoginSystem.Service;

import com.somu.LoginSystem.Config.JwtService;
import com.somu.LoginSystem.Model.Role;
import com.somu.LoginSystem.Model.User;
import com.somu.LoginSystem.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    public String register(LoginRequest request){
        if(userRepo.existsByEmail(request.getEmail())){
            return "User Already exists"+ request.getEmail();
        }

        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userRepo.save(user);
        return "User Registered Successfully";
    }

    public String login(String email,String password){
        User user=userRepo.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User already exists"));
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }
        return jwtService.generateToken(user.getEmail(),"USER");
    }
}
