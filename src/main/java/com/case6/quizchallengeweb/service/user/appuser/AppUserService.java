package com.case6.quizchallengeweb.service.user.appuser;
import com.case6.quizchallengeweb.model.user.AppRole;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.model.user.UserPrinciple;
import com.case6.quizchallengeweb.repository.user.AppUserRepository;
import com.case6.quizchallengeweb.service.user.approle.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private IAppRoleService appRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser save(AppUser user) {
        if (user.getRoles() == null) {
            AppRole role = appRoleService.findByName("ROLE_USER");
            Set<AppRole> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUsername(username).get();
        return UserPrinciple.build(user);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username).get();
    }


    @Override
    public AppUser getUserByName(String name) {
        return appUserRepository.getAppUserByUsername(name);
    }

    @Override
    public AppUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        AppUser appUser = this.getUserByName(name);
        return appUser;
    }

}
