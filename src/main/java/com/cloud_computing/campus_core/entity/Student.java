package com.cloud_computing.campus_core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String firstName;

    @Column(nullable = false, length = 255)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    private LocalDate dateOfBirth;

}
