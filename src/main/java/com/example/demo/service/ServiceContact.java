package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepo;

@Service
public class ServiceContact {
	@Autowired
	private ContactRepo cr;

	public boolean savecontact(Contact con) {
		Contact cn = cr.save(con);
		if (cn.getS_no() != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<Contact> getContacts() {
		List<Contact> c = cr.findAll();

		return c;

	}

	public Contact getByID(Integer id) {
		Optional<Contact> f = cr.findById(id);
		if (f.isPresent()) {

			return f.get();
		} else {

			return null;
		}
	}

	public boolean deleteById(Integer id) {
		Optional<Contact> f = cr.findById(id);
		if (f.isPresent()) {
			cr.deleteById(id);
			return true;
		} else {

			return false;
		}
	}

}
