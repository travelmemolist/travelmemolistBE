package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.dto.AccountInfoDTO;
import com.example.travelmemolistbe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    
    @Query(value = "SELECT new com.example.travelmemolistbe.dto.AccountInfoDTO(u.userId, u.username, u.email, u.firstName, u.lastName, u.age) " +
            "FROM User u " +
            "WHERE u.username = :username")
    AccountInfoDTO getUserByUsername(@Param("username") String username);
}
