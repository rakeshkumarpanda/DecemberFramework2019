package com.seleniumeasy.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataCollection 
{
	String excelPath = "./TestDataFolder/TestData.xlsx";
	Fillo fillo;
	Connection connection;
	
	public DataCollection() throws FilloException
	{
		fillo = new Fillo();
		connection = fillo.getConnection(excelPath);
	}
	
	@DataProvider(name="Submit Form Data")
	public Iterator<String[]> submitFormData() throws FilloException
	{
		String query = "select firstname, lastname, email, phone, state from sheet1 where flag='Y' and scenario='SubmitForm'";
		List<String[]> lst = new ArrayList<String[]>();
		Recordset rs = connection.executeQuery(query);
		try
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					String[] str = new String[5];
					str[0] = rs.getField("firstname");
					str[1] = rs.getField("lastname");
					str[2] = rs.getField("email");
					str[3] = rs.getField("phone");
					str[4] = rs.getField("state");
					lst.add(str);
				}
			}	
		}
		catch(NullPointerException e)
		{
			Reporter.log("Scenario doesn't contain any set of test data");
		}
		catch (Exception e) 
		{
			Reporter.log("Scenario doesn't contain any set of test data");
		}
		return lst.iterator();
	}

}
