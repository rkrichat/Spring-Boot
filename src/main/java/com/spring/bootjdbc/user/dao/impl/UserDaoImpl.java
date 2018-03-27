package com.spring.bootjdbc.user.dao.impl;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public String getUserDetail(String id) throws SQLException {
        Connection con =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.102:1521:stipnxa","sti_branch_bkk","sti_branch_bkk");
            ps = con.prepareStatement("SELECT name FROM custdata2 WHERE code = ? ");
            ps.setString(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    @Override
    public String createUser(UserInfo bean) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.102:1521:stipnxa", "sti_branch_bkk","sti_branch_bkk");
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO custdata2 (code,name) VALUES (?,?)");
            ps.setString(1, bean.getCode());
            ps.setString(2, bean.getName());
            rs = ps.executeQuery();
            if (rs.next()) {
                con.commit();
                return "Create User Successfully";
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        } finally{
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    @Override
    public String deleteUser(UserInfo bean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.102:1521:stipnxa","sti_branch_bkk","sti_branch_bkk");
            con.setAutoCommit(false);
            ps = con.prepareStatement("DELETE custdata2 WHERE code = ?");
            ps.setString(1, bean.getCode());
            rs = ps.executeQuery();
            if (rs.next()) {
                con.commit();
                return "Delete user Successfully";
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }
}


