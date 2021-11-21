package tester;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegisterUser {

	public static void main(String[] args) {
		// parse string --> java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user details : name,email, password, regAmount,  regDate,  userRole) ");
			// create user instance
			User u1 = new User(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()),
					Role.valueOf(sc.next().toUpperCase()));
			System.out.println(dao.registerUser(u1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
