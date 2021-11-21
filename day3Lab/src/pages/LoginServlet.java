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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotersDaoImpl voterDao;
	private CandidatesDaoImpl candidateDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			 voterDao=new VotersDaoImpl();
			 candidateDao=new  CandidatesDaoImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Error In Init",e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			voterDao.cleanUp();
			candidateDao.cleanUp();
		} catch (SQLException e) {
			System.out.println("err in destroy "+e);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
	Voters v=voterDao.authenticateVoter(request.getParameter("em"), request.getParameter("pass"));
	if(v==null)
	{
		pw.print("<h3> Invalid Credentials..Please retry</h3>") ;
		pw.print("<h4><a href=login.html>Please retry</a></h4>");
	}
	else
	{
		
		HttpSession hs=request.getSession();
		hs.setAttribute("candidate_dao", candidateDao);
		hs.setAttribute("voter_dao", voterDao);
		hs.setAttribute("voter", v);
		if(v.getRole().equals("voter"))
			response.sendRedirect("voters");
		if(v.getRole().equals("admin"))
			response.sendRedirect("adminpage");
		
	}
		
		}
		catch (Exception e) {
			throw new ServletException("err in do-get", e);
	}

}
}
