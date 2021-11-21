package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Fund;

@Repository
public class FundDaoImpl implements IFundDao {
//dependency:EntMgr
	@PersistenceContext
	private EntityManager mgr;
	@Override
	public List<Fund> getAllFunds() {
		// TODO Auto-generated method stub
		String jpql="select f from Fund f";
		return mgr.createQuery(jpql,Fund.class).getResultList();
	}
	@Override
	public Fund getFundByName(String name1) {
		String jpql = "select f from Fund f where f.name=:nm";
		return mgr.createQuery(jpql, Fund.class).setParameter("nm", name1).getSingleResult();
	}
	@Override
	public Fund createNewFund(Fund pojo) {
		//pojo : transient
		mgr.persist(pojo); 
		return pojo; //persistent
	}
	@Override
	public Fund updateFund(Fund detachedPOJO) {
		// TODO Auto-generated method stub
		return mgr.merge(detachedPOJO);
	}
	@Override
	public Fund getFundById(int fundId) {
		// TODO Auto-generated method stub
		return mgr.find(Fund.class, fundId) ;
	}
	
	
	
	

}
