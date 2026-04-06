package com.example.JobBoardApplication.Repository;

import com.example.JobBoardApplication.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application , Long> {
}
