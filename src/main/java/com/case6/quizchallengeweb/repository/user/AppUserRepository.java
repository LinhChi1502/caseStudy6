package com.case6.quizchallengeweb.repository.user;

import com.case6.quizchallengeweb.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    AppUser getAppUserByUsername(String name);
}
