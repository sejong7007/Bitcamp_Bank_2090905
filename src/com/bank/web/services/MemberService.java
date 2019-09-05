package com.bank.web.services;
import com.bank.web.domains.EmployeeBean;

import java.util.List;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;

	public interface MemberService {
	
		public void customerJoin(CustomerBean param);
		public void employeeJoin(EmployeeBean param);
		public List<CustomerBean> findAllCustomers();
		public List<EmployeeBean> findAllEmployees();
		public MemberBean[] findByName(String name);
		public MemberBean findById(String id); 
		public CustomerBean login(MemberBean param);
		int countCustomers(); 
		int countEmployees();
		boolean existId(String id);
		void updatePass(MemberBean param);
		void deleteMember(MemberBean param);
	}
