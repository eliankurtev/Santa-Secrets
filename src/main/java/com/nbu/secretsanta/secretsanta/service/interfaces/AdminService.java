package com.nbu.secretsanta.secretsanta.service.interfaces;

import com.nbu.secretsanta.secretsanta.model.Admin;

public interface AdminService {
     String showRegEndDate();
     String showGiftGivingDate();
     String showAdminGiftPrice();
     void save (Admin admin);
     void setAdminGiftPrice(String price);
     void setRegEndDate(String endDate);
     void setGiftGivingDate(String giftDate);

}
