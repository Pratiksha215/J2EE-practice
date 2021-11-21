package com.app.service;

import java.util.List;

import com.app.pojos.Fund;

public interface IFundService {
	List<Fund> getAllFunds();
	Fund getFundByName(String name);
	Fund createNewFund(Fund transientPojo);
	Fund updateFund(int fundId,Fund detachedPOJO);
}
