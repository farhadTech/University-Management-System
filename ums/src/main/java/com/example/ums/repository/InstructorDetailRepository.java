package com.example.ums.repository;

import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
    @Query("""
            SELECT i 
            FROM InstructorDetail i
            """)
    List<InstructorDetailResponseDTO> findAllInstructorDetail();

    @Query("""
            SELECT i
            FROM InstructorDetail i
            WHERE i.id = :id
            """)
    InstructorDetailResponseDTO findInstructorDetailById(@Param("id") Long id);

    @Query("""
            SELECT i
            FROM InstructorDetail i 
            WHERE i.id = :id
            """)
    InstructorDetail getInstructorDetailId(@Param("id") Long id);

    /**
     *Needs a custom JPQL query since Spring Data can’t resolve cross-projection automatically
     **/

//    @Query("""
//            SELECT d
//                FROM InstructorDetail d
//                    JOIN FETCH d.instructor
//                        WHERE d.id = :id
//            """)
//    Optional<InstructorDetailResponseDTO> findInstructorByInstructorDetailId(@Param("id") Long id);
}
