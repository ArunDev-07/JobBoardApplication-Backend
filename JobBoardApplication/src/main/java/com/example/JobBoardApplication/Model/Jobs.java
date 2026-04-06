package com.example.JobBoardApplication.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id ;
    @NotBlank
    private String title ;
    @NotBlank
    private String category;
    @NotBlank
    private String companyName ;
    @NotBlank
    private String location ;
    @NotBlank
    private String description ;
    @NotBlank
    private String status ;
    @Column(nullable = true)
    private LocalDate postedDate;
    @Column(nullable = true)
    private String companyLogo;

}
