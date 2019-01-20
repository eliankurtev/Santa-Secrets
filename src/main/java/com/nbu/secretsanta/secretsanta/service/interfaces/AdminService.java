package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.Admin;

public interface AdminService {
    Admin saveAdmin(AdminDto adminDto);
    Admin getAdmin();
}
