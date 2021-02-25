package com.synex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.synex.domain.Account;
@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	SessionFactory sessionfactory;
	Session s = null;
	
	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		List<Account> acc = new ArrayList<>();
		try (Session se = sessionfactory.openSession();){
			se.beginTransaction();
			acc = se.createQuery("from Account").list();
			acc.forEach(a->System.out.println(a.getAccountId() + ", " + a.getAccountHolder()+ ", " +a.getAccountDateOPened()+ ", " +a.getAccountType() + ", " + a.getAccountBalance()
			+ ", " + a.getAccountBranch() + ", " + a.getAccountCustomer()));
		}
		return acc;
	}

	@Override
	public Account findAccountByid(Long accountId) {
		// TODO Auto-generated method stub
		Account acc = null;
		try(Session session = sessionfactory.openSession();){
			session.beginTransaction();
			acc = session.get(Account.class, accountId);
		}catch(Exception ex) {
			System.out.println("Problem in checking transaction");
			ex.printStackTrace();
		}
		System.out.println(acc);
		return acc;
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountById(Long accountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findAccountByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
