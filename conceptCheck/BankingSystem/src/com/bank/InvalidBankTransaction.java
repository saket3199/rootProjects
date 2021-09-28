package com.bank;

public class InvalidBankTransaction extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    String errorMessage;
    public InvalidBankTransaction(String message)
    {
       errorMessage = message;
    }  
     public String getMessage()
     {
         return errorMessage;
     }

}
