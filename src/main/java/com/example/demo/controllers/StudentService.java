package com.example.demo.controllers;

import com.example.demo.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/*
Zadania do samodzielnego wykonania :
Terminologia:
API = Aplikacja zahostowana na porcie 8081, która ma połączenie z bazą danych
Klient  = Aplikacja z widokiem, zahostowana na porcie 8082

Zadanie 1: Klient
Stwórz klasę StudentService. W tej klasie mają znajdować się wszystkie (4 – add, update, post i getStudents)
metody wykonujące żądania do API.
Spraw, aby każda z metod POSTowych i GET showStudents w PageController pobierała dane z API za pomocą StudentService
*/

@Service
public class StudentService {
    @Autowired
    RestTemplate restTemplate;

    public void deleteStudent(Student student){
        HttpEntity<Student> request = new HttpEntity<Student>(student);
        ResponseEntity<Student> response = restTemplate
                .exchange("http://localhost:8081/student/"+student.getId(), HttpMethod.DELETE, request, Student.class);

    }

    public void updateStudent(Student student){
        HttpEntity<Student> request = new HttpEntity<Student>(student);
        ResponseEntity<Student> response = restTemplate
                .exchange("http://localhost:8081/student", HttpMethod.PUT, request, Student.class);

    }

//    public ResponseEntity postStudent(Student student){
//        HttpEntity<Student> request = new HttpEntity<Student>(student);
//        ResponseEntity<Student> response = restTemplate
//                .exchange("https://localhost:8081/student", HttpMethod.POST, request, Student.class);
//        return response;
//
//    }

    public void postStudent(Student student){
        HttpEntity<Student> request = new HttpEntity<Student>(student);
        ResponseEntity<Student> response = restTemplate
                .exchange("http://localhost:8081/student", HttpMethod.POST, request, Student.class);

    }

    public List<Student> getStudent(){
        ResponseEntity<Student[]> response = restTemplate.getForEntity("http://localhost:8081/students", Student[].class);
        return Arrays.asList(response.getBody());

    }



}
