package com.humberto.stdtransfer.controller;

import com.humberto.stdtransfer.model.Exam;
import com.humberto.stdtransfer.repository.ExamRepository;
import com.humberto.stdtransfer.repository.StudentRepository;
import com.humberto.stdtransfer.service.StudentService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.humberto.stdtransfer.dto.StudentSubjectsDTO;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student/{id}")
    public StudentSubjectsDTO getAllSubjectsUser(@PathVariable Integer id) {
        return studentService.getAllSyllabySubjects(id);
    }
}
