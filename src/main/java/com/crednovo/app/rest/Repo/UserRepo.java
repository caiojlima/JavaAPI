package com.crednovo.app.rest.Repo;

import com.crednovo.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long>{
}
