package me.POPDCU.POPDCUdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.AdminRequest;
import me.POPDCU.POPDCUdeveloper.dto.AdminResponse;
import me.POPDCU.POPDCUdeveloper.dto.CollegeRequest;
import me.POPDCU.POPDCUdeveloper.dto.CollegeResponse;
import me.POPDCU.POPDCUdeveloper.service.AdminService;
import me.POPDCU.POPDCUdeveloper.service.RankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class AdminApiController {
    private final AdminService adminService;
    private final RankingService rankingService;

    @PostMapping("/api/admin/login")
    public ResponseEntity<AdminResponse> login(@RequestBody AdminRequest request) {
        AdminResponse response = adminService.login(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/admin/colleges")
    public ResponseEntity<CollegeResponse> createCollege(@RequestBody CollegeRequest request) {
        College college = rankingService.createCollege(request);
        return ResponseEntity.ok().body(new CollegeResponse(college));
    }

    @PutMapping("/api/admin/colleges/{id}")
    public ResponseEntity<CollegeResponse> updateCollege(@PathVariable Long id, 
                                                       @RequestBody CollegeRequest request) {
        College college = rankingService.updateCollege(id, request);
        return ResponseEntity.ok().body(new CollegeResponse(college));
    }

    @DeleteMapping("/api/admin/colleges/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        rankingService.deleteCollege(id);
        return ResponseEntity.ok().build();
    }
}
