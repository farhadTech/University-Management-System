package com.example.ums.service.serviceImpl;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.model.Instructor;
import com.example.ums.model.InstructorDetail;
import com.example.ums.repository.InstructorDetailRepository;
import com.example.ums.service.InstructorDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {
    @Autowired
    private InstructorDetailRepository instructorDetailRepository;

    @Override
    public List<InstructorDetailResponseDTO> getAllInstructorDetail() {
        return instructorDetailRepository.findAllProjectedBy();
    }

    @Override
    public InstructorDetailResponseDTO getInstructorDetailById(Long id) {
        InstructorDetailResponseDTO instructorDetailResponseDTO = instructorDetailRepository.findProjectedById(id);

        if (Objects.isNull(instructorDetailResponseDTO)) {
            throw new RuntimeException("instructorDetail not found with id " + id);
        }
        return instructorDetailResponseDTO;
    }

    @Override
    public void addInstructorDetail(InstructorDetailRequestDTO instructorDetailRequestDTO, InstructorRequestDTO instructorRequestDTO) {
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setBio(instructorDetailRequestDTO.bio());
        instructorDetail.setYoutubeChannel(instructorDetailRequestDTO.youtubeChannel());
        instructorDetail.setHobby(instructorDetailRequestDTO.hobby());

        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequestDTO.firstName());
        instructor.setLastName(instructorRequestDTO.lastName());
        instructor.setEmail(instructorRequestDTO.email());
        instructor.setPassword(instructorRequestDTO.password());
        instructor.setPhone(instructorRequestDTO.phone());

        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetail(instructorDetail);

        instructorDetailRepository.save(instructorDetail);
    }

    @Override
    public void updateInstructorDetail(Long id, InstructorDetailRequestDTO instructorDetailRequestDTO){
        InstructorDetail instructorDetail = instructorDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor detail not found with id: " + id));

        instructorDetail.setBio(instructorDetailRequestDTO.bio());
        instructorDetail.setYoutubeChannel(instructorDetailRequestDTO.youtubeChannel());
        instructorDetail.setHobby(instructorDetailRequestDTO.hobby());

        instructorDetailRepository.save(instructorDetail);
    }

    public void deleteInstructorDetail(Long id) {
        instructorDetailRepository.deleteById(id);
    }

//    @Override
//    public InstructorDetailResponseDTO getInstructorByInstructorDetailId(Long id) {
//        return instructorDetailRepository.findInstructorByInstructorDetailId(id)
//                .orElseThrow(() -> new RuntimeException("instructor not found with id " + id));
//    }
}






















