package com.case6.quizchallengeweb.repository.question;

import com.case6.quizchallengeweb.model.question.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByNameIs(String name);
}
