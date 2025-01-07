package ici.er.pkmn.services;

import ici.er.pkmn.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        String username = userDTO.getUsername();

        UserDTO user = new UserDTO(username, encodedPassword, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

        jdbcUserDetailsManager.createUser(user);
    }
}
