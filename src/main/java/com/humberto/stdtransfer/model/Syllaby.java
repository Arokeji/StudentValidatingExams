package com.humberto.stdtransfer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "syllabys")
public class Syllaby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int syllaby_id;

    @Column
    private String name;
}
