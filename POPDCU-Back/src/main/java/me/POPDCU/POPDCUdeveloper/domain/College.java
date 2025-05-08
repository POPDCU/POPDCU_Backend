package me.POPDCU.POPDCUdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "college_name", nullable = false)
    private String collegeName;

    @Column(name = "count_number", nullable = false)
    private long countNumber;

    @Builder
    public College(String collegeName, long countNumber) {
        this.collegeName = collegeName;
        this.countNumber = countNumber;
    }

    public void AddCountNumber(long addNumber){
        this.countNumber+=addNumber;
    }
}
