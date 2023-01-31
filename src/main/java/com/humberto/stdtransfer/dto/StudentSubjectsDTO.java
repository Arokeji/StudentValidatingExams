package com.humberto.stdtransfer.dto;
import com.humberto.stdtransfer.model.Subject;
import lombok.Data;
import java.util.List;

@Data
public class StudentSubjectsDTO {
    private int studentId;
    private String studentName;
    private String studentSurname;
    private List<Subject> subjects;
}

