package com.case6.quizchallengeweb.service.user.appuser;

import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IService<AppUser> , UserDetailsService {
    AppUser findByUsername(String username);

     AppUser getUserByName(String name);
     AppUser getCurrentUser();
}
