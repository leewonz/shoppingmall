package elecshopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component("cartdao")
public class CartDAO {
	
	public int createCart(String id, int pnum) {

		String sql = "INSERT into cart (cnum, id, pnum)" + 
		" values((SELECT NVL(MAX(cnum),0)+1 FROM cart), ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		int row = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			// ?세팅작업
			ps.setString(1, id);
			ps.setInt(2, pnum);
			row = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return row;
	}
	
	public CartVO readCart(String id, int pnum){
		String sql = "select * from cart "
				+ "where (id = ? and pnum = ?)";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CartVO result = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?세팅작업
			ps.setString(1,  id);
			ps.setInt(2,  pnum);
			
			rs = ps.executeQuery();
			
				while(rs.next()) {
					int cnum = rs.getInt("cnum");
					
					result = new CartVO(cnum, id, pnum);
				}
		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public CartVO readCart(int cnum){
		String sql = "select * from cart"
				+ " where cnum = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CartVO result = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?세팅작업
			ps.setInt(1,  cnum);
			
			rs = ps.executeQuery();
			
				while(rs.next()) {
					
					int pnum = rs.getInt("pnum");
					
					String id = rs.getString("id");
//					System.out.println(cnum);
//					System.out.println(id);
//					System.out.println(pnum);
					result = new CartVO(cnum, id, pnum);
//					System.out.println(result);
				}
		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public ArrayList<CartVO> readCarts(String id){
		String sql = "select * from cart "
				+ "where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CartVO> result = new ArrayList<CartVO>();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?세팅작업
			ps.setString(1,  id);

			rs = ps.executeQuery();
			
				while(rs.next()) {
					int cnum = rs.getInt("cnum");
					int pnum = rs.getInt("pnum");
					
					result.add(new CartVO(cnum, id, pnum));
				}
		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public ArrayList<CartVO> readCarts(){
		String sql = "select * from cart ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CartVO> result = new ArrayList<CartVO>();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			
				while(rs.next()) {
					int cnum = rs.getInt("cnum");
					String id = rs.getString("id");
					int pnum = rs.getInt("pnum");
					
					result.add(new CartVO(cnum, id, pnum));
				}
		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int updateCart(
			int cnum, CartVO vo){
		String sql = "update cart set id = ?, pnum = ? "
				+ "where cnum = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int row = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?세팅작업
			ps.setString(1,  vo.getId());
			ps.setInt(2,  vo.getPnum());
			ps.setInt(3,  cnum);

			row = ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return row;
	}
	
	public int deleteCart(
			int cnum){
		String sql = "delete from cart "
				+ "where cnum = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int row = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?세팅작업
			ps.setInt(1, cnum);

			row = ps.executeUpdate();
			
			System.out.printf("%d개의 행이 영향받음%n", row);
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return row;
	}
}










class JDBCUtil {
	public static Connection getConnection() {

		String driver = "oracle.jdbc.driver.OracleDriver";
//	String url="jdbc:oracle:thin:@70.12.113.179:1521:xe";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String pw = "hr";

		Connection con = null;

		try {
			// 1. 드라이버 로딩
			Class.forName(driver); // 클래스 동적
			// 2. 커넥션
			con = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 확인하세요 ^^;;");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
		//System.out.println(con);
		return con;
	}

	public static Connection getConnection(File f) {

		String driver = "";
		String url = "";
		String user = "";
		String pw = "";

		Scanner sc = null;

		try {
			sc = new Scanner(new FileInputStream(f));

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String key = "";
				String value = "";
				int index = line.indexOf("=");
				if (index > -1) {
					key = line.substring(0, index);
					value = line.substring(index + 1);
					switch (key) {
					case "driver":
						driver = value;
						break;
					case "url":
						url = value;
						break;
					case "user":
						user = value;
						break;
					case "pw":
						pw = value;
						break;
					default:
						System.out.println("db 연결 파일에 키 " + key + "가 없습니다.");
					}
				}
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			sc.close();
		}

		Connection con = null;

		try {
			// 1. 드라이버 로딩
			Class.forName(driver); // 클래스 동적
			// 2. 커넥션
			con = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 확인하세요 ^^;;");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}

		return con;
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		// 6. 자원 반납
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}