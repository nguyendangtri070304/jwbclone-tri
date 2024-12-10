package com.group11.moviebooking.repository;


import com.group11.moviebooking.model.RevenueDTO;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RevenueImpl  extends BasicImpl implements Revenue {

    public RevenueImpl() {
        super("Revenue");
    }

    public List<RevenueDTO> findWeekRevenue(){
        List<RevenueDTO> revenueList = new ArrayList<>();
        // Lấy ngày hôm nay và ngày cách đây 7 ngày
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(6);

        // Chuyển đổi ngày thành String (ISO format yyyy-MM-dd)
        String startDate = sevenDaysAgo.toString();
        String endDate = today.toString();
        String sql = "SELECT show_date, SUM(ticket_price) AS total_revenue " +
                "FROM tblshowtimes " +
                "WHERE show_date BETWEEN ? AND ? " +
                "GROUP BY show_date ORDER BY show_date ASC;";

        // Tạo PreparedStatement và thực thi truy vấn
        PreparedStatement statement = null;
        try {
            statement = this.con.prepareStatement(sql.toString());
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String showDate = resultSet.getString("show_date");
                double totalRevenue = resultSet.getInt("total_revenue");
                // Thêm doanh thu vào danh sách
                revenueList.add(new RevenueDTO(showDate, totalRevenue));
            }

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                this.con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            this.releaseConnection(); // Trả lại kết nối
        }
        return revenueList;
    }
}
