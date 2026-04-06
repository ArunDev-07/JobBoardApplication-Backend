package com.example.JobBoardApplication.Repository;

import com.example.JobBoardApplication.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin , Long> {
    Admin findByEmail(String email) ;
}
