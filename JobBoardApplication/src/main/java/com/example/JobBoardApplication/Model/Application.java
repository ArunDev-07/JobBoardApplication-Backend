package com.example.JobBoardApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private String email;
    private String phone;
    private String resume;

    @Column(length = 1000)
    private String coverLetter;

    private LocalDate appliedDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;

    // getters and setters
}