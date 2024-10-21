package com.sukanya.SpringSecEx.service;

import com.sukanya.SpringSecEx.model.Users;
import com.sukanya.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Creating the password encoder with strength

    // Method to register a user and save the encoded password in the repository
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));  // Encode the user's password before saving
        return repo.save(user);  // Save the user in the repository
    }

    // Method to verify the user credentials and return a JWT if authenticated
    public String verify(Users user) {
        // Authenticate the user using Spring Security
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        // If authentication is successful, generate and return a JWT
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());  // Fixed the typo 'generateToekn' to 'generateToken'
        }
        return "Fail";  // Return failure message if authentication fails
    }
}
