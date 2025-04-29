package com.example.ums.repository;

import com.example.ums.dto.response.InstructorCustomResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("""
            SELECT i
            FROM Instructor i
            """)
    List<InstructorResponseDTO> findAllInstructors();

    @Query("""
            SELECT i
            FROM Instructor i
            """)
    List<InstructorCustomResponseDTO> findAllInstructorsCustom();

    @Query("""
            SELECT i
            FROM Instructor i
            WHERE i.id = :id 
            """)
    InstructorResponseDTO findInstructorById(@Param("id") Long id);

    @Query("""
            SELECT i
            FROM Instructor i
            WHERE i.id = :id 
            """)
    Instructor getInstructorById(@Param("id") Long id);

    /**
     * Needs a custom JPQL query since Spring Data can’t resolve cross-projection automatically
     **/

//    @Query("""
//                SELECT i
//                    FROM Instructor i
//                        JOIN FETCH i.instructorDetail
//                            WHERE i.id = :id
//            """)
//    Optional<InstructorResponseDTO> findInstructorDetailByInstructorId(@Param("id") Long id);
}
