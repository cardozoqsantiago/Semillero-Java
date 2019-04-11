package com.hbt.semillero.servicios.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ConsultasTransaccionBean {

	@Resource
	private UserTransaction utx;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void modificacion() throws IllegalStateException, SecurityException, SystemException {
		
		try {
			utx.begin();
			
			entityManager.createQuery("UPDATE");
			
			utx.commit();
			
		} 
		catch (Exception e) {
			
			utx.rollback();
		} 
	}
}
