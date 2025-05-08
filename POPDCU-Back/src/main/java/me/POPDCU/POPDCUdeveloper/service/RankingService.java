package me.POPDCU.POPDCUdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.CollegeRequest;
import me.POPDCU.POPDCUdeveloper.repositroy.RankingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RankingService {
    private final RankingRepository rankingRepository;

    public List<College> findAllSort(){
        return rankingRepository.findAll(Sort.by(Sort.Direction.DESC,"countNumber"));
    }

    public College findById(long id){
        return rankingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
    public College findByName(String name){
        return rankingRepository.findByCollegeName(name);
    }
    
    @Transactional
    public College createCollege(CollegeRequest request) {
        College college = College.builder()
                .collegeName(request.getCollegeName())
                .countNumber(request.getCountNumber())
                .build();
        return rankingRepository.save(college);
    }
    
    @Transactional
    public void deleteCollege(Long id) {
        rankingRepository.deleteById(id);
    }
    
    @Transactional
    public College updateCollege(Long id, CollegeRequest request) {
        College college = findById(id);
        college = College.builder()
                .collegeName(request.getCollegeName())
                .countNumber(request.getCountNumber())
                .build();
        return rankingRepository.save(college);
    }
}
