package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.Admin;
import com.nbu.secretsanta.secretsanta.repository.AdminRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import com.nbu.secretsanta.secretsanta.service.interfaces.TransformationSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminService {
    private  final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Autowired
    private TransformationSrvice transformationSrvice;

    @Autowired
    private GifteeService gifteeService;

    @Override
    public String showRegEndDate() {
        Admin admin = getAdmin();
        LocalDateTime date = admin.getRegistrationEndDate();
        return date.toString();
    }

    @Override
    public String showGiftGivingDate() {
        Admin admin = getAdmin();
        LocalDateTime date = admin.getGiftsDate();
        return date.toString();
    }

    @Override
    public String showAdminGiftPrice() {
        Admin admin = getAdmin();
        return admin.getAdminPrice();
    }

    @Override
    public void save(AdminDto admin) {
        adminRepository.save(transformationSrvice.dtoToEntity(admin));
    }

    @Override
    public void setAdminGiftPrice(String price) {
        Admin admin = getAdmin();
        admin.setAdminPrice(price);
        adminRepository.save(admin);
    }

    @Override
    public void setRegEndDate(String endDate){
        Admin admin = getAdmin();
        admin.setRegistrationEndDate(gifteeService.parseDate(endDate));
        adminRepository.save(admin);
    }

    @Override
    public void setGiftGivingDate(String giftDate) throws Exception {
        Admin admin = getAdmin();
        admin.setGiftsDate(gifteeService.parseDate(giftDate));
        adminRepository.save(admin);
    }

    @Override
    public Admin getAdmin() {
        return adminRepository.findAll().get(0);
    }
}
