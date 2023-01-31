package com.humberto.stdtransfer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToOne
    @JoinColumn(name = "syllaby_id")
    private Syllaby syllaby;
}
