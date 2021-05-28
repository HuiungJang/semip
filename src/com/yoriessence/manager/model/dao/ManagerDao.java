package com.yoriessence.manager.model.dao;

import com.yoriessence.manager.model.vo.ManagerPage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.yoriessence.common.JDBCTemplate.close;

public class ManagerDao {
    private Properties pp = new Properties();

    public ManagerDao() {
        try{
            String path =  ManagerDao.class.getResource("/manager/manager.properties").getPath();
            pp.load(new FileReader(path));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int countOrder(Connection conn) {
        PreparedStatement psmt = null;
        ResultSet rs =null;
        int result= 0;
        try{
            psmt = conn.prepareStatement(pp.getProperty("countOrder"));

            rs= psmt.executeQuery();

            if(rs.next()){
              result = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(psmt);
        }
        return result;
    }

    public List<ManagerPage> getOrderList(Connection conn,int cPage, int numPerPage){
        PreparedStatement psmt = null;
        ResultSet rs =null;
        List<ManagerPage> result = new ArrayList<>();
        try{
            psmt = conn.prepareStatement(pp.getProperty("getOrderList"));
            psmt.setInt(1,cPage);
            psmt.setInt(2,numPerPage);

            rs= psmt.executeQuery();

            while (rs.next()){
                ManagerPage m = new ManagerPage();
                m.setRowNum(rs.getInt("rnum"));
                m.setOrderNumber(rs.getInt("order_number"));
                m.setMemberId(rs.getString("memberid"));
                m.setOrderAmount(rs.getInt("order_amount"));
                m.setPayment(rs.getString("payment"));
                m.setPaymentStatus(rs.getString("payment_status"));
                m.setShippingStatus(rs.getString("shipping_status"));
                m.setOrderDate(rs.getDate("order_date"));
                m.setPaymentDate(rs.getDate("payment_date"));
                m.setMemberName(rs.getString("member_name"));
                m.setAmountPrice(rs.getInt("amountprice"));
                m.setWaybill(rs.getString("waybill"));

                result.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(psmt);
        }

        return result;
    }

}
