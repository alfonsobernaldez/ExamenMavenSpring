/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelos.Conectar;
import modelos.Motor;
import modelos.validaMotor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author berni
 */
@Controller
@RequestMapping("alta.htm")
public class altaController {
    
    private JdbcTemplate jdbcTemplate;
    private validaMotor validar;
    private Object Requestmethod;
    
    public altaController(){
    
    Conectar con = new Conectar();
    this.jdbcTemplate = new JdbcTemplate(con.conectar());
    this.validar = new validaMotor();
    }
    
    @RequestMapping(method = RequestMethod.GET) //Dar de alta nuevo motor a la bbdd
    public ModelAndView alta(){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("alta");
        mav.addObject("motor",new Motor());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView alta(@ModelAttribute("motor") Motor m, BindingResult result){
        
        this.validar.validate(m, result);
        if (result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.setView("alta"); //entramos al jsp de alta
            mav.addObject("motor", new Motor());
            return mav;
        }
        else{
            this.jdbcTemplate.update(
                    "insert into motor (modelo,fabricante,potencia,peso,cantidad) values (?,?,?,?,?)",
                    m.getModelo(),m.getFabricante(),m.getPotencia(),m.getPeso(),m.getCantidad());
            return new ModelAndView();
                    
        }
        
    }
}
