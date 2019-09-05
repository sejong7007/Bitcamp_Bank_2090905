package com.bank.web.serviecimpls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService {

	private List <AccountBean> accounts;
	
	public AccountServiceImpl () {
		accounts = new ArrayList<>();
	}
	
	@Override
	public void createAccount(String money) {
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum());
		acc.setMoney(money);
		acc.setToday(findDate());
		accounts.add(acc);
	}

	@Override
	public String createAccountNum() {
		String result = "";
		Random ran = new Random();
		for(int i=0 ; i<10 ; i++) {
			if(i==4) {
				result += "-";
			}
			result += ran.nextInt();
		}
		return result;
	}

	@Override
	public List<AccountBean> findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean a = new AccountBean();
		for( AccountBean c : accounts) {
			if(accountNum.equals(c.getAccountNum())) {
				a = c;
			}
		}
		return a;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(AccountBean aa : accounts) {
			if(accountNum.equals(aa.getAccountNum())) {
				flag = true;
			}
		}
		return flag;
		
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		AccountBean acc = new AccountBean();
		for(AccountBean bb : accounts) {
			if(param.getAccountNum().equals(bb.getAccountNum())) {
				acc = bb;
				int sum = Integer.parseInt(acc.getMoney())+Integer.parseInt(param.getMoney());
				acc.setMoney(sum + "");
			}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		AccountBean acc = new AccountBean();
		for(AccountBean bb : accounts) {
			if(param.getAccountNum().equals(bb.getAccountNum())) {
				acc = bb;
				int sum = Integer.parseInt(param.getMoney())-Integer.parseInt(acc.getMoney());
				acc.setMoney(sum + "");
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		for(AccountBean bb : accounts) {
			if(accountNum.equals(bb.getAccountNum())) {
				accounts.remove(bb);
			}
		}
	}

}
