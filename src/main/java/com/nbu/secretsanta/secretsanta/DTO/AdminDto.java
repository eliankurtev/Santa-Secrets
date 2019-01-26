package com.nbu.secretsanta.secretsanta.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private Long adminId;
    @JsonSerialize(using = DateSerializer.class)
    @JsonFormat(pattern = "MM/DD/YYYY HH:MM")
    private String registrationEndDate;
    @JsonSerialize(using = DateSerializer.class)
    @JsonFormat(pattern = "MM/DD/YYYY HH:MM")
    private String giftsDate;
    private String adminPrice;
}
