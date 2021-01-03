package site.kyutae.cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class JdbcDao {
	private static PoolDataSource _pds;
	static {
		_pds = PoolDataSourceFactory.getPoolDataSource();
		try {
			_pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			_pds.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
			_pds.setUser("scott");
			_pds.setPassword("1234");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		Connection con = null;
		try {
			con = _pds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con) {
		try {
			if(con!=null)con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(con!=null)con.close();
			if(pstmt!=null)pstmt.close();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void close(Connection con,PreparedStatement pstmt, ResultSet rs) {
		try {
			if(con!=null)con.close();
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
