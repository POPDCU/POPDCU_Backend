package me.POPDCU.POPDCUdeveloper.dto;

import lombok.Getter;
import me.POPDCU.POPDCUdeveloper.domain.College;

@Getter
public class CollegeResponse {
    private String collegeName;
    private long countNumber;
    public CollegeResponse(College college) {
        this.collegeName = college.getCollegeName();
        this.countNumber = college.getCountNumber();
    }
}
