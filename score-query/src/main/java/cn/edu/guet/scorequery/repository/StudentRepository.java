package cn.edu.guet.scorequery.repository;

import cn.edu.guet.scorequery.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> students = List.of(
            new Student("2023010001", "张明", "计算机2301"),
            new Student("2023010002", "李婷", "计算机2301"),
            new Student("2023010003", "王浩", "计算机2301"),
            new Student("2023010004", "陈静", "计算机2302"),
            new Student("2023010005", "刘洋", "计算机2302")
    );

    public List<Student> findAll() {
        return students;
    }
}
