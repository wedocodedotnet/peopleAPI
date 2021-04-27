/*
Company: WeDoCode.net
GitRepo: https://github.com/wedocodedotnet/javaspringboot
Author: Shaun Kiesewetter
Date: Saturday 14 March 2021
Component: Populate some data at start up. (Seeding class)
*/
package net.wedocode.PeopleService.Person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;


@Configuration
public class PersonConfig {

    // Seeding configuration
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args ->{
            Person shaun = new Person("Shaun Kiesewetter", "shaun.kiesewetter@gmail.com", LocalDate.of(1973, Month.MARCH, 7));
            Person kim = new Person("Kim Kiesewetter", "Kim.Kiesewetter@marsh.com",LocalDate.of(1980, Month.OCTOBER, 3));
            repository.saveAll(Arrays.asList(new Person[]{shaun, kim}));
        };
    }
}
