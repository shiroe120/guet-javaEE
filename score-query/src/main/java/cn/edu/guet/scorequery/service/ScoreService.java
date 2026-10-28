package cn.edu.guet.scorequery.service;

import cn.edu.guet.scorequery.entity.Student;
import cn.edu.guet.scorequery.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ScoreService {
    private final StudentRepository studentRepository;

    public ScoreService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listStudents() {
        List<Student> sorted = new ArrayList<>(studentRepository.findAll());
        sorted.sort(Comparator.comparing(Student::getStudentNo));
        return sorted;
    }
}
