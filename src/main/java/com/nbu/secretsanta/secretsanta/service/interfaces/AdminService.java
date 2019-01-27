package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.Admin;

import java.util.Date;

public interface AdminService {
     Date showRegEndDate();
     Date showGiftGivingDate();
     String showAdminGiftPrice();
     void save (AdminDto admin);
     void setAdminGiftPrice(String price);
     void setRegEndDate(Date endDate);
     void setGiftGivingDate(Date giftDate);
     Admin getAdmin();
}
