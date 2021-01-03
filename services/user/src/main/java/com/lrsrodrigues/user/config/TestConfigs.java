package com.lrsrodrigues.user.config;

import com.lrsrodrigues.user.entities.User;
import com.lrsrodrigues.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Locale;

@Configurable
@Profile("dev")
public class TestConfigs implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);

        User user1 = new User(null, "Marcos Gomes", "marcos@gmail.com", "000.000.000-00");
        User user2 = new User(null, "Julia Santos", "julia@gmail.com", "000.000.000-00");
        User user3 = new User(null,  "Sergio Silva", "sergio@gmail.com", "000.000.000-00");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
