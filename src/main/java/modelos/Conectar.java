/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Conectar {
    
    public DriverManagerDataSource conectar(){
        
        //CONEXION CON LA BBDD, DIRECCION,USER,PASS
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/motorland");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
    
}
