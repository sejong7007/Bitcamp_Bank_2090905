package com.bank.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constant;
//import com.sun.org.apache.bcel.internal.classfile.Field;

public class MemberDAOImpl implements MemberDAO {

		
	@Override
	public void insertCustomer(CustomerBean param) {
		try{
			File file = new File(Constant.FILE_PATH+"customers0905_11.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s,%s,%s,%s,%s",
					param.getId(),
					param.getPw(),
					param.getName(),
					param.getSsn(),
					param.getCredit()
					));
			writer.newLine();
			writer.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void insertEmployee(EmployeeBean param) {
		try{

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean newCus = new CustomerBean();
		try {

			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(Constant.FILE_PATH+"customers0905_11.txt"));
			String aa = reader.readLine();
			String[] arr = aa.split(",");
			newCus=param;
			newCus.setId(arr[0]);
			newCus.setPw(arr[1]);
			newCus.setName(arr[2]);
			newCus.setSsn(arr[3]);
			newCus.setCredit(arr[4]);
			System.out.println(newCus.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return newCus;
	}

	
	
}
