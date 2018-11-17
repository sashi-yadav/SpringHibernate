package com.springexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.dao.TicketDAO;
import com.springexample.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService{
	TicketDAO ticketDao;
	
	@Autowired
	public void setTicketDao(TicketDAO ticketDao)
	{
		this.ticketDao=ticketDao;
	}
	public void doAddTicket(Ticket ticket) {
		ticketDao.addTicket(ticket);
	}

}
