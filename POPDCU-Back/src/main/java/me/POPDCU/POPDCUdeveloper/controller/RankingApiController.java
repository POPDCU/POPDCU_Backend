package me.POPDCU.POPDCUdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.CollegeResponse;
import me.POPDCU.POPDCUdeveloper.service.RankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class RankingApiController {
    private final RankingService rankingService;

    @GetMapping("/api/ranking")
    public ResponseEntity<List<CollegeResponse>> findAllCollege(){
        List<CollegeResponse> colleges = rankingService.findAllSort()
                .stream()
                .map(CollegeResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(colleges);
    }

    @GetMapping("/api/ranking/id/{id}")
    public ResponseEntity<CollegeResponse> findCollege(@PathVariable long id){
        College college = rankingService.findById(id);

        return ResponseEntity.ok().body(new CollegeResponse(college));
    }

    @GetMapping("/api/ranking/name/{name}")
    public ResponseEntity<CollegeResponse> findNameCollege(@PathVariable String name){
        College college = rankingService.findByName(name);
        return ResponseEntity.ok().body(new CollegeResponse(college));
    }

}
