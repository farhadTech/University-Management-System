package com.example.ums.service.serviceImpl;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.model.InstructorDetail;
import com.example.ums.repository.InstructorDetailRepository;
import com.example.ums.service.InstructorDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {
    private final InstructorDetailRepository instructorDetailRepository;

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
    public void addInstructorDetail(InstructorDetailRequestDTO instructorDetailRequestDTO){
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setBio(instructorDetailRequestDTO.bio());
        instructorDetail.setYoutubeChannel(instructorDetailRequestDTO.youtubeChannel());
        instructorDetail.setHobby(instructorDetailRequestDTO.hobby());
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
}






















