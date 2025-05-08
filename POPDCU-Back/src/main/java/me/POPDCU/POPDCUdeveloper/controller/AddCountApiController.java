package me.POPDCU.POPDCUdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.AddCountRequest;
import me.POPDCU.POPDCUdeveloper.dto.CollegeResponse;
import me.POPDCU.POPDCUdeveloper.service.AddCountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class AddCountApiController {
    private final AddCountService addCountService;


    @PatchMapping("/api/count/id/{id}")
    public ResponseEntity<CollegeResponse> addCountIdJson(@PathVariable long id, @RequestBody AddCountRequest addCountRequest){
        College addCountCollege = addCountService.addCountId(id, addCountRequest.getCountNumber());
        return ResponseEntity.ok()
                .body(new CollegeResponse(addCountCollege));
    }
    @PatchMapping("/api/count/name/{collegeName}")
    public ResponseEntity<CollegeResponse> addCountNameJson(@PathVariable String collegeName, @RequestBody AddCountRequest addCountRequest){
        College addCountCollege = addCountService.addCountName(collegeName, addCountRequest.getCountNumber());
        return ResponseEntity.ok()
                .body(new CollegeResponse(addCountCollege));
    }

    @PatchMapping("/api/count/id/{id}/{number}")
    public ResponseEntity<CollegeResponse> addCountId(@PathVariable("id") long id, @PathVariable("number") long addCount){
        College addCountCollege = addCountService.addCountId(id,addCount);
        return ResponseEntity.ok()
                .body(new CollegeResponse(addCountCollege));
    }
    @PatchMapping("/api/count/name/{collegeName}/{number}")
    public ResponseEntity<CollegeResponse> addCountName(@PathVariable("collegeName") String collegeName, @PathVariable("number") long addCount){
        College addCountCollege = addCountService.addCountName(collegeName,addCount);
        return ResponseEntity.ok()
                .body(new CollegeResponse(addCountCollege));
    }
}
