package com.actions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pages.LoginPage;
import com.utilities.HelperClass;


public class LoginPageActions {
	private static Logger log=LogManager.getLogger();
	LoginPage lp=new LoginPage(HelperClass.getDriver(),HelperClass.getWait());
	public void Login(String user,String pass) {
		log.info("Username and password is sended");
		lp.sendUsername(user);
		lp.sendPassword(pass);
		lp.submit();
	}
	public void clickLogin() {
		lp.clickLogin();
	}
	
}
