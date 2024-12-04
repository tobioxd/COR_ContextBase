package com.example.demo.dao;

import com.example.demo.bean.Cust;
import com.example.demo.bean.base.Request;
import com.example.demo.datasource.DataSourceConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustDao {

    public static Cust getAccountById(Long id){

        Cust acct = null;
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement proc = null;

        String sql = "select * from MINH.BANK_ACCOUNT  where id = ?";

        try{
            connection = DataSourceConfiguration.getConnection();
            proc = connection.prepareStatement(sql);
            proc.setLong(1, id);
            rs = proc.executeQuery();
            if(rs.next()){
                acct = new Cust();
                acct.setId(rs.getLong("id"));
                acct.setBankcode(rs.getString("bank_cd"));
                acct.setCode(rs.getString("code"));
                acct.setName(rs.getString("name"));
                acct.setRole(rs.getString("role"));
                acct.setUsername(rs.getString("username"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceConfiguration.realease(connection, proc, rs);
        }

        return acct;
    }

    public static boolean existAccount(String code){

        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement proc = null;

        String sql = "select * from MINH.BANK_ACCOUNT where code = ?";

        try{
            connection = DataSourceConfiguration.getConnection();
            proc = connection.prepareStatement(sql);
            proc.setString(1, code);
            rs = proc.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceConfiguration.realease(connection, proc, rs);
        }
        return false;
    }

    public static boolean insertAccount(String bankcode, String code, String name, String role, String username){

        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement proc = null;

        String sql = "insert into MINH.BANK_ACCOUNT (bank_cd, code, name, role, username) values(?, ?, ?, ?, ?)";

        try{
            connection = DataSourceConfiguration.getConnection();
            proc = connection.prepareStatement(sql);
            proc.setString(1, bankcode);
            proc.setString(2, code);
            proc.setString(3, name);
            proc.setString(4, role);
            proc.setString(5, username);
            return proc.executeUpdate() > 0 ;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceConfiguration.realease(connection, proc, rs);
        }

        return false;
    }

    public static boolean updateAccount(Long id, String name ){

        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement proc = null;

        String sql = "update MINH.BANK_ACCOUNT  set name = ? where id = ?";

        try{
            connection = DataSourceConfiguration.getConnection();
            proc = connection.prepareStatement(sql);
            proc.setString(1, name);
            proc.setLong(2, id);
            return proc.executeUpdate() == 1 ;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceConfiguration.realease(connection, proc, rs);
        }
        return false;
    }

    public static boolean deleteAccount(Long id){

        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement proc = null;

        String sql = "delete from MINH.BANK_ACCOUNT where id = ?";

        try{
            connection = DataSourceConfiguration.getConnection();
            proc = connection.prepareStatement(sql);
            proc.setLong(1, id);
            return proc.executeUpdate() == 1 ;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceConfiguration.realease(connection, proc, rs);
        }
        return false;

    }

    public static Cust getAccountByCode(String code) {

        Cust acct = null;
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement proc = null;

        String sql = "select * from MINH.BANK_ACCOUNT  where code = ?";

        try{
            connection = DataSourceConfiguration.getConnection();
            proc = connection.prepareStatement(sql);
            proc.setString(1, code);
            rs = proc.executeQuery();
            if(rs.next()){
                acct = new Cust();
                acct.setId(rs.getLong("id"));
                acct.setBankcode(rs.getString("bank_cd"));
                acct.setCode(rs.getString("code"));
                acct.setName(rs.getString("name"));
                acct.setRole(rs.getString("role"));
                acct.setUsername(rs.getString("username"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceConfiguration.realease(connection, proc, rs);
        }

        return acct;

    }
}
