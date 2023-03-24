package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.prop.Appcons;
import com.example.demo.prop.Appmsg;
import com.example.demo.service.ServiceContact;

@RestController
public class RestContact {
	@Autowired
	public ServiceContact service;
	@Autowired
	public Appmsg msg;

	@PostMapping("/add")
	public String addContact(@RequestBody Contact c) {
		boolean b = service.savecontact(c);
		Map<String, String> message = msg.getMessages();
		if (b) {
			return message.get(Appcons.Contact_Save_Succ);
		} else {
			return message.get(Appcons.Contact_Save_Fail);
		}
	}

	@GetMapping("/getall")
	public List<Contact> getContact() {
		List<Contact> d = service.getContacts();

		return d;

	}

	@GetMapping("/update/{cid}")
	public Contact getByID(@PathVariable("cid") Integer id) {
		Contact q = service.getByID(id);
		return q;
	}

	@DeleteMapping("/delete/{cid}")
	public String deleteById(@PathVariable("cid") Integer id) {
		boolean b = service.deleteById(id);
		Map<String, String> message = msg.getMessages();
		if (b) {
			return message.get(Appcons.Contact_Del_Succ);
		} else {
			return message.get(Appcons.Contact_Del_Fail);
		}
	}

}
