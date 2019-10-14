package com.dhee.daoFactory;

import com.dhee.dao.AdminDao;
import com.dhee.daoLmpl.AdminImpl;

public class DAOFactory {
	
	public AdminDao getAdminImpl() {
		return new AdminImpl();
	}

}
