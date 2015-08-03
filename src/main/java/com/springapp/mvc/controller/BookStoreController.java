package com.springapp.mvc.controller;

import com.springapp.mvc.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BookStoreController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		Book book = new Book();
		book.setTitle("Moby Dick");
		StringBuilder string = new StringBuilder();
		string.append(book.getTitle());
		model.addAttribute("message", string.toString());
		return "index";
	}
		@RequestMapping(value = "/books", method = RequestMethod.GET)
		public String printWelcome2(ModelMap model) {
			Book book = new Book();
			book.setTitle("Moby Dick");
			book.setPrice(22.40);
			book.setPublisher("Penguin");
			StringBuilder string = new StringBuilder();
			string.append(book.getTitle()+" " + book.getPrice()+ book.getPublisher());
			model.addAttribute("message", string.toString());
			return "book";
		}

//	@RequestMapping(value = "/post", method = RequestMethod.POST, produces="application/json", consumes="application/json")
//	@ResponseBody
//	public String post(@RequestBody String json) {
//		ArrayList<Book> books = new ArrayList<Book>();
//		ObjectMapper mapper = new ObjectMapper();
//		pj = mapper.readValue(json, POJO.class);
//
//		//do some things with json, put some header information in json
//		return mapper.writeValueAsString(pj);
//	}
}