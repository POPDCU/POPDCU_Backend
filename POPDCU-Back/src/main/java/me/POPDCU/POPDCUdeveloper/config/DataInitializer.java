package me.POPDCU.POPDCUdeveloper.config;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.Admin;
import me.POPDCU.POPDCUdeveloper.repositroy.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final AdminRepository adminRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            Optional<Admin> existingAdmin = adminRepository.findByUsername("admin");
            
            if (existingAdmin.isEmpty()) {
                Admin admin = Admin.builder()
                        .username("admin")
                        .password("admin1234")
                        .build();
                
                adminRepository.save(admin);
                System.out.println("기본 관리자 계정이 생성되었습니다. (아이디: admin, 비밀번호: admin1234)");
            }
        };
    }
}
