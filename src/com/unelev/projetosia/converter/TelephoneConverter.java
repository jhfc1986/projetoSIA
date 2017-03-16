package com.unelev.projetosia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("telephoneConverter")
public class TelephoneConverter implements Converter{
	
	  @Override
	  public String getAsString(FacesContext context, UIComponent component, Object value) {
		  String telefone = value.toString();
          if (telefone != null && telefone.length() == 10){
              telefone = "("+telefone.substring(0, 2)+")"+telefone.substring(2, 6)+"-"+telefone.substring(6, 8)+"-"+telefone.substring(8, 10);
              return telefone;
          }
          return "";
	  }

	  @Override
	  public Object getAsObject(FacesContext context, UIComponent component, String value) {
		  String telefone = value;
          if (value!= null && !value.equals("")){
               telefone = value.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "").replaceAll(" ", "");
               Long telefoneret = new Long(telefone);
               return telefoneret;
          }
          return null;
         
	  }

}
