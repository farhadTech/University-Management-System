package com.example.ums.controller;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.model.Instructor;
import com.example.ums.service.InstructorDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/instructor-detail")
public class InstructorDetailController {
    private final InstructorDetailService instructorDetailService;

    @GetMapping
    public ResponseEntity<List<InstructorDetailResponseDTO>> findAllInstructorDetails() {
        return new ResponseEntity<>(instructorDetailService.getAllInstructorDetail(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDetailResponseDTO> findInstructorDetailById(@PathVariable Long id) {
        return new ResponseEntity<>(instructorDetailService.getInstructorDetailById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createInstructorDetail(@Valid @RequestBody InstructorDetailRequestDTO instructorDetailRequestDTO) {
        instructorDetailService.createInstructorDetail(instructorDetailRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Successfully created instructor detail");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInstructorDetail(@PathVariable Long id, @RequestBody InstructorDetailRequestDTO instructorDetailRequestDTO) {
        instructorDetailService.updateInstructorDetail(id, instructorDetailRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully updated instructor detail");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructorDetail(@PathVariable Long id) {
        instructorDetailService.deleteInstructorDetail(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Successfully deleted instructor detail");
    }

//    @GetMapping("/instructor/{id}")
//    public ResponseEntity<InstructorDetailResponseDTO> getInstructorByInstructorDetailId(@PathVariable Long id) {
//        return new ResponseEntity<>(instructorDetailService.getInstructorByInstructorDetailId(id), HttpStatus.OK);
//    }
}













