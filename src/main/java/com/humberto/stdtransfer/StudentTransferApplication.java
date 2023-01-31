package com.humberto.stdtransfer;

import com.humberto.stdtransfer.controller.StudentController;
import com.humberto.stdtransfer.model.Exam;
import com.humberto.stdtransfer.model.Student;
import com.humberto.stdtransfer.model.Subject;
import com.humberto.stdtransfer.model.Syllaby;
import com.humberto.stdtransfer.repository.ExamRepository;
import com.humberto.stdtransfer.repository.StudentRepository;
import com.humberto.stdtransfer.repository.SubjectRepository;
import com.humberto.stdtransfer.repository.SyllabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class StudentTransferApplication implements CommandLineRunner{

	//@Autowired
	//ExamRepository examRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentTransferApplication.class, args);
	}

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SyllabyRepository syllabyRepository;

	@Override
	public void run(String... args) throws Exception {

		//Syllays
		Syllaby syllaby1 = new Syllaby();
		syllaby1.setName("Ingenieria Informatica");
		syllabyRepository.save(syllaby1);

		Syllaby syllaby2 = new Syllaby();
		syllaby2.setName("Bellas Artes");
		syllabyRepository.save(syllaby2);


		//Subjects
		Subject subject1 = new Subject();
		subject1.setName("Matematicas");
		subject1.setSyllaby(syllaby1);
		subjectRepository.save(subject1);

		Subject subject2 = new Subject();
		subject2.setName("Redes de computadores");
		subject2.setSyllaby(syllaby1);
		subjectRepository.save(subject2);

		Subject subject3 = new Subject();
		subject3.setName("Algoritmos");
		subject3.setSyllaby(syllaby1);
		subjectRepository.save(subject3);

		Subject subject4 = new Subject();
		subject4.setName("Metodologias");
		subject4.setSyllaby(syllaby1);
		subjectRepository.save(subject4);

		Subject subject5 = new Subject();
		subject5.setName("Fotografia");
		subject5.setSyllaby(syllaby2);
		subjectRepository.save(subject5);

		Subject subject6 = new Subject();
		subject6.setName("Expresionismo");
		subject6.setSyllaby(syllaby2);
		subjectRepository.save(subject6);

		Subject subject7 = new Subject();
		subject7.setName("Historia del arte");
		subject7.setSyllaby(syllaby2);
		subjectRepository.save(subject7);

		Subject subject8 = new Subject();
		subject8.setName("Arte abstracto");
		subject8.setSyllaby(syllaby2);
		subjectRepository.save(subject8);

		//Students
		Student student1 = new Student();
		student1.setName("Rodrigo");
		student1.setSurname("Bautista");
		student1.setSyllaby(syllaby1);
		studentRepository.save(student1);

		Student student2 = new Student();
		student2.setName("Humberto");
		student2.setSurname("Casanova");
		student2.setSyllaby(syllaby2);
		studentRepository.save(student2);

		//Exams
		/*
		Exam exam1 = new Exam();
		exam1.setSubject(subject1);
		exam1.setStudent(student1);
		exam1.setGrade(9.2);
		exam1.setValidating(true);
		exam1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
		*/
		//examRepository.save(exam1);
		//.out.println(exam1);
	}
}
