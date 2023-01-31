package com.humberto.stdtransfer.repository;

import com.humberto.stdtransfer.model.Exam;
import com.humberto.stdtransfer.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExamRepository extends JpaRepository <Exam, Integer> {
    List<Exam> findByStudent(Student student_id);
}
