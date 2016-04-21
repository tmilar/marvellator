package org.utn.marvellator.repository;

import com.github.fakemongo.junit.FongoRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.utn.marvellator.MarvellatorApplication;
import org.utn.marvellator.MarvellatorApplicationTests;
import org.utn.marvellator.model.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomas on 4/21/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MarvellatorApplicationTests.class )
//@ComponentScan({ "org.utn.marvellator.repository", "org.utn.marvellator.config"  })
@ComponentScan(basePackageClasses = { UserRepository.class })
@WebAppConfiguration
public class UserRepositoryTest {

    @Rule
    public FongoRule fongoRule = new FongoRule();

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        userRepository.save(new User("fede"));
        assertEquals(1, userRepository.count());
    }

}
