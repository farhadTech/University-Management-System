package com.example.ums.service.serviceImpl;

import com.example.ums.common.exception.IDNotFoundException;
import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.model.Instructor;
import com.example.ums.model.InstructorDetail;
import com.example.ums.repository.CourseRepository;
import com.example.ums.repository.InstructorDetailRepository;
import com.example.ums.repository.InstructorRepository;
import com.example.ums.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository;
    private InstructorDetailRepository instructorDetailRepository;
    private CourseRepository courseRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository,
                                 InstructorDetailRepository instructorDetailRepository,
                                 CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorRepository.findAllInstructors();
    }

    @Override
    public InstructorResponseDTO getInstructorById(Long id) {
        InstructorResponseDTO instructorResponseDTO = instructorRepository.findInstructorById(id);
        if(instructorResponseDTO == null) {
            throw new IDNotFoundException("Instructor not found");
        }
        return instructorResponseDTO;
    }

    @Override
    public Instructor createInstructor(InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = new Instructor();
        instructor.setFullName(instructorRequestDTO.fullName());
        instructor.setUsername(instructorRequestDTO.username());
        instructor.setEmail(instructorRequestDTO.email());

        InstructorDetail instructorDetail =
                instructorDetailRepository.getInstructorDetailId(instructorRequestDTO.instructorDetailId());
        if (instructorDetail == null) {
            throw new IDNotFoundException("Instructor not found for id: " + instructorRequestDTO.instructorDetailId());
        }
        instructor.setInstructorDetail(instructorDetail);

        Set<Course> courses = new LinkedHashSet<>();
        for(Long courseId : instructorRequestDTO.courseIds()) {
            Course course = courseRepository.getCourseById(courseId);

            if(course != null) {
                courses.add(course);
            } else {
                throw new IDNotFoundException("Course not found found for id: " + courseId);
            }
        }
        instructor.setCourses(courses);

        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = instructorRepository.getInstructorById(id);
        if(instructor == null) {
            throw new IDNotFoundException("Instructor not found for id: " + id);
        }
        instructor.setFullName(instructorRequestDTO.fullName());
        instructor.setUsername(instructorRequestDTO.username());
        instructor.setEmail(instructorRequestDTO.email());

        InstructorDetail instructorDetail = instructorDetailRepository.getInstructorDetailId(instructorRequestDTO.instructorDetailId());
        if (instructorDetail == null) {
            throw new IDNotFoundException("Instructor not found for id: " + id);
        }
        instructor.setInstructorDetail(instructorDetail);

        Set<Course> courses = new LinkedHashSet<>();
        for(Long courseId : instructorRequestDTO.courseIds()) {
            Course course = courseRepository.getCourseById(courseId);
            if(course != null) {
                courses.add(course);
            } else {
                throw new IDNotFoundException("Course not found for id: " + courseId);
            }
        }
        instructor.setCourses(courses);

        return instructorRepository.save(instructor);
    }

    @Override
    public String deleteInstructorById(Long id) {
        instructorRepository.deleteById(id);
        return "Instructor deleted";
    }

//
//    @Override
//    public InstructorResponseDTO getInstructorDetailByInstructorId(Long id){
//        return instructorRepository.findInstructorDetailByInstructorId(id)
//                .orElseThrow(() -> new RuntimeException("Instructor detail not found with id: " + id));
//    }
}







