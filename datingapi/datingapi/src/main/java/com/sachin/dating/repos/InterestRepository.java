package com.sachin.dating.repos;

import com.sachin.dating.entities.Interest;
import com.sachin.dating.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest,Integer> {
}
