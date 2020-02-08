package question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QuestionDAO {
	
	private static QuestionDAO instance = null;
	
	public static QuestionDAO getInstance() {
		if(instance == null) {
			synchronized(QuestionDAO.class) {
			instance = new QuestionDAO();
			}
		}
		
		return instance;
	}
	
	public void insert(QuestionDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			if(dto.getSong().length == 1) {
				pstmt = conn.prepareStatement("insert into PEOPLE (GENDER, AGE, FIR) values(?,?,?)");
			}
			else if(dto.getSong().length == 2) {
				pstmt = conn.prepareStatement("insert into PEOPLE (GENDER, AGE, FIR, SEC) values(?,?,?,?)");
			}
			else if(dto.getSong().length == 3) {
				pstmt = conn.prepareStatement("insert into PEOPLE values(?,?,?,?,?)");
			}
			pstmt.setString(1, dto.getGender());
			pstmt.setInt(2, dto.getAge());
			for(int i = 0 ; i < dto.getSong().length ; i++) {
				pstmt.setString(i+3, dto.getSong()[i] );
			}
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			
		}
		
	}
	
	public String result() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int ballad = 0;
		int hiphop = 0;
		int elec = 0;
		int rock = 0;
		int dance = 0;
		int indie = 0;
		int rnb = 0;
		 Map<String, Integer> sortedMap = null;
		String maxx = "";
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select FIR, SEC, THI from PEOPLE");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				for( int i = 1 ; i <= 3 ; i++) {
					if (rs.getString(i).equals("ballad")) {
						ballad++;
					}
					if (rs.getString(i).equals("hiphop")) {
						hiphop++;
					}
					if (rs.getString(i).equals("elec")) {
						elec++;
					}
					if (rs.getString(i).equals("rock")) {
						rock++;
					}
					if (rs.getString(i).equals("dance")) {
						dance++;
					}
					if (rs.getString(i).equals("indie")) {
						indie++;
					}
					if (rs.getString(i).equals("rnb")) {
						rnb++;
					}
				}
			}
			map.put("ballad", ballad);
			map.put("hiphop", hiphop);
			map.put("elec", elec);
			map.put("rock", rock);
			map.put("dance", dance);
			map.put("indie", indie);
			map.put("rnb", rnb);
			list.add(ballad);
			list.add(hiphop);
			list.add(elec);
			list.add(rock);
			list.add(dance);
			list.add(indie);
			list.add(rnb);
			int max = Collections.max(list);
			maxx = (String) getKey(map, max);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(rs != null) {try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			
		}
		return maxx;
	}

	private Object getKey(Map<String, Integer> map, int max) {
		
		for(Object o : map.keySet()) {
			if(map.get(o) == max ) {
				return o;
			}
		}
		return null;
	}
	
	public String result2(String gender, int age) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int ballad = 0;
		int hiphop = 0;
		int elec = 0;
		int rock = 0;
		int dance = 0;
		int indie = 0;
		int rnb = 0;
		String maxx = "";
		int start = age / 10 * 10;
		int end = start + 10;
		try {
			conn = ConnUtil.getConnection();
			if(end < 20) {
				pstmt = conn.prepareStatement("select FIR, SEC, THI from PEOPLE where GENDER = ? and AGE < ?");
				pstmt.setString(1, gender);
				pstmt.setInt(2, end);
			}
			else if(start >= 50) {
				pstmt = conn.prepareStatement("select FIR, SEC, THI from PEOPLE where GENDER = ? and AGE >= ?");
				pstmt.setString(1, gender);
				pstmt.setInt(2, start);
			}
			else {
				pstmt = conn.prepareStatement("select FIR, SEC, THI from PEOPLE where GENDER = ? and (? <= AGE and AGE < ?)");
				pstmt.setString(1, gender);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				for( int i = 1 ; i <= 3 ; i++) {
					if (rs.getString(i).equals("ballad")) {
						ballad++;
					}
					if (rs.getString(i).equals("hiphop")) {
						hiphop++;
					}
					if (rs.getString(i).equals("elec")) {
						elec++;
					}
					if (rs.getString(i).equals("rock")) {
						rock++;
					}
					if (rs.getString(i).equals("dance")) {
						dance++;
					}
					if (rs.getString(i).equals("indie")) {
						indie++;
					}
					if (rs.getString(i).equals("rnb")) {
						rnb++;
					}
				}
			}
			map.put("ballad", ballad);
			map.put("hiphop", hiphop);
			map.put("elec", elec);
			map.put("rock", rock);
			map.put("dance", dance);
			map.put("indie", indie);
			map.put("rnb", rnb);
			list.add(ballad);
			list.add(hiphop);
			list.add(elec);
			list.add(rock);
			list.add(dance);
			list.add(indie);
			list.add(rnb);
			int max = Collections.max(list);
			maxx = (String) getKey(map, max);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(rs != null) {try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			
		}
		return maxx;
	}
	
	
	
	
}
