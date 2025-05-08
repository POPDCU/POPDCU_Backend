package me.POPDCU.POPDCUdeveloper.dto;

import lombok.Getter;
import me.POPDCU.POPDCUdeveloper.domain.Admin;

@Getter
public class AdminResponse {
    private final Long id;
    private final String username;
    private final String token;

    public AdminResponse(Admin admin, String token) {
        this.id = admin.getId();
        this.username = admin.getUsername();
        this.token = token;
    }
}
