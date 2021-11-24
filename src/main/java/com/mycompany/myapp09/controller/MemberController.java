package com.mycompany.myapp09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myapp09.model.service.MemberService;




@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {
		String msg = null;
		try {
			int result = memberService.idCheck(id);
			if (result > 0)
				msg = "false";
			else
				msg = "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
