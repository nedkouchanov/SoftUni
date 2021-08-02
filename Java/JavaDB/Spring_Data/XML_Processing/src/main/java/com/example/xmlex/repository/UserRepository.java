package com.example.xmlex.repository;

import com.example.xmlex.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u " +
            "WHERE (select count(p) from Product p where p.seller.id = u.id " +
            "and p.buyer is not null) > 0 " +
            "order by u.lastName,u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProduct();
}
