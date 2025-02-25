package com.basepackage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.basepackage.model.Login;
import com.basepackage.model.User;

@Repository
public interface LoginRepo  extends JpaRepository<Login,Long> {
    
    //  Optional<User> (String email);  

    // Optional<User> findByMobileNumber(String mobileNumber);

       Optional<Login>         findByUserIdOrderByLoginTimeStampDesc(Long id);
    

}
