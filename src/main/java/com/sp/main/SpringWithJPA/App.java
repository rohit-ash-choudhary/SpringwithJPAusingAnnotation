package com.sp.main.SpringWithJPA;








import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sp.dao.AccountDao;
import com.sp.entity.Account;
import com.sp.resources.SrpingConfigFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SrpingConfigFile.class);
    	
    	AccountDao accado=(AccountDao) context.getBean("adi");
    	
    	Account acc=new Account();
//    	acc.setEmployee_id(2);
//    	acc.setFirst_name("RKrant");
//    	acc.setLast_name("Chary");
//    	acc.setPincode(334344);
//    	
//    	accado.insertAccountdetail(acc);
    	
//    	accado.updateAccountdetail(1, 33333);
    	
    	//accado.searchAccountdetail(1);
    	
    	accado.deleteAccountdetail(2);
    }
    
    
}
