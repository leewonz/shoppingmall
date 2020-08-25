package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component("mypagedao")
public class MypageDAO {
	
	MypageVO getInfo(HttpSession session) {
		MypageVO vo  = new MypageVO();
		String id = (String) session.getAttribute("id");
		
		try { 
			String sql = "select * from member where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);
			
			System.out.println(con.toString());

			pt.setString(1, id);
			ResultSet rs = pt.executeQuery();

			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));	
			}
			pt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("--------");
		System.out.println(vo.getId());
		System.out.println(vo.getName());


		return vo;
		
		
	}

	public Object editMypage(HttpSession session) {
		// TODO Auto-generated method stub
		MypageVO vo  = new MypageVO();
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("password");
		String name = (String) session.getAttribute("name");
		String phone = (String) session.getAttribute("phone");
		
		try { 
			String sql = "update member set pw=?, name=?, phone=? where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);
			
			System.out.println(con.toString());

			pt.setString(1, pw);
			pt.setString(2, name);
			pt.setString(3, phone);
			pt.setString(4, id);
			pt.executeUpdate();

			pt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		return vo;
	}
	
	
	
	

}
