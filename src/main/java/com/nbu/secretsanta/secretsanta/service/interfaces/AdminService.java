package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.Admin;

public interface AdminService {
     String showRegEndDate();
     String showGiftGivingDate();
     String showAdminGiftPrice();
     void save (AdminDto admin);
     void setAdminGiftPrice(String price);
     void setRegEndDate(String endDate) throws Exception;
     void setGiftGivingDate(String giftDate) throws Exception;
     Admin getAdmin();
}
