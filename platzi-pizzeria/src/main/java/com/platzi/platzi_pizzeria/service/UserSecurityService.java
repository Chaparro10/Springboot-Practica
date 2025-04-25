package com.platzi.platzi_pizzeria.service;


import com.platzi.platzi_pizzeria.persistence.entity.UserEntity;
import com.platzi.platzi_pizzeria.persistence.entity.UserRoleEntity;
import com.platzi.platzi_pizzeria.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserSecurityService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findById(username).orElseThrow(()->new UsernameNotFoundException("USER NOT FOUND"));

        String [] roles = user.getRoleEntityList().stream().map(UserRoleEntity::getRole).toArray(String[]::new);
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .accountLocked(user.getLocked())
                .disabled(user.getDisabled()).build();
    }
}
