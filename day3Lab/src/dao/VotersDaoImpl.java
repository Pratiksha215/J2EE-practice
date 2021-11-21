package dao;

import static utils.DBUtils.getDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Voters;
public class VotersDaoImpl implements IVotersDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	
	public VotersDaoImpl() throws Exception{
		super();
		cn=getDBConnection();
		pst1=cn.prepareStatement("Select *from Voters where email=? and password=?");
		pst2=cn.prepareStatement("update voters set status=true where email=?");
		pst3=cn.prepareStatement("select status from voters where email=?");
	}

	@Override
	public Voters authenticateVoter(String em, String pass) throws Exception {
		// TODO Auto-generated method stub
		pst1.setString(1, em);
		pst1.setString(2, pass);
		
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
				return new Voters(rst.getInt(1), rst.getString(2), 
						rst.getString(3), rst.getString(4), rst.getBoolean(5), rst.getString(6));
		}
		
		
		return null;
	}
	
	@Override
	public void updateVoterList(String email) throws Exception {
		// TODO Auto-generated method stub
		pst2.setString(1, email);
		pst2.executeUpdate();
		
	}
	

	@Override
	public boolean checkVoterStatus(String email) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Int check "+email);
		pst3.setString(1, email);
		try(ResultSet rst=pst3.executeQuery())
		{
			if(rst.next())
			{
				System.out.println("in check status"+rst.getBoolean(1));
				return rst.getBoolean(1);
			}
		}
		return false;
	}

	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
	}

}
