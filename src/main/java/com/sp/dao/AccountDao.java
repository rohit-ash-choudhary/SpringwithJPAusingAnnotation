package com.sp.dao;

import com.sp.entity.Account;

public interface AccountDao {
	
	public void searchAccountdetail(int employee_id);
	public void updateAccountdetail(int employee_id,int Pincode);
	public void insertAccountdetail(Account acc);
	public void deleteAccountdetail(int employee_id );
	

}
