package com.humberto.stdtransfer.service;

import com.humberto.stdtransfer.dto.ExamSyllabySubjectsDTO;
import com.humberto.stdtransfer.dto.StudentSubjectsDTO;
import com.humberto.stdtransfer.model.Exam;
import com.humberto.stdtransfer.model.Student;
import com.humberto.stdtransfer.model.Subject;
import com.humberto.stdtransfer.repository.ExamRepository;
import com.humberto.stdtransfer.repository.StudentRepository;
import com.humberto.stdtransfer.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public StudentSubjectsDTO getAllSyllabySubjects(int id) {
        Student student = new Student();
        student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        int syllaby = student
                .getSyllaby().getSyllaby_id();

        List<Subject> currentStudentSubjects= subjectRepository.findAll()
                .stream()
                .filter(element -> element.getSyllaby().getSyllaby_id() == syllaby)
                .collect(Collectors.toList());

        return converEntityToDto(student, currentStudentSubjects);
    }

    private StudentSubjectsDTO converEntityToDto (Student student, List<Subject> subjects) {
        StudentSubjectsDTO studentSubjectsDTO = new StudentSubjectsDTO();
        studentSubjectsDTO.setStudentId(student.getStudent_id());
        studentSubjectsDTO.setStudentName(student.getName());
        studentSubjectsDTO.setStudentSurname(student.getSurname());
        studentSubjectsDTO.setSubjects(subjects);
        return studentSubjectsDTO;
    }


}
