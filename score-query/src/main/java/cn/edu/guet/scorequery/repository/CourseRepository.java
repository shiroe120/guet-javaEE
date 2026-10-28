package cn.edu.guet.scorequery.repository;

import cn.edu.guet.scorequery.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private final List<Course> courses = List.of(
            new Course("C001", "Java EE 程序设计", 3.0),
            new Course("C002", "数据库原理", 3.5),
            new Course("C003", "计算机网络", 2.5)
    );

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findByCourseId(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return Optional.of(course);
            }
        }
        return Optional.empty();
    }
}
