let inputStudent = document.querySelector(".login__input");
let buttonLogin = document.querySelector(".login__button");
let studentDetails = document.querySelector(".student");
let studentName = document.querySelector(".student__name");
let studentSyllaby = document.querySelector(".student__syllaby");
let studentSubjects = document.querySelector(".student__subjects");
let studentSingleSubject = document.querySelector(".student__singleSubjects");
let createSingleSubject = document.createElement('li');
let examsPassed = [{}];

let URL = "http://localhost:8080/student/";

buttonLogin.addEventListener('click', function(){
    let id = inputStudent.value;

    fetch(URL + id)
    .then(answer => answer.json())
    .then(answer => {
        getExamsPassed(answer.studentId);
        console.log("Examenes aprobados", examsPassed);
        renderStudent(answer);
    })
    .catch(error => {renderStudentError(error)});
});

function renderStudent(student) {
    
    //console.log("Examenes validados: " + examsPassed);

    studentDetails.style.display = 'block';
    studentSubjects.innerHTML = '';
    studentSyllaby.innerHTML = student.subjects[0].syllaby.name;
    studentName.innerHTML = student.studentName + " " + student.studentSurname;

    for (let subj in student.subjects){
        let alreadyPassed = false;

        for(let element in examsPassed) {
            console.log(examsPassed);
            console.log("Id del examen aprobado: " + examsPassed[1].subject.subject_id);
            console.log("Id del examen que compara: " + student.subjects[element].subject_id);
            if(examsPassed[subject].subject.subject_id === student.subjects[element].subject_id) {
                alreadyPassed = true;
            }
        }

        let subjectLi = document.createElement("li");
        subjectLi.className = "student__single-subject"
        let subjectParragraph = document.createElement("p"); 
        subjectParragraph.innerText = student.subjects[subject].name;
        let subjectId = student.subjects[subj].subject_id;
        subjectLi.appendChild(subjectParragraph);
        studentSubjects.appendChild(subjectLi);
        
        if (!alreadyPassed) {
            let validateSubject = document.createElement("button");
            validateSubject.className = "student__validate";
            validateSubject.innerText = 'Validate';
            validateSubject.addEventListener('click', function() {
                validateAction(student.subjects[subj], student, 7.2, true, "01/01/2020");
            })
            subjectLi.appendChild(validateSubject);
        } else {
            let subjectValidated = document.createElement("p");
            subjectValidated.innerText = "Validated";
            subjectLi.appendChild(subjectValidated);
        }
        
    }
}

function getExamsPassed (id) {
    fetch("http://localhost:8080/examspassed/" + id)
    .then(answer => answer.json())
    .then(answer => {
        for(let element in answer) {
            examsPassed.push(answer[element]);
        }
    })
    .catch(error => {renderStudentError(error)});
    //Guardar answer en un array de objetos
}

function validateAction(subjectObject, studentObject, grade, validating, dateExam) {
    
    let currentStudent = {
        student_id: studentObject.studentId,
        name: studentObject.studentName,
        surname: studentObject.studentSurname,
        syllaby: studentObject.subjects[0].syllaby
    }

    let exam = {
        subject: subjectObject,
        student: currentStudent,
        grade: grade,
        validating: true,
        date: dateExam
    }
    
    //console.log(JSON.stringify(exam));

    fetch('http://localhost:8080/examvalidate', {
        method: "POST",
        body: JSON.stringify(exam),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    .then(response => response.json())
    .catch(error => console.log(error));
}

function renderStudentError(error) {
    console.log("Error rendering students: " + error);
}
