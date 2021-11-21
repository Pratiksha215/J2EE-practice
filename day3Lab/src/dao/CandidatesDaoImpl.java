package dao;

import static utils.DBUtils.getDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Candidates;
public class CandidatesDaoImpl implements ICandidatesDao {

	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	public  CandidatesDaoImpl() throws Exception{
		// TODO Auto-generated constructor stub
		cn=getDBConnection();
		pst1=cn.prepareStatement("select *from candidates ");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3=cn.prepareStatement("select *from candidates order by votes desc limit 0,2");
	}
	@Override
	public ArrayList<Candidates> displayCandidatesList() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Candidates> c=new ArrayList<Candidates>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
			{
				 c.add(new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return c;
	}
	
	@Override
	public void updateCandidateList(int id) throws Exception {
		pst2.setInt(1, id);
		pst2.executeUpdate();
		
		
	}
	
	@Override
	public ArrayList<Candidates> displayElectionResult() throws Exception {
		ArrayList<Candidates> c=new ArrayList<Candidates>();
		try(ResultSet rst=pst3.executeQuery())
		{
			while(rst.next())
			{
				 c.add(new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return c;
	}
	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		if(pst3!=null)
			pst3.close();
	}

}
