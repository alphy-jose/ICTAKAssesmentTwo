package com.employee.Scripts;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.employee.base.Base;
import com.employee.pages.AddEmpPage;
import com.employee.pages.EmployeeListPage;
import com.employee.pages.HomePage;
import com.employee.pages.LoginPage;
import com.employee.Utilities.ExcelUtility;
import com.employee.constants.AutomationConstants;

public class TestClass extends Base{
	
	LoginPage objLogin;
	HomePage  objHome;
	AddEmpPage objAdd;
	EmployeeListPage objList;
	
	@Test(priority=0)
	  public void ValidLoginVerification() throws Exception {
	      
			objLogin=new LoginPage(getDriver());
		
	      String actUname=ExcelUtility.getCellData(0, 0).getStringCellValue();
	      objLogin.setUsername(actUname);
	      Assert.assertEquals(AutomationConstants.expUsername, actUname);
	      
	      String actPasswd=NumberToTextConverter.toText(ExcelUtility.getCellData(0, 1).getNumericCellValue());
	      objLogin.setPassword(actPasswd);
	      Assert.assertEquals(AutomationConstants.expLPassword, actPasswd);
	      
	      objLogin.clickLogin();
	      String actTitle=getDriver().getTitle();
	      Assert.assertEquals(AutomationConstants.expTitle, actTitle);
	      System.out.println(actTitle);
	      
	  }
	
	
	@Test(priority=1)
	public void ValidHomeVerification() throws Exception{
		
		objHome=new HomePage(getDriver());
		
		objHome.openAddEmployee();
		
	}
	
	@Test(priority=2)
	public void ValidAddEmpVerification() throws Exception{
		
		
		objAdd=new AddEmpPage(getDriver());
		
		String actName=ExcelUtility.getCellData(3, 0).getStringCellValue();
		objAdd.setName(actName);
	    Assert.assertEquals(AutomationConstants.expName, actName);
	    
	    String actId=NumberToTextConverter.toText(ExcelUtility.getCellData(3, 1).getNumericCellValue());
	    objAdd.setEmployeeid(actId);
	    Assert.assertEquals(AutomationConstants.expId, actId);
	    
	    String actPswd=NumberToTextConverter.toText(ExcelUtility.getCellData(3, 2).getNumericCellValue());
	    objAdd.setPassword(actPswd);
	    Assert.assertEquals(AutomationConstants.expEPassword, actPswd);
	    
	    String actCpswd=NumberToTextConverter.toText(ExcelUtility.getCellData(3, 3).getNumericCellValue());
	    objAdd.setConfirmpwd(actCpswd);
	    Assert.assertEquals(AutomationConstants.expCPassword, actCpswd);
	    
	    String actEmail=ExcelUtility.getCellData(3, 4).getStringCellValue();
	    objAdd.setEmail(actEmail);
	    Assert.assertEquals(AutomationConstants.expEmail, actEmail);
	    
	    String actPhone=NumberToTextConverter.toText(ExcelUtility.getCellData(3, 5).getNumericCellValue());
	    objAdd.setMobileno(actPhone);
	    Assert.assertEquals(AutomationConstants.expPhone, actPhone);
	    
	    String actDesignation=ExcelUtility.getCellData(3, 6).getStringCellValue();
	    objAdd.setDesignation(actDesignation);
	    Assert.assertEquals(AutomationConstants.expDesignation, actDesignation);
	    
	    String actEType=ExcelUtility.getCellData(3, 7).getStringCellValue();
	    objAdd.setEmptype(actEType);
	    Assert.assertEquals(AutomationConstants.expEType, actEType);
	    
	    String actReporting=ExcelUtility.getCellData(3, 8).getStringCellValue();
	    objAdd.setReporting(actReporting);
	    Assert.assertEquals(AutomationConstants.expReporting, actReporting);
	    
	    objAdd.selectCheckBox();
	    
	    String actMember=ExcelUtility.getCellData(3, 9).getStringCellValue();
	    objAdd.setMember(actMember);
	    Assert.assertEquals(AutomationConstants.expMember, actMember);
	    
	    String actAddress=ExcelUtility.getCellData(3, 10).getStringCellValue();
	    objAdd.setAddress(actAddress);
	    Assert.assertEquals(AutomationConstants.expAddress, actAddress);
	    
	    objAdd.clickSubmit();
		
	}
	
	
	@Test(priority=3)
	public void ValidEmpListVerification() throws Exception{
		
		objList=new EmployeeListPage(getDriver());
		
		objList.openEmployeeList();
		
		objList.clickEditbtn();
		
		objList.openEmployeeList();
		
		objList.clickDeletebtn();
	}

}
