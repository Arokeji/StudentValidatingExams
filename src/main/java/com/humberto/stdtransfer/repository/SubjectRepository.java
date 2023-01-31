package com.humberto.stdtransfer.repository;

import com.humberto.stdtransfer.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
