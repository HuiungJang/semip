package com.yoriessence.manager.model.service;

import com.yoriessence.manager.model.dao.ManagerDao;
import com.yoriessence.manager.model.vo.ManagerPage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import static com.yoriessence.common.JDBCTemplate.getConnection;
import static com.yoriessence.common.JDBCTemplate.close;

public class ManagerService {
    private Properties pp = new Properties();
    private ManagerDao dao = new ManagerDao();

    public ManagerService() {
        try{
            String path = ManagerService.class.getResource("/driver/driver.properties").getPath();
            pp.load(new FileReader(path));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int countOrder(){
        Connection conn = getConnection();
        int result = dao.countOrder(conn);
        close(conn);
        return result;
    }

    public List<ManagerPage> getOrderList(int cPage,int numPerPage){
        Connection conn = getConnection();
        List<ManagerPage> result = dao.getOrderList(conn,cPage,numPerPage);
        close(conn);
        return result;
    }
}
