package cn.edu.guet.scorequery.service;

import cn.edu.guet.scorequery.entity.Course;
import cn.edu.guet.scorequery.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> listCourses() {
        return courseRepository.findAll();
    }
}
