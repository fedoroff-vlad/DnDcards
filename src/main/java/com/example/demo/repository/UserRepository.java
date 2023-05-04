package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRace(String race);
    List<User> findByLevelGreaterThanEqual(int level);
    List<User> findByStatsStrengthThanEqual(int strength);

}
