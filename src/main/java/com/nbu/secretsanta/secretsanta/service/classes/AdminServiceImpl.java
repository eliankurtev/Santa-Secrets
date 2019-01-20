package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.Admin;
import com.nbu.secretsanta.secretsanta.repository.AdminRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import com.nbu.secretsanta.secretsanta.service.interfaces.TransformationSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TransformationSrvice transformationSrvice;

    @Override
    public Admin saveAdmin(AdminDto adminDto){
        return adminRepository.save(transformationSrvice.dtoToEntity(adminDto));
    }

    @Override
    public Admin getAdmin() {
        return adminRepository.findAll().get(0);
    }
}
