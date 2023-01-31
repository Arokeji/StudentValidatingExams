package com.humberto.stdtransfer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.humberto.stdtransfer.model.Syllaby;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "syllaby_id")
    private Syllaby syllaby;
}



