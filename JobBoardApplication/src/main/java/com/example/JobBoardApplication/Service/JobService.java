package com.example.JobBoardApplication.Service;

import com.example.JobBoardApplication.Model.Admin;
import com.example.JobBoardApplication.Model.Application;
import com.example.JobBoardApplication.Model.Jobs;
import com.example.JobBoardApplication.Repository.AdminRepo;
import com.example.JobBoardApplication.Repository.ApplicationRepo;
import com.example.JobBoardApplication.Repository.Jobrepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class JobService {
    @Autowired
    private Jobrepo jobrepo ;

    @Autowired
    private AdminRepo adminRepo ;

    @Autowired
    private ApplicationRepo applicationRepo ;

    public List<Jobs> getAllJobs(){
        return jobrepo.findAll() ;
    }

    public void addJob(Jobs jobs) {
        jobrepo.save(jobs) ;
    }

    public void updateJobs(Long jobId, Jobs jobs) {
        Jobs existing  = jobrepo.findById(jobId).get() ;
        existing.setTitle(jobs.getTitle());
        existing.setCompanyName(jobs.getCompanyName());
        existing.setLocation(jobs.getLocation());
        existing.setCategory(jobs.getCategory());
        existing.setDescription(jobs.getDescription());
        existing.setStatus(jobs.getStatus());
        existing.setPostedDate(jobs.getPostedDate());
        existing.setCompanyLogo(jobs.getCompanyLogo());

         jobrepo.save(existing) ;

    }

    public void deleteJobs(Long jobId) {
        jobrepo.deleteById(jobId);
    }

    public Jobs getOneJob(Long jobId) {
        return jobrepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public List<Jobs> getbynameandcategory(String keyword) {
        return jobrepo.findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrLocationContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(keyword , keyword , keyword , keyword);
    }

    public void addJobs(List<Jobs> jobs) {
        jobrepo.saveAll(jobs) ;
    }

    public List<Jobs> filterbylocationandcategory(String location, String category) {
        return jobrepo.findByLocationContainingIgnoreCaseAndCategoryContainingIgnoreCase(location,category);
    }

    public Page<Jobs> getpageJobs(Pageable pageable) {
        return jobrepo.findAll(pageable) ;
    }

    public boolean checkLogin(String email , String password) {
        Admin admin = adminRepo.findByEmail(email) ;

        if(admin!= null && admin.getPassword().equals(password)){
            return true ;
        }else{
            return false ;
        }
    }

    public void applyJobs(Long jobId, Application request) {
        Jobs jobs = jobrepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found")) ;
        Application app = new Application() ;
        app.setApplicantName(request.getApplicantName());
        app.setEmail(request.getEmail());
        app.setPhone(request.getPhone());
        app.setResume(request.getResume());
        app.setCoverLetter(request.getCoverLetter());
        app.setAppliedDate(LocalDate.now());
        app.setStatus("APPLIED");
        app.setJob(jobs);

        applicationRepo.save(app) ;
    }

    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    public Application geteachApplication(Long id) {
        return applicationRepo.findById(id).get() ;
    }
}
