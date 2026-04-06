package com.example.JobBoardApplication.Controller;

import com.example.JobBoardApplication.Model.Admin;
import com.example.JobBoardApplication.Model.Application;
import com.example.JobBoardApplication.Model.Jobs;
import com.example.JobBoardApplication.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class JobController {
    @Autowired
    private JobService jobService;
    
    @GetMapping("/alljobs")
    public List<Jobs> getAllJobs(){
        return jobService.getAllJobs() ;
    }
    @GetMapping("/testing")
    public String Testing(){
        return "Working Successfully" ;
    }

    @PostMapping("/admin/addjob")
    public String AddJobs(@RequestBody Jobs jobs){
        jobService.addJob(jobs) ;
        return "Added Successfully" ;
    }
    @PostMapping("/admin/addjobs")
    public String AddJobs(@RequestBody List<Jobs> jobs){
        jobService.addJobs(jobs) ;
        return "Added Successfully" ;
    }

    @PutMapping("/admin/updatejobs/{id}")
    public String Update(@PathVariable("id") Long job_id, @RequestBody Jobs jobs){
        jobService.updateJobs(job_id , jobs) ;
        return "Updated Successfully" ;
    }

    @DeleteMapping("/admin/delete/{id}")
    public String Delete(@PathVariable("id") Long job_id ){
        jobService.deleteJobs(job_id);
        return "Deleted Successfully";
    }
    @GetMapping("/getjob/{id}")
    public Jobs getonejob(@PathVariable("id") Long job_id ){
       return  jobService.getOneJob(job_id) ;
    }
    @GetMapping("/search")
    public List<Jobs> getbysearch(@RequestParam("keyword") String keyword ){
        return jobService.getbynameandcategory(keyword) ;
    }
    @GetMapping("/filter")
    public List<Jobs> filterjobs(@RequestParam("location") String location ,@RequestParam("category") String category ){
        return jobService.filterbylocationandcategory(location  , category) ;
    }
    @GetMapping("/jobs")
    public Page<Jobs> getPages(Pageable pageable){
        return jobService.getpageJobs(pageable) ;
    }

//    @GetMapping("/jobs")
//    public Page<Jobs> getAllJobs(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return jobService.getAllJobs(pageable);
//    }

    @PostMapping("/adminlogin")
    public String getLogin(@RequestBody Admin admin){
        boolean result = jobService.checkLogin(admin.getEmail()  , admin.getPassword()) ;

        if(result){
            return "Logined SuccessFully" ;
        }else{
            return "Invalid Credentials" ;
        }
    }

    @PostMapping("/apply/{id}")
    public String Apply(@PathVariable("id") Long job_id ,@RequestBody Application request){
        jobService.applyJobs(job_id , request);
        return "Applied Successfully" ;
    }
    @GetMapping("/admin/applications")
    public List<Application> Applied(){
        return jobService.getAllApplications() ;
    }

    @GetMapping("/admin/application/{id}")
    public Application geteach(@PathVariable("id") Long id){
        return jobService.geteachApplication(id) ;
    }


}
