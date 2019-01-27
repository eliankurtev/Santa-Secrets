package com.nbu.secretsanta.secretsanta.service.classes;

import com.nbu.secretsanta.secretsanta.model.Admin;
import com.nbu.secretsanta.secretsanta.repository.AdminRepository;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){this.adminRepository = adminRepository;}

    @Override
    public String showRegEndDate() {
        Admin admin = adminRepository.findAll().get(0);
        String date = admin.getRegistrationEndDate();
        return date;
    }

    @Override
    public String showGiftGivingDate() {
        Admin admin = adminRepository.findAll().get(0);
        String date = admin.getGiftsDate();
        return date;
    }

    @Override
    public String showAdminGiftPrice() {
        Admin admin = adminRepository.findAll().get(0);
        String price = admin.getAdminPrice();
        return price;
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void setAdminGiftPrice(String price) {
        Admin admin = adminRepository.findAll().get(0);
        admin.setAdminPrice(price);
        adminRepository.save(admin);
    }

    @Override
    public void setRegEndDate(String endDate) {
        Admin admin = adminRepository.findAll().get(0);
        admin.setRegistrationEndDate(endDate);
        adminRepository.save(admin);
    }

    @Override
    public void setGiftGivingDate(String giftDate) {
        Admin admin = adminRepository.findAll().get(0);
        admin.setGiftsDate(giftDate);
        adminRepository.save(admin);
    }

}
