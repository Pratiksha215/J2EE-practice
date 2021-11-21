package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatesDaoImpl;
import dao.VotersDaoImpl;
import pojo.Candidates;
import pojo.Voters;

/**
 * Servlet implementation class Voting
 */
@WebServlet("/voters")
public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		Voters voter=(Voters)hs.getAttribute("voter");
		VotersDaoImpl voterDao=(VotersDaoImpl)hs.getAttribute("voter_dao");
		CandidatesDaoImpl candidateDao=(CandidatesDaoImpl)hs.getAttribute("candidate_dao");
		
				boolean status=true;
				try {
					status = voterDao.checkVoterStatus(voter.getEmail());
				} catch (Exception e1) {
					throw new ServletException("Error in voting do_get",e1);
				}
				 
			
		
		try(PrintWriter pw=response.getWriter())
		{
			if(!status)
			{
			pw.write("<html><body><form action=savedetail method=get>");
			pw.print("<h3>Voters details</h3>");
			
			
					
					pw.print("<h3>"+voter+"</h3>");
				
			
			ArrayList<Candidates> cd=candidateDao.displayCandidatesList();
			
			pw.print("<h3>Select Your Vote</h3><br>");
			//pw.write("<");
			pw.write("<table style=text-align:center><tr><th></th><th>Candidate Name </th><th>Party Name</th></tr>");

			for(Candidates candidate:cd)
			{
				pw.write("<b><tr><td><input type=radio name=candidate value="+candidate.getId()+"></td><td>"
						+ candidate.getName()+"</td><td>"+candidate.getParty_name()+"</td></tr></b>");
				
			}
			pw.write("</table><br>");
			pw.write("<input type=submit value=Vote>");
			pw.write("</form ></body></html>");
			}
			else {
				pw.write("<h4>Sorry Your vote already recorded... you cannot vote again</h4>");
				pw.write("<h4><a href=logout>LogOut</a></h4>");
				System.out.println("Role::"+voter.getRole());
				if(voter.getRole().equals("admin"))
				pw.write("<h3><a href=adminpage>Back</a></h3>");
			}
		}catch(Exception e)
		{
			throw new ServletException("error in voting doGet"+e);
		}
		
	
		
	}
	
}
