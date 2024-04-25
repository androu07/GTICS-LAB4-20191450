package com.example.lab4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="jobs")
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jobs_id")
    private int id;
    @Column(nullable = false)
    private String job_title;
    private int min_salary;
    private int max_salary;
}
