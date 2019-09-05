package com.bank.web.serviecimpls;

import java.util.List;

import com.bank.web.daoimpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberDAO dao;
	
	public MemberServiceImpl() {
		
		dao = new MemberDAOImpl();
	}
	
	@Override
	public void customerJoin(CustomerBean param) {
		dao.insertCustomer(param);
		
	}

	@Override
	public void employeeJoin(EmployeeBean param) {
		
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return null;
		}

	@Override
	public List<EmployeeBean> findAllEmployees() {
		return null;
	}

	@Override
	public MemberBean[] findByName(String name) {
		
		return null;
	}

	@Override
	public MemberBean findById(String id) {
		return null;
	}

	@Override
	public CustomerBean login(MemberBean param) {
		System.out.println(param.toString());
		CustomerBean cus = new CustomerBean();
		return dao.login(cus);
	}

	@Override
	public int countCustomers() {

		return 0;
	}

	@Override
	public int countEmployees() {

		return 0;
	}

	@Override
	public boolean existId(String id) {

		return false;
	}

	@Override
	public void updatePass(MemberBean param) {
		
	}

	@Override
	public void deleteMember(MemberBean param) {
		
	}

}
