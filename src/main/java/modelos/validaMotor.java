/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author berni
 */
public class validaMotor implements Validator{
    
    @Override
    public boolean supports (Class<?> type){
        
        return Motor.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate(Object o, Errors errors){
        
        Motor m = (Motor)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "required.modelo",
                "El campo Modelo es Obligatorio");
        
        if (m.getModelo().length()==5){
            errors.rejectValue("modelo","Comprueba Modelo","debe tener 5 caracteres");
        }
        
        if(m.getPotencia() > 0){
            
            errors.rejectValue("Potencia", "Comprueba la Potencia", "debe ser mayor que 0");
        }
        
        if(m.getPeso() > 0){
            
            errors.rejectValue("Peso", "Comprueba el Peso", "debe ser mayor que 0");
        }
        
        if (m.getCantidad() >=0 )
            
            errors.rejectValue("Stock", "Comprueba el Stock", "no puede haber stock negativo");

    }
}
