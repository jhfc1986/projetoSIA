package com.unelev.projetosia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("numberConverter")
public class NumberConverter implements Converter{
	
	  @Override
	  public String getAsString(FacesContext context, UIComponent component, Object value) {
		  if(value != null && !value.toString().equals("0") ){
             String strNumber = value.toString();
             return strNumber;
		  }
		  return ""; 
	  }

	  @Override
	  public Object getAsObject(FacesContext context, UIComponent component, String value) {
		  if(value != null && !value.equals("")){
				 
			 Integer number = new Integer(value);	
			 return number;
		        
		   }
		   return null;
	  }

}
