/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;
import pos.mvc.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pos.mvc.db.DBConnection;
/**
 *
 * @author ASUS
 */
public class CustomerController {
    public String saveCustomer(CustomerModel customer) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
                
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,customer.getCustId());
        preparedStatement.setString(2,customer.getTitle());
        preparedStatement.setString(3,customer.getName());
        preparedStatement.setString(4,customer.getDob());
        preparedStatement.setDouble(5,customer.getSalary());
        preparedStatement.setString(6,customer.getAddress());
        preparedStatement.setString(7,customer.getCity());
        preparedStatement.setString(8,customer.getProvince());
        preparedStatement.setString(9,customer.getZip());
        
        if(preparedStatement.executeUpdate()>0){
            return "Success";
        }else{
            return "Fail";
        }
    }
}
