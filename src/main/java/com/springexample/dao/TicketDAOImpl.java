package com.springexample.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springexample.model.Ticket;
import com.springexample.model.history;

@Repository
@Transactional
public class TicketDAOImpl implements TicketDAO{

	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession(){
		  return sessionFactory.getCurrentSession();
		 }
	
	public void addTicket(Ticket ticket) {
	
		for (history h : ticket.getHistorys()) {
			h.setTicket(ticket);
		}
		getSession().merge(ticket);
	}

}
