package com.example.ums.service.serviceImpl;

import com.example.ums.common.exception.IDNotFoundException;
import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.model.InstructorDetail;
import com.example.ums.repository.InstructorDetailRepository;
import com.example.ums.repository.InstructorRepository;
import com.example.ums.service.InstructorDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {
    private InstructorDetailRepository instructorDetailRepository;
    private InstructorRepository instructorRepository;

    public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository,
                                       InstructorRepository instructorRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<InstructorDetailResponseDTO> getAllInstructorDetail() {
        return instructorDetailRepository.findAllInstructorDetail();
    }

    @Override
    public InstructorDetailResponseDTO getInstructorDetailById(Long id) {
        InstructorDetailResponseDTO instructorDetailResponseDTO = instructorDetailRepository.findInstructorDetailById(id);

        if(instructorDetailResponseDTO == null) {
            throw new IDNotFoundException("Instructor Detail Not Found for ID: " + id);
        }
        return instructorDetailResponseDTO;
    }

    @Override
    public InstructorDetail createInstructorDetail(InstructorDetailRequestDTO instructorDetailRequestDTO) {
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setBio(instructorDetailRequestDTO.bio());
        instructorDetail.setYoutubeChannel(instructorDetailRequestDTO.youtubeChannel());
        instructorDetail.setHobby(instructorDetailRequestDTO.hobby());

        return instructorDetailRepository.save(instructorDetail);
    }

    @Override
    public InstructorDetail updateInstructorDetail(Long id, InstructorDetailRequestDTO instructorDetailRequestDTO){
        InstructorDetail instructorDetail = instructorDetailRepository.getInstructorDetailId(id);
        if(instructorDetail == null) {
            throw new IDNotFoundException("Instructor Detail Not Found for ID: " + id);
        }

        instructorDetail.setBio(instructorDetailRequestDTO.bio());
        instructorDetail.setYoutubeChannel(instructorDetailRequestDTO.youtubeChannel());
        instructorDetail.setHobby(instructorDetailRequestDTO.hobby());

        return instructorDetailRepository.save(instructorDetail);
    }

    public String deleteInstructorDetail(Long id) {
        instructorDetailRepository.deleteById(id);
        return "Instructor Detail Deleted for ID: " + id;
    }

//    @Override
//    public InstructorDetailResponseDTO getInstructorByInstructorDetailId(Long id) {
//        return instructorDetailRepository.findInstructorByInstructorDetailId(id)
//                .orElseThrow(() -> new RuntimeException("instructor not found with id " + id));
//    }
}






















