package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		binder.registerCustomEditor(String[].class, "hobby",new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator());	// UserValidator를 WebDataBinder의 로컬 validator로 등록
//		binder.addValidators(new UserValidator());	// UserValidator를 WebDataBinder의 로컬 validator로 등록
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList="+validatorList);
	}
	
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")	// 신규회원 가입 화면
//	@GetMapping("/register.add")
	public String register() {
		return "registerForm";	// WEB-INF/views/registerForm.jsp
	}
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save") // 4.3부터
	public String save(@Valid User user,BindingResult result, Model m) throws Exception {
		
		// 수동검증 - Validator를 직접 생성하고, validate()를 직접 호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result);	// BindingResult는 Errors의 자손
		
		// 자동검증
		
		
		// User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야 함.
		if(result.hasErrors()) {
			return "registerForm";
		
		// 1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
//			
//			m.addAttribute("msg",msg);
//			return "forward:/register/add";			// 이 두줄이 자동으로 밑에처럼 바뀐다.
//			return "redirect:/register/add?msg="+msg;	// url재작성(rewriting)
			// redirect -> 재요청을 의미함.
		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
