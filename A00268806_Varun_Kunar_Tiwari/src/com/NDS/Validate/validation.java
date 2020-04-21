package com.NDS.Validate;
import java.util.regex.Pattern;

public class validation {
	
	

		public boolean checkInputValid(String str,String str2) {
		 	
			if (str.matches("[0-9]+")&&str2.matches("[0-9]+")) {
				return true;
			}
			return false;
		}
		public boolean checkOnlyNevSign(String str,String str2) {
			
			if (str.equals("-")||str.equals(".")||str2.equals("-")||str2.equals(".")) {
				return false;
			}
			return true;
		}
		public boolean checkOnlyNevSignUp(String id,String str,String str2) {
			
			if (id.equals("-")||id.equals(".")||str.equals("-")||str.equals(".")||str2.equals("-")||str2.equals(".")) {
				return false;
			}
			return true;
		}
public boolean checkInputValidUp(String id,String str,String str2) {
		 	
			if (id.matches("[0-9]+")&&str.matches("[0-9]+")&&str2.matches("[0-9]+")) {
				return true;
			}
			return false;
		}
		public boolean checkEmptyInput(String Name,String Amount,String Frequency,String Price)
		{
			if (Name.equals("")|| Amount.equals("")||Frequency.equals("Select Frequency")||Price.equals(""))
			{
				return false;
			}
			return true;
		}
		
		public boolean checkUpdateEmptyInput(String id,String Name,String Amount,String Frequency,String Price)
		{
			if (id.equals("")||Name.equals("")|| Amount.equals("")||Frequency.equals("Select Frequency")||Price.equals(""))
			{
				return false;
			}
			return true;
		}
		
		public boolean deleteInputEmpty(String id)
		{
			if (id.equals(""))
			{
				return false;
			}
			return true;
		}
		public boolean deleteInvalideEmpty(String id)
		{
			if (id.matches("[0-9]+")) {
				return true;
			}
			return false;
		}

}
