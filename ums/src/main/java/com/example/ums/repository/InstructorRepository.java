package com.example.ums.repository;

import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<InstructorResponseDTO> findAllProjectedBy();

    InstructorResponseDTO findProjectedById(Long id);

    /**
     *Needs a custom JPQL query since Spring Data can’t resolve cross-projection automatically
     **/

    @Query("""
            SELECT i.instructorDetail 
                        FROM Instructor i 
                                    WHERE i.id = :id
            """)
    Optional<InstructorDetailResponseDTO> findInstructorDetailByInstructorId(@Param("id") Long id);
}
