package com.assetbookingapp.admin.config;

import com.assetbookingapp.admin.model.Xuser;
import com.assetbookingapp.admin.repository.XuserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class XuserConfig {

    @Bean
    CommandLineRunner commandLineRunnerForUser(XuserRepository userRepository) {
        return args -> {
            Xuser user = new Xuser(
                "testUserName",
                "testUserRole",
                "testEmployeeId",
                true);

            Xuser user1 = new Xuser(
                "testUserName1",
                "testUserRole1",
                "testEmployeeId1",
                false);

            userRepository.saveAll(Arrays.asList(user, user1));
        };
    }
}
