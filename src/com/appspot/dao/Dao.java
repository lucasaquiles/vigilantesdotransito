package com.appspot.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.model.Occurrency;

public enum Dao {
	INSTANCE;

	public List<Occurrency> listOccurrencys() {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select o from Occurrency o order by date");
		List<Occurrency> occurrencys = q.getResultList();
		return occurrencys;
	}

	public void add(String plate, String type, String description) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Occurrency Occurrency = new Occurrency(plate, type, description,
					new Date());
			em.persist(Occurrency);
			em.close();
		}
	}

	public List<Occurrency> getOccurrencys(String plate) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select o from Occurrency o where o.plate = :plate");
		q.setParameter("plate", plate);
		List<Occurrency> Occurrencys = q.getResultList();
		return Occurrencys;
	}

	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Occurrency Occurrency = em.find(Occurrency.class, id);
			em.remove(Occurrency);
		} finally {
			em.close();
		}
	}
}