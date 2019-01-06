package com.nbu.secretsanta.secretsanta.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private Long adminId;
    private String registrationEndDate;
    private String giftsDate;
    private String adminPrice;
}
