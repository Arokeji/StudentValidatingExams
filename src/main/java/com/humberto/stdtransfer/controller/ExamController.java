package com.humberto.stdtransfer.controller;

import com.humberto.stdtransfer.dto.StudentSubjectsDTO;
import com.humberto.stdtransfer.model.Exam;
import com.humberto.stdtransfer.model.Student;
import com.humberto.stdtransfer.model.Subject;
import com.humberto.stdtransfer.repository.ExamRepository;
import com.humberto.stdtransfer.repository.StudentRepository;
import com.humberto.stdtransfer.service.StudentService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/examvalidate")
    public Exam validatingExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @GetMapping("/examspassed/{id}")
    public List<Exam> findStudentExams (@PathVariable Integer id) {
        Student student = new Student();
        student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        List<Exam> allStudentExams = examRepository.findByStudent(student);
        System.out.println(allStudentExams);
        return allStudentExams;
    }
}
