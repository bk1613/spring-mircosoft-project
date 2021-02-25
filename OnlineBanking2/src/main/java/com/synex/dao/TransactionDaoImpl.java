package com.synex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.synex.domain.BankTransaction;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	SessionFactory sessionfactory;
	Session s = null;
	
	@Override
	public BankTransaction findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankTransaction save(BankTransaction bankTransaction) {
		// TODO Auto-generated method stub
		BankTransaction btdb = findById(bankTransaction.getBankTransactionId());
		try {
			s = sessionfactory.openSession();
			s.beginTransaction();
			if(btdb == null) {
				s.save(bankTransaction);
			}
			s.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return bankTransaction;
	}

	@Override
	public BankTransaction findById(long id) {
		// TODO Auto-generated method stub
		BankTransaction bt = null;
		try(Session session = sessionfactory.openSession();){
			session.beginTransaction();
			bt = session.get(BankTransaction.class, id);
		}catch(Exception ex) {
			System.out.println("Problem in checking transaction");
			ex.printStackTrace();
		}
		return bt;
	}
	
	
}
