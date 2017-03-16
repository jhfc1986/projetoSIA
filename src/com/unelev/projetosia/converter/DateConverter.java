package com.unelev.projetosia.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateConverter implements Converter{
	
	  @Override
	  public String getAsString(FacesContext context, UIComponent component, Object value) {
	      
		  SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");
          
		  String strDate = sdfDestination.format(value);
		  
		  return strDate.toUpperCase(); 
	  }

	  @Override
	  public Object getAsObject(FacesContext context, UIComponent component, String value) {
	      
		  if(value != null && !value.equals("")){
			 
			SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy");
            
			Date date;
			
			try {
				date = sdfSource.parse(value);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 
	        
		  }
		  return null;
	  }

}
