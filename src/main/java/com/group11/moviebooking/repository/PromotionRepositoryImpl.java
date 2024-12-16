package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.PromotionEntity;
import com.group11.moviebooking.util.BasicImpl;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PromotionRepositoryImpl extends BasicImpl implements PromotionRepository {
    public PromotionRepositoryImpl() {
        super("tblpromotion");
    }

    @Override
    public List<PromotionEntity> getAllPromotions() {
        List<PromotionEntity> promotions = new ArrayList<PromotionEntity>();
        String sql = "select * from tblpromotions LIMIT 20";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PromotionEntity promotion = new PromotionEntity();
                promotion.setPromotion_id(rs.getInt("promotion_id"));
                promotion.setPromotion_name(rs.getString("promotion_name"));
                promotion.setPromotion_description(rs.getString("promotion_description"));

                promotions.add(promotion);
            }
            return promotions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
