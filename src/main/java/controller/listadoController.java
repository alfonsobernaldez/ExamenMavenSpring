/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelos.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class listadoController {
    
    private JdbcTemplate jdbc;
    
    public listadoController(){
        Conectar con = new Conectar();
        this.jdbc = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("listado.htm")
    public ModelAndView listado(HttpServletRequest request){
        
        ModelAndView mav=new ModelAndView();
        String sql = "select * from motores";
        List motores=this.jdbc.queryForList(sql);
        mav.addObject("motores",motores);
        mav.setViewName("listado");
        return mav;
    }
    
    
}
