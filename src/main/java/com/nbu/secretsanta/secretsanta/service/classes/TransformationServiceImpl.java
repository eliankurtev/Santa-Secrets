package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.Admin;
import com.nbu.secretsanta.secretsanta.service.interfaces.TransformationSrvice;
import org.springframework.stereotype.Service;

@Service
public class TransformationServiceImpl implements TransformationSrvice {
    @Override
    public Admin dtoToEntity(AdminDto adminDto) {
        return null;
    }

    @Override
    public AdminDto entityToDto(Admin admin){
        return null;
    }
}
