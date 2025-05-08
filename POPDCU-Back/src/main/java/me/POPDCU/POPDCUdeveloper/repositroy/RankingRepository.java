package me.POPDCU.POPDCUdeveloper.repositroy;

import me.POPDCU.POPDCUdeveloper.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<College, Long> {
    College findByCollegeName(String name);

}
