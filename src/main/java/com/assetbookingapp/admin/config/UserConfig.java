package com.assetbookingapp.admin.config;

import com.assetbookingapp.admin.model.UserType;
import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerForUser(UserRepository userRepository) {
        return args -> {
            Xuser user = new Xuser(
                "testUserName",
                "testUserRole",
                "testEmployeeId",
                true,
                UserType.USER.toString());

            Xuser user1 = new Xuser(
                "testUserName1",
                "testUserRole1",
                "testEmployeeId1",
                false,
                UserType.ADMIN.toString());

            userRepository.saveAll(Arrays.asList(user, user1));
        };
    }
}
