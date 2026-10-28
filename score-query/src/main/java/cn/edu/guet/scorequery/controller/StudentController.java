package cn.edu.guet.scorequery.controller;

import cn.edu.guet.scorequery.entity.Student;
import cn.edu.guet.scorequery.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final ScoreService scoreService;

    public StudentController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return scoreService.listStudents();
    }
}
