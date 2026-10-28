package cn.edu.guet.scorequery.service;

import cn.edu.guet.scorequery.dto.ScoreView;
import cn.edu.guet.scorequery.entity.Course;
import cn.edu.guet.scorequery.entity.Score;
import cn.edu.guet.scorequery.entity.Student;
import cn.edu.guet.scorequery.repository.CourseRepository;
import cn.edu.guet.scorequery.repository.ScoreRepository;
import cn.edu.guet.scorequery.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ScoreService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(StudentRepository studentRepository,
                        CourseRepository courseRepository,
                        ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.scoreRepository = scoreRepository;
    }

    public List<Student> listStudents() {
        List<Student> sorted = new ArrayList<>(studentRepository.findAll());
        sorted.sort(Comparator.comparing(Student::getStudentNo));
        return sorted;
    }

    public List<ScoreView> listScoresByStudentNo(String studentNo) {
        List<Score> scores = scoreRepository.findByStudentNo(studentNo);
        List<ScoreView> result = new ArrayList<>();

        for (Score score : scores) {
            Course course = courseRepository.findByCourseId(score.getCourseId()).orElse(null);
            if (course == null) {
                continue;
            }
            result.add(new ScoreView(
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCredit(),
                    score.getScore()
            ));
        }
        return result;
    }
}
