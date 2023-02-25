package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {


    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExamserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            System.out.println("Starting code");
            User aUser = new User();

            aUser.setFirstName("Mehedi");
            aUser.setLastName("Hasan");
            aUser.setUsername("mehedi3");
            aUser.setPassword("1234567");
            aUser.setEmail("mehedi@gmail.com");
            aUser.setProfile("default.png");


            Role role1 = new Role();
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setRole(role1);
            userRole.setUser(aUser);

            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(aUser, userRoleSet);
            System.out.println("User name is: " + user1.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
