package me.POPDCU.POPDCUdeveloper.repositroy;

import me.POPDCU.POPDCUdeveloper.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddCountRepository extends JpaRepository<College, Long> {
    College findByCollegeName(String name);
}
