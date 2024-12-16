package com.group11.moviebooking.service;


import com.group11.moviebooking.repository.PromotionRepositoryImpl;
import com.group11.moviebooking.entity.PromotionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    private PromotionRepositoryImpl promotionRepositoryImpl;

    public PromotionService(PromotionRepositoryImpl promotionRepositoryImpl) {
        this.promotionRepositoryImpl = promotionRepositoryImpl;
    }

    public List<PromotionEntity> getAllPromotions(){
        return promotionRepositoryImpl.getAllPromotions();
    }
}
