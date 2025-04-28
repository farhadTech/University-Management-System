package com.example.ums.service.serviceImpl;

import com.example.ums.common.exception.IDNotFoundException;
import com.example.ums.dto.request.CourseRequestDTO;
import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.model.Instructor;
import com.example.ums.model.Review;
import com.example.ums.model.Student;
import com.example.ums.repository.CourseRepository;
import com.example.ums.repository.InstructorRepository;
import com.example.ums.repository.ReviewRepository;
import com.example.ums.repository.StudentRepository;
import com.example.ums.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;
    private ReviewRepository reviewRepository;
    private StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             InstructorRepository instructorRepository,
                             ReviewRepository reviewRepository,
                             StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.reviewRepository = reviewRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        CourseResponseDTO courseResponseDTO = courseRepository.findCourseById(id);
        if (Objects.isNull(courseResponseDTO)) {
            throw new IDNotFoundException("Course not found with id: " + id);
        }
        return courseResponseDTO;
    }

    @Override
    public Course createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();

        course.setTitle(courseRequestDTO.title());
        course.setDepartmentName(courseRequestDTO.departmentName());
        course.setCredits(courseRequestDTO.credits());

        Instructor instructor = instructorRepository.getInstructorById(courseRequestDTO.instructorId());
        course.setInstructor(instructor);

        Set<Review> reviews = reviewRepository.getReviewByIdIsIn(courseRequestDTO.reviewIds());
        course.setReviews(reviews);

        Set<Student> students = studentRepository.getStudentByIdIsIn(courseRequestDTO.studentIds());
        course.setStudents(students);

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.getCourseById(id);
        if(course == null) {
            throw new IDNotFoundException("Course not found with id: " + id);
        }

        course.setTitle(courseRequestDTO.title());
        course.setDepartmentName(courseRequestDTO.departmentName());
        course.setCredits(courseRequestDTO.credits());

        Instructor instructor = instructorRepository.getInstructorById(courseRequestDTO.instructorId());
        course.setInstructor(instructor);

        Set<Review> reviews = reviewRepository.getReviewByIdIsIn(courseRequestDTO.reviewIds());
        course.setReviews(reviews);

        Set<Student> students = studentRepository.getStudentByIdIsIn(courseRequestDTO.studentIds());
        course.setStudents(students);

        return courseRepository.save(course);
    }

    @Override
    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return "Course deleted";
    }
}







