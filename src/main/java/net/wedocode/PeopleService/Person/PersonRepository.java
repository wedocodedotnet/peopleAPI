/*
Company: WeDoCode.net
GitRepo: https://github.com/wedocodedotnet/javaspringboot
Author: Shaun Kiesewetter
Date: Saturday 14 March 2021
Component: JPA database context.
*/
package net.wedocode.PeopleService.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // Select * from person where email = ?
    // This is jbql and not sql,
    //@Query("Select p FROM Person where p.email = ?1")
    Optional<Person> findPersonByEmail(String email);
}
