package com.example.ums.service.serviceImpl;

import com.example.ums.dto.request.CourseRequestDTO;
import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.repository.CourseRepository;
import com.example.ums.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAllProjectedBy();
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        CourseResponseDTO courseResponseDTO = courseRepository.findProjectedById(id);
        if (Objects.isNull(courseResponseDTO)) {
            throw new RuntimeException("Course with id " + id + " not found");
        }
        return courseResponseDTO;
    }

    @Override
    public void addCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        course.setTitle(courseRequestDTO.title());
        course.setDepartmentName(courseRequestDTO.departmentName());
        course.setCredits(courseRequestDTO.credits());

        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Course with id " + id + " not found"));
        course.setTitle(courseRequestDTO.title());
        course.setDepartmentName(courseRequestDTO.departmentName());
        course.setCredits(courseRequestDTO.credits());

        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        if( !courseRepository.existsById(id)) {
            throw new RuntimeException("Course with id " + id + " not found");
        }
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseResponseDTO> getAllCoursesByInstructorId(Long id) {
        return courseRepository.findAllByInstructorId(id);
    }
}







