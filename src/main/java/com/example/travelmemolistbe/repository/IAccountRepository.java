package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<User,Long> {
}
