package elecshopping;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@Autowired
	CartService svc;
	
	@RequestMapping("/cart") // URL "/shop/cart" 로 매핑함
	public String cart() {
		CartVO vo;
		ArrayList<CartVO> voList;
		vo = svc.readCart(1);
		System.out.println("cnum=1 검색: " + vo.toString());
		vo = svc.readCart(2);
		System.out.println("cnum=2 검색: " + vo.toString());
		vo = svc.createCart("ple", 1);
		System.out.println("id=ple, pnum=1 생성: " + vo.toString());
		vo = svc.readCart(3);
		System.out.println("cnum=3 검색: " + vo.toString());
		vo = svc.readCart("ple", 1);
		System.out.println("id=ple, pnum=1 검색: " + vo.toString());
		voList = svc.readCarts("ple");
		System.out.println("ple 전체검색:");
		for(CartVO singleVo : voList) {
			System.out.println("	검색: " + singleVo.toString());
		}
		vo = svc.deleteCart(5);
		System.out.println("cnum=2 삭제: " + vo.toString());
		return "cart"; //cart.jsp 보여줌
	}
}
