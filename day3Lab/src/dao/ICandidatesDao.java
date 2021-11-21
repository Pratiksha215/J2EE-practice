package dao;

import java.util.ArrayList;

import pojo.Candidates;

public interface ICandidatesDao {

	ArrayList<Candidates> displayCandidatesList() throws Exception;
	void updateCandidateList(int id)throws Exception;
	ArrayList<Candidates> displayElectionResult() throws Exception;
}
