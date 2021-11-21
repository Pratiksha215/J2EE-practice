package dao;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User newUser) {
		String mesg="User reg failed.....";
		// get hibernate session from SF
		Session hibSession=getSf().openSession();//new session obj (implicitly asso with L1 cache)
		//begin tx
		Transaction tx=hibSession.beginTransaction();
		try {
			 hibSession.save(newUser);
			//commit tx
			tx.commit();
			mesg="User reg succeeded....";
		}catch (HibernateException e) {
			//in case of hibernate exc : roll back tx
			if(tx != null)
				tx.rollback();
			//how to tell user about error
			throw e;
			
		} finally {
			//close session to release pooled out DB connection
			if(hibSession != null)
				hibSession.close();
		}
		
		return mesg;
	}

}
