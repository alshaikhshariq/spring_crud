package com.example.spring_crud.services;

import com.example.spring_crud.model.User;
import com.example.spring_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PermissionSetRepository permissionSetRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User user = userRepository.findByUserNameFetchRoles(username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        /*List<PermissionSet> permissions = permissionSetRepository.getPermissionSetsFetchComponentLibrary(user.getRoles()
                .stream().flatMap(r -> r.getPermissionSets().stream()).collect(Collectors.toSet()));*/
        /*Set<String> libraryPermissions = permissions.stream().flatMap(p -> p.getComponentLibraries().stream())
                .map(c -> c.getComponentName()).collect(Collectors.toSet());*/
        return UserDetailsImpl.build(user);
    }

}
