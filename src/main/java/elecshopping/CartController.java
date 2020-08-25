package elecshopping;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
	@Autowired
	CartService svc;

	@RequestMapping("/cart") // URL "/shop/cart" 로 매핑함
	public String cart(Model model) {
		ArrayList<CartVO> voList;
		String id = "ple";

		voList = svc.readCarts(id);

		model.addAttribute("id", id);
		model.addAttribute("voList", voList);

		return "cart"; // cart.jsp 보여줌
	}

	@RequestMapping("/carttest") // URL "/shop/carttest" 로 매핑함
	public String carttest() {
		
		return "carttest"; // carttest.jsp 보여줌
	}
	
	@RequestMapping("/cartdelete") // URL "/shop/cartdelete" 로 매핑함
	public String cartdelete(@RequestParam(value="cnum", required=true) String cnum_str) {
		int cnum = Integer.parseInt(cnum_str);
		System.out.println();
		svc.deleteCart(cnum);
		return "redirect:/cart"; // carttest.jsp 보여줌
	}
	/*
	 * @RequestMapping("/cart") // URL "/shop/cart" 로 매핑함
	 * 
	 * public String cart() { CartVO vo; ArrayList<CartVO> voList; vo =
	 * svc.readCart(1); System.out.println("cnum=1 검색: " + vo.toString()); vo =
	 * svc.readCart(2); System.out.println("cnum=2 검색: " + vo.toString()); vo =
	 * svc.createCart("ple", 1); System.out.println("id=ple, pnum=1 생성: " +
	 * vo.toString()); vo = svc.readCart(3); System.out.println("cnum=3 검색: " +
	 * vo.toString()); vo = svc.readCart("ple", 1);
	 * System.out.println("id=ple, pnum=1 검색: " + vo.toString()); voList =
	 * svc.readCarts("ple"); System.out.println("ple 전체검색:"); for(CartVO singleVo :
	 * voList) { System.out.println("	검색: " + singleVo.toString()); } vo =
	 * svc.deleteCart(5); System.out.println("cnum=2 삭제: " + vo.toString()); return
	 * "cart"; //cart.jsp 보여줌 }
	 */
}
