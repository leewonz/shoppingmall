package elecshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CartDAO {
	public CartVO addCart(String id, int pnum) {

		String sql = "INSERT into cart (id, pnum)"
				+ " values(?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		int row = 0;
		try {
			//con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?세팅작업
			ps.setString(1,  id);
			ps.setInt(2,  pnum);
			row = ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			//JDBCUtil.close(con, ps, null);
		}
		return null;
	}
}
