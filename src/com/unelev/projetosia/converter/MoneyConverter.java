package com.unelev.projetosia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("moneyConverter")
public class MoneyConverter implements Converter{
	
	  @Override
	  public String getAsString(FacesContext context, UIComponent component, Object value) {
	     return ""; 
	  }

	  @Override
	  public Object getAsObject(FacesContext context, UIComponent component, String value) {
	     return null;
	  }

}
