package com.sp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.sp.entity.Account;

public class AccountDaoImpl implements AccountDao{
	
	@PersistenceContext
	private EntityManager em;
	

	

	@Override
	public void searchAccountdetail(int employee_id) {
		// TODO Auto-generated method stub
		try {
		Account acc=em.find(Account.class, employee_id);
		System.out.println("------------------");
		System.out.println("id :"+acc.getEmployee_id());
		System.out.println("First name :"+acc.getFirst_name());
		System.out.println("Last name :"+acc.getLast_name());
	}catch(Exception e)
		{
		  e.printStackTrace();
		}
		}


	@Override
	@Transactional
	public void updateAccountdetail(int employee_id, int Pincode) {
		// TODO Auto-generated method stub
		try {
			Account acc=em.find(Account.class, employee_id);
			acc.setPincode(Pincode);
		
			
		}catch(Exception e)
			{
			  e.printStackTrace();
			}
			}
	


	@Transactional
	@Override
	public void insertAccountdetail(Account acc) {
		// TODO Auto-generated method stub
		try {
		em.persist(acc);
		System.out.println("Insertion successfully");
		}
		catch(Exception e)
		{
			System.out.println("Insertion failed");
			e.printStackTrace();
		}
		
		
	}


	@Override
	@Transactional
	public void deleteAccountdetail(int employee_id) {
		// TODO Auto-generated method stub
		
		try {
			Account acc=em.find(Account.class, employee_id);
			em.remove(acc);
			
		}catch(Exception e)
			{
			  e.printStackTrace();
			}
			}
	
	

}
