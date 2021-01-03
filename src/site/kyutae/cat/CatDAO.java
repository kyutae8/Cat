package site.kyutae.cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO extends JdbcDao{
	private static CatDAO _dao;
	private CatDAO() {
		// TODO Auto-generated constructor stub
	}
	static {
		_dao = new CatDAO();
	}
	public static CatDAO getDao() {
		return _dao;
	}
	//전체보기
	public List<CatDTO> viewAll(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CatDTO> list = new ArrayList<CatDTO>();
		try {
			con = getCon();
			String sql = "select * from cat order by cnum";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatDTO cat = new CatDTO();
				cat.setCnum(rs.getInt(1));
				cat.setCname(rs.getString(2));
				cat.setCkind(rs.getString(3));
				cat.setCage(rs.getString(4));
				cat.setCgender(rs.getString(5));
				cat.setCbirth(rs.getString(6));
				list.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	 public int inesrt(CatDTO cat) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 int row = 0;
		 try {
			con = getCon();
			 String sql = "insert into cat values(?,?,?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1,cat.getCnum());
			 pstmt.setString(2,cat.getCname());
			 pstmt.setString(3,cat.getCkind());
			 pstmt.setString(4,cat.getCage());
			 pstmt.setString(5,cat.getCgender());
			 pstmt.setString(6,cat.getCbirth());
			 row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}return row;
	 }
	 public List<CatDTO> searchno(int no){
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 List<CatDTO> list = new ArrayList<CatDTO>();
		 try {
			con = getCon();
			 String sql = "select * from cat where cnum = ?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1,no);
			 rs = pstmt.executeQuery();
			 if (rs.next()) {
				CatDTO cat = new CatDTO();
				cat.setCnum(rs.getInt(1));
				cat.setCname(rs.getString(2));
				cat.setCkind(rs.getString(3));
				cat.setCage(rs.getString(4));
				cat.setCgender(rs.getString(5));
				cat.setCbirth(rs.getString(6));
				list.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		 return list;
	 }
	 public List<CatDTO> searchname(String name){
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 List<CatDTO> list = new ArrayList<CatDTO>();
		 try {
			con = getCon();
			 String sql = "select * from cat where cname = ?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,name);
			 rs = pstmt.executeQuery();
			 while (rs.next()) {
				CatDTO cat = new CatDTO();
				cat.setCnum(rs.getInt(1));
				cat.setCname(rs.getString(2));
				cat.setCkind(rs.getString(3));
				cat.setCage(rs.getString(4));
				cat.setCgender(rs.getString(5));
				cat.setCbirth(rs.getString(6));
				list.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		 return list;
	 }
	 public int update(CatDTO cat) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 int row = 0;
		 try {
			con = getCon();
			 String sql = "update cat set cname = ?,ckind=?,cage=?,cgender=?,cbirth=? where cnum =?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,cat.getCname());
			 pstmt.setString(2,cat.getCkind());
			 pstmt.setString(3,cat.getCage());
			 pstmt.setString(4,cat.getCgender());
			 pstmt.setString(5,cat.getCbirth());
			 pstmt.setInt(6,cat.getCnum());
			 row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		 return row;
	 }
	 public int delete(int no) {
		 Connection con=null;
		 PreparedStatement pstmt = null;
		 int row = 0;
		 try {
			con = getCon();
			 String sql = "delete from cat where cnum=?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1,no);
			 row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		 return row;
	 }
}
