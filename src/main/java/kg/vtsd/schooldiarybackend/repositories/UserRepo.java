package kg.vtsd.schooldiarybackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import kg.vtsd.schooldiarybackend.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

    UserDetails findByUsername(String username);
    
}

