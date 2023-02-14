package com.exam.service.definition;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {
    //User Creating
    public User createUser(User user, Set<UserRole> userRoles);

    //Get User by username

    public User gerUser(String userName);

    //delete user
    public void deleteUser(Long userId);

    public void updateUser(String userName);
}
