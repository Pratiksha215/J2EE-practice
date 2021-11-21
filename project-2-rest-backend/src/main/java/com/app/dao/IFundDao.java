package com.app.dao;

import java.util.List;

import com.app.pojos.Fund;

public interface IFundDao {

List<Fund> getAllFunds();
Fund getFundByName(String name);
Fund createNewFund(Fund transientPojo);
Fund updateFund(Fund detachedPOJO);//i/p: detached pojo containing updated state
//returns persistent pojo
Fund getFundById(int fundId);
}
