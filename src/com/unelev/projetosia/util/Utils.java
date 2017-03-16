package com.unelev.projetosia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Utils {
	
	/**
	 * 
	 * @param CNPJ
	 * @return
	 */
    public static boolean validaCNPJ(String CNPJ){
		     
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
				|| CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333")
				|| CNPJ.equals("44444444444444")
				|| CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666")
				|| CNPJ.equals("77777777777777")
				|| CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14))

			return false;

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {

				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}
			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}
			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
    } 

	/**
	 * 
	 * formata data para o padrão dd/MM/yyyy
	 * 
	 * @param date
	 * @return
	 */
	public static Date formataData(Date date){
		
		 SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");
         String strDate = sdfDestination.format(date);
         
         try {
			  date = sdfDestination.parse(strDate);
			  
		  } catch (ParseException e) {
				e.printStackTrace();
		  }
          
          return date;
    }
	
	public static Date formataDataHoraAtendimento(Date data,String hora){
		 
         SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");
          
		 String strDate = sdfDestination.format(data);
		 
		 strDate = strDate+" "+hora+":00";
		 
		 SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
           
		 
		 try { 
			 
			 data = sdfSource.parse(strDate);
		    
		 } catch (ParseException e) {
			e.printStackTrace();
		 }
		 return data;
		 
		  
		
		
	}

}
