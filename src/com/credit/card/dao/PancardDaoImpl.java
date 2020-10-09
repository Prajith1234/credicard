/**
 * 
 */
package com.credit.card.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.credit.card.entity.Pancard;

/**
 * @author sairam
 *
 */
@Repository
public class PancardDaoImpl implements PancardDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;

	@Override
	@SuppressWarnings("unchecked")
	public void savePancards() {

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			List<Pancard> li = getPancardDetails();
			li.stream().forEach(p -> {
				session.saveOrUpdate(p);
			});

			List<Pancard> i = session.createQuery("from Pancard").list();
			System.out.println(i);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception ::" + e);
			tx.rollback();
		}

	}

	@Override
	public String searchPancard(String pancardNumber) {
		int i = 0;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			i = session.createQuery("from Pancard where pancardNumber=" + pancardNumber).getFetchSize();
			System.out.println(i);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception ::" + e);
			tx.rollback();
		}
		return i > 0 ? "True" : "false";
	}

	public List<Pancard> getPancardDetails() {

		List<Pancard> listPancard = new ArrayList<Pancard>();

		Pancard p = new Pancard();
		p.setPanCardNumber("AXSSP1122H");
		p.setCreditScore(3.10f);

		Pancard p1 = new Pancard();
		p1.setPanCardNumber("APPSA3355P");
		p1.setCreditScore(8.50f);

		Pancard p2 = new Pancard();
		p2.setPanCardNumber("APPXA2244X");
		p2.setCreditScore(9.50f);

		Pancard p3 = new Pancard();
		p3.setPanCardNumber("AXVPS7766V");
		p3.setCreditScore(1.50f);

		Pancard p4 = new Pancard();
		p4.setPanCardNumber("ASXPS2121S");
		p4.setCreditScore(5.10f);

		listPancard.add(p);
		listPancard.add(p1);
		listPancard.add(p2);
		listPancard.add(p3);
		listPancard.add(p4);

		return listPancard;
	}

}
