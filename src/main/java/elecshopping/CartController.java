package elecshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@Autowired
	CartDAO dao;
	
	@RequestMapping("/cart") // URL "/shop/cart" 로 매핑함
	public String cart() {
		CartVO vo;
		vo = dao.readCart(1);
		System.out.println(vo.toString());
		vo = dao.readCart(2);
		System.out.println(vo.toString());
		return "cart"; //cart.jsp 보여줌
	}
}
