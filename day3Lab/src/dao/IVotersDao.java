package dao;

import pojo.Voters;

public interface IVotersDao {
	
	Voters authenticateVoter(String em,String pass) throws Exception;
	void updateVoterList(String email) throws Exception;
	boolean checkVoterStatus(String email) throws Exception;

}
