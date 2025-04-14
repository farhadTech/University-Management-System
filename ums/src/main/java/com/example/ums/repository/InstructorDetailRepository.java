package com.example.ums.repository;

import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
    List<InstructorDetailResponseDTO> findAllProjectedBy();

    @Query("SELECT p from InstructorDetail p where p.id=:id")
    InstructorDetailResponseDTO findProjectedById(Long id);

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
