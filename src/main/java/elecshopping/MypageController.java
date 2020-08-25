package elecshopping;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	
	
	@Autowired
	MypageDAO dao;
	
	@RequestMapping("/mypage")
	public ModelAndView Mypage(String id) {
		MypageVO myinfo = dao.getInfo(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("myinfo", myinfo);
		mv.setViewName("mypage");
		return mv;
	}
	

}