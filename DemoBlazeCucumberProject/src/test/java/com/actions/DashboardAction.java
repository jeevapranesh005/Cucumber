package com.actions;

import com.pages.DashboardPage;
import com.utilities.HelperClass;

public class DashboardAction {
	DashboardPage dp=new DashboardPage(HelperClass.getDriver(), HelperClass.getWait());
	public String getName() {
		return dp.getUsername();
	}
}
