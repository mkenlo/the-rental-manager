package com.mkenlo.rentalmanager.services;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mkenlo.rentalmanager.models.Applicant;
import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.models.LoginUser;
import com.mkenlo.rentalmanager.models.PropertyManager;
import com.mkenlo.rentalmanager.models.Role;
import com.mkenlo.rentalmanager.models.Tenant;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.repositories.ApplicantRepository;
import com.mkenlo.rentalmanager.repositories.LandlordRepository;
import com.mkenlo.rentalmanager.repositories.PropertyManagerRepository;
import com.mkenlo.rentalmanager.repositories.RoleRepository;
import com.mkenlo.rentalmanager.repositories.TenantRepository;
import com.mkenlo.rentalmanager.repositories.UserRepository;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository userRepository;
    RoleRepository roleRepository;

    TenantRepository tenantRepository;
    LandlordRepository landlordRepository;
    PropertyManagerRepository managerRepository;
    ApplicantRepository applicantRepository;

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public UserService(UserRepository userRepository, RoleRepository roleRepository, TenantRepository tenantRepository,
            LandlordRepository landlordRepository, PropertyManagerRepository managerRepository,
            ApplicantRepository applicantRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tenantRepository = tenantRepository;
        this.landlordRepository = landlordRepository;
        this.managerRepository = managerRepository;
        this.applicantRepository = applicantRepository;
    }

    public User createUser(User user, BindingResult result) {

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            result.rejectValue("password", "match", "Confirm Password must Match Password");
        } else if (userRepository.findByUsername(user.getUsername()) != null) {
            result.rejectValue("username", "exist", "Username already exist");
        }
        if (result.hasErrors())
            return null;
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);

        return userRepository.save(user);
    }

    public User doLogin(LoginUser user, BindingResult result) {

        User potentialUser = userRepository.findByUsername(user.getUsername());
        if (potentialUser == null) {
            result.rejectValue("username", "exist", "Username not found");
        } else if (!BCrypt.checkpw(user.getPassword(), potentialUser.getPassword()))
            result.rejectValue("password", "match", "Invalid Password");
        if (result.hasErrors())
            return null;
        return potentialUser;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void setUserProfile(Role role, User user) {
        switch (role.getName().toLowerCase()) {
            case "role_resident":
                Tenant tenant = new Tenant();
                tenant.setProfile(user);
                tenantRepository.save(tenant);
                user.setTenant(tenant);
                break;
            case "role_applicant":
                Applicant applicant = new Applicant();
                applicant.setProfile(user);
                applicantRepository.save(applicant);
                user.setApplicant(applicant);
                break;
            case "role_landlord":
                Landlord landlord = new Landlord();
                landlord.setProfile(user);
                landlordRepository.save(landlord);
                break;
            case "role_manager":
                PropertyManager pm = new PropertyManager();
                pm.setProfile(user);
                managerRepository.save(pm);
                break;

        }
    }
}
