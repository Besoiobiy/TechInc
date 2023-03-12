package com.TechInc.blog.repositories;
import com.TechInc.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.security.Principal;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Transactional
    void deleteByEmail(String email);
}