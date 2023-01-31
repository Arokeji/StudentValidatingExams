package com.humberto.stdtransfer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExamSyllabySubjectsDTO {
    private int examId;
    private int subjectId;
    private String subjectName;
    private int syllabyId;
    private String syllabyName;
    private int studentId;
    private String studentName;
    private double grade;
    private boolean validating;
    private Date date;
}
