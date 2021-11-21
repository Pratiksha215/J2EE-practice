package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
import pojo.Voters;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/savedetail")
public class SaveDetailsServlet extends HttpServlet {
	

	/**
	 * @see Servlet#destroy()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		Voters voter=(Voters)hs.getAttribute("voter");
		VotersDaoImpl voterDao=(VotersDaoImpl)hs.getAttribute("voter_dao");
		CandidatesDaoImpl candidateDao=(CandidatesDaoImpl)hs.getAttribute("candidate_dao");
		Cookie [] c=request.getCookies();
		boolean status=true;
		
		try {
			status = voterDao.checkVoterStatus(voter.getEmail());
		} catch (Exception e1) {
			throw new ServletException("Error in voting do_get",e1);
		}
		
		try(PrintWriter pw=response.getWriter()) {
			if(!status)
			{
			pw.write("<h3>Your Vote has been recorded</h3>");
			candidateDao.updateCandidateList(Integer.parseInt(request.getParameter("candidate")));
		
					
						voterDao.updateVoterList(voter.getEmail());
					
				}
		
			else
			{
				pw.write("<h3>Your Vote alerady recorded....you cannot vote again</h3>");
				
			}
			pw.write("<h3><a href=logout>LogOut</a></h3>");
			if(voter.getRole().equals("admin"))
			pw.write("<h3><a href=adminpage>Back</a></h3>");
			
			
		} catch (Exception e) {

			throw new ServletException("Error in logout doGet" , e);
		}
	}

}
