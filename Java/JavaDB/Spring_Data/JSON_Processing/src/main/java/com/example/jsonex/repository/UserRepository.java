package com.example.jsonex.repository;

import com.example.jsonex.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u " +
            "where (select count(p) from Product p where p.seller.id=u.id)>0" +
            " order by u.lastName,u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThenByFirstName();
}
