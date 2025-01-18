package org.example.registerlogin.Repository;

import org.example.registerlogin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//we will pass the Entity class Name and Datatype of the primary key
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
