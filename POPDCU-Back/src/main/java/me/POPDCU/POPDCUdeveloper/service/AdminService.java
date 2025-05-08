package me.POPDCU.POPDCUdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.Admin;
import me.POPDCU.POPDCUdeveloper.dto.AdminRequest;
import me.POPDCU.POPDCUdeveloper.dto.AdminResponse;
import me.POPDCU.POPDCUdeveloper.repositroy.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    @Transactional
    public AdminResponse login(AdminRequest request) {
        Admin admin = adminRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username"));

        if (!admin.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        // 간단한 토큰 생성 (실제로는 JWT 등 더 강력한 방식 사용 권장)
        String token = UUID.randomUUID().toString();
        
        return new AdminResponse(admin, token);
    }
}
