package com.example.ums.controller;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<InstructorResponseDTO>> findAllInstructors() {
        return new ResponseEntity<>(instructorService.getAllInstructors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponseDTO> findInstructorById(@PathVariable Long id) {
        return new ResponseEntity<>(instructorService.getInstructorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createInstructor(@Valid @RequestBody InstructorRequestDTO instructorRequestDTO, InstructorDetailRequestDTO instructorDetailRequestDTO) {
        instructorService.addInstructor(instructorRequestDTO, instructorDetailRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Instructor Created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInstructor(@PathVariable Long id, @RequestBody InstructorRequestDTO instructorRequestDTO) {
        instructorService.updateInstructor(id, instructorRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Instructor updated successfully with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructorById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    @GetMapping("/instructorDetail/{id}")
//    public ResponseEntity<InstructorResponseDTO> getInstructorDetailByInstructorId(@PathVariable Long id) {
//        return new ResponseEntity<>(instructorService.getInstructorDetailByInstructorId(id), HttpStatus.OK);
//    }
}











