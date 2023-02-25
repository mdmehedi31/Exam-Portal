package com.exam.service.imple;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //user creating
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User local= this.userRepository.findByUserName(user.getUserName());

        if(local!=null){
            System.out.println("User is already available.!!");
        }else{
            for (UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local= this.userRepository.save(user);
        }
        return local;
    }


    //getting user by userName
    @Override
    public User gerUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(String userName) {

    }

}
