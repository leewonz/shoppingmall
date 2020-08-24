package elecshopping;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("cartsvc")
public class CartService {
	private CartDAO dao;
	
	public CartService() {
		this.dao = new CartDAO();
	}
	
	public CartService(CartDAO dao) {
		this.dao = dao;
	}
	
	public CartVO createCart(String id, int pnum) {
		CartVO result = null;
		int rows;
		rows = dao.createCart(id, pnum);
		if(rows == 1)
		{
			return dao.readCart(id, pnum);
		}else {
			System.out.println("CartService 장바구니 생성 실패");
			return null;
		}
	}
	
	public CartVO readCart(String id, int pnum) {
		return dao.readCart(id, pnum);
	}
	
	public CartVO readCart(int cnum) {
		return dao.readCart(cnum);
	}
	
	public ArrayList<CartVO> readCarts(String id) {
		return dao.readCarts(id);
	}
	
	public ArrayList<CartVO> readCarts() {
		return dao.readCarts();
	}
	
	public CartVO updateCart(int cnum, CartVO vo) {
		int rows = dao.updateCart(cnum, vo);
		if(rows >= 1)
		{
			return dao.readCart(cnum);
		}else {
			System.out.println("CartService 장바구니 변경 실패");
			return null;
		}
	}
	
	public CartVO deleteCart(int cnum) {
		CartVO result = dao.readCart(cnum);
		int rows = dao.deleteCart(cnum);
		if(rows >= 1)
		{
			return result;
		}else {
			System.out.println("CartService 장바구니 삭제 실패");
			return null;
		}
	}
}
