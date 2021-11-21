package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatesDaoImpl;
import dao.VotersDaoImpl;
import pojo.Candidates;
import pojo.Voters;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		
		CandidatesDaoImpl candidateDao=(CandidatesDaoImpl)hs.getAttribute("candidate_dao");
		try(PrintWriter pw=response.getWriter())
		{
			ArrayList<Candidates> cd=candidateDao.displayElectionResult();
			
			pw.print("<h2>Voting Result</h2><br>");
			//pw.print("<h2>Candidate Lost Election</h2><br>");
			//pw.write("<");
			pw.write("<table style=text-align:center><tr><th>Candidate ID</th><th>Candidate Name </th><th>Party Name</th><th>Total Votes</th></tr>");

			for(Candidates candidate:cd)
			{
				pw.write("<b><tr><td>"+candidate.getId()+"</td><td>"+candidate.getName()+"</td><td>"
						
						+ candidate.getParty_name()+"</td><td>"+candidate.getVotes()+"</td></tr></b>");
				
			}
			pw.write("</table><br>");
			
			pw.write("<h3><a href=logout>LogOut</a></h3>");
			
			
		}catch(Exception e)
		{
			throw new ServletException("error in voting doGet"+e);
		}
		
		}
	}


