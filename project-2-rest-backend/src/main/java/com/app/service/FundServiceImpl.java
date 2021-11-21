package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFundDao;
import com.app.pojos.Fund;

@Service
@Transactional
public class FundServiceImpl implements IFundService{
	
@Autowired
private  IFundDao dao;

@Override
public List<Fund> getAllFunds() {
	// TODO Auto-generated method stub
	return dao.getAllFunds();
}

@Override
public Fund getFundByName(String name) {
	// TODO Auto-generated method stub
	return dao.getFundByName(name);
}

@Override
public Fund createNewFund(Fund transientPojo) {
	// TODO Auto-generated method stub
	return dao.createNewFund(transientPojo);
}//ORM frmwork: run time exc => no dirty chcking , tx rolled back, ent mgr is closed: L1 cache is destroyed, cn rets to pool
//no run time exc =>  dirty chcking(insert) , tx committed, ent mgr is closed: L1 cache is destroyed, cn rets to pool
//service layer rets detached pojo to controlller

@Override
public Fund updateFund(int fundId, Fund detachedPOJO) {
	//check if fund exists
	Fund existingFund = dao.getFundById(fundId);
	if(existingFund != null) {
		//properties : qty n date
		existingFund.setQuantity(detachedPOJO.getQuantity());
		existingFund.setPublishDate(detachedPOJO.getPublishDate());
		return	dao.updateFund(existingFund);
	}
	 return null;
}



}
