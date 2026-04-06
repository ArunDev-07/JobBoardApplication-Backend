package com.example.JobBoardApplication.Repository;

import com.example.JobBoardApplication.Model.Jobs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Jobrepo extends JpaRepository<Jobs, Long> {
    List<Jobs> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrLocationContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(String title, String category , String location , String companyName);
    List<Jobs> findByLocationContainingIgnoreCaseAndCategoryContainingIgnoreCase( String location , String category );

}
