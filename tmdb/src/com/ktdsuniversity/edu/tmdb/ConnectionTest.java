package com.ktdsuniversity.edu.tmdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ConnectionTest {

	public static MvVO selectMovie(String mvId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("ojdbc 드라이버가 발견되지 않았습니다.");
		}

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "TMDB";
		String userPassword = "TMDB";
		Connection dbConnection = null;

		try {
			dbConnection = DriverManager.getConnection(url, userName, userPassword);
			System.out.println(dbConnection.getSchema());
		} catch (SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.", sqle);
		}

		// Oracle로 쿼리를 전송하고 실행 한 뒤 결과를 받아온다.
		// 영화의 정보만 조회를 해본다.
		// 쿼리 가져오는 방법
		// 1. string buffer
		StringBuffer query = new StringBuffer();
		query.append("SELECT MV_ID                               ");
		query.append("	   , TTL                                     ");
		query.append(" 	   , MV_RTNG                                 ");
		query.append("	   , RNNG_TM                                 ");
		query.append("	   , SMMR                                    ");
		query.append("	   , TO_CHAR(RLS_DT, 'YYYY-MM-DD') AS RLS_DT ");
		query.append("	   , MAIN_PSTR_URL                           ");
		query.append("	   , FB_URL                                  ");
		query.append("	   , X_URL                                   ");
		query.append("	   , INSTA_URL                               ");
		query.append("	   , TGLN                                    ");
		query.append("	   , ORGNL_TTL                               ");
		query.append("	   , PLYNG                                   ");
		query.append("	   , ORGNL_LNGG                              ");
		query.append("	   , BDGT                                    ");
		query.append("	   , BX_OFFC_RVN                             ");
		query.append("  FROM MV                                      ");
		query.append(" WHERE DEL_YN = ?                              ");
		query.append("   AND MV_ID = ?                               ");
//		List<MvVO> movieList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = dbConnection.prepareStatement(query.toString());
			// ?에 들어갈 값 할당
			pstmt.setString(1, "N");
			pstmt.setString(2, mvId);
			rs = pstmt.executeQuery();
			MvVO mvVO = null;
			// ResultSet의 Row를 처음부터 끝까지 반복시킨다.
			while (rs.next()) {
				mvVO = new MvVO();
				// 현재 반복 중인 Row에서 각 칼럼들의 값을 추출한다.
				// 추출한 값을 MvVO에게 할당해준다.
				mvVO.setMvId(rs.getString("MV_ID"));
				mvVO.setTtl(rs.getString("TTL"));
				mvVO.setMvRtng(rs.getString("MV_RTNG"));
				mvVO.setRnngTm(rs.getInt("RNNG_TM"));
				mvVO.setSmmr(rs.getString("SMMR"));
				mvVO.setRlsDt(rs.getString("RLS_DT"));
				mvVO.setMainPstrUrl(rs.getString("MAIN_PSTR_URL"));
				mvVO.setFbUrl(rs.getString("FB_URL"));
				mvVO.setXUrl(rs.getString("X_URL"));
				mvVO.setInstaUrl(rs.getString("INSTA_URL"));
				mvVO.setTgln(rs.getString("TGLN"));
				mvVO.setOrgnlTtl(rs.getString("ORGNL_TTL"));
				mvVO.setPlyng(rs.getString("PLYNG"));
				mvVO.setOrgnlLngg(rs.getString("ORGNL_LNGG"));
				mvVO.setBdgt(rs.getLong("BDGT"));
				mvVO.setBxOffcRvn(rs.getLong("BX_OFFC_RVN"));
				// MvVO를 List<MvVO>에게 추가한다.
//				movieList.add(mvVO);
				return mvVO;
			}
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다", sqle);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqle) {
				}
			}
		}
//		movieList.forEach(System.out::println);
		return null;
	}

	public static List<GnrVO> selectGenre(String mvId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException("ojdbc 드라이버가 발견되지 않았습니다.", cnfe);
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "TMDB";
		String userPassword = "TMDB";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, userPassword);
			System.out.println(conn.getSchema());
		} catch (SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.", sqle);
		}
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.GNR_ID          ");
		query.append("	 , G.NM                ");
		query.append("  FROM GNR G             ");
		query.append(" INNER JOIN MV_GNR MG    ");
		query.append(" 	ON G.GNR_ID = MG.GNR_ID");
		query.append(" WHERE MG.MV_ID = ?      ");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GnrVO> genreList = new ArrayList<>();
		GnrVO genre = null;
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, mvId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				genre = new GnrVO();
				genre.setGnrId(rs.getString("GNR_ID"));
				genre.setNm(rs.getString("NM"));
				genreList.add(genre);
			}
			return genreList;
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다", sqle);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static List<MvVO> selectMovieOf(String gnrId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException("ojdbc 드라이버가 발견되지 않았습니다.", cnfe);
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "TMDB";
		String userPassword = "TMDB";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, userPassword);
			System.out.println(conn.getSchema());
		} catch (SQLException sqle) {
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.", sqle);
		}
		StringBuffer query = new StringBuffer();
		query.append("SELECT M.MV_ID                                ");
		query.append("	 , M.TTL                                    ");
		query.append("	 , M.MV_RTNG                                ");
		query.append("	 , M.RNNG_TM                                ");
		query.append("	 , M.SMMR                                   ");
		query.append("	 , TO_CHAR(M.RLS_DT, 'YYYY-MM-DD') AS RLS_DT");
		query.append("	 , M.MAIN_PSTR_URL                          ");
		query.append("	 , M.FB_URL                                 ");
		query.append("	 , M.X_URL                                  ");
		query.append("	 , M.INSTA_URL                              ");
		query.append("	 , M.TGLN                                   ");
		query.append("	 , M.ORGNL_TTL                              ");
		query.append("	 , M.PLYNG                                  ");
		query.append("	 , M.ORGNL_LNGG                             ");
		query.append("	 , M.BDGT                                   ");
		query.append("	 , M.BX_OFFC_RVN                            ");
		query.append("  FROM MV M                                   ");
		query.append(" INNER JOIN MV_GNR MG                         ");
		query.append(" 	ON M.MV_ID = MG.MV_ID                       ");
		query.append(" WHERE DEL_YN = 'N'                           ");
		query.append("   AND MG.GNR_ID = ?                          ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, gnrId);
			rs = pstmt.executeQuery();
			List<MvVO> movieList = new ArrayList<>();
			MvVO movie = null;
			while (rs.next()) {
				movie = new MvVO();
				movie.setMvId(rs.getString("MV_ID"));
				movie.setTtl(rs.getString("TTL"));
//				movie.setMvRtng(rs.getString("MV_RTNG"));
//				movie.setRnngTm(rs.getInt("RNNG_TM"));
//				movie.setSmmr(rs.getString("SMMR"));
//				movie.setRlsDt(rs.getString("RLS_DT"));
//				movie.setMainPstrUrl(rs.getString("MAIN_PSTR_URL"));
//				movie.setFbUrl(rs.getString("FB_URL"));
//				movie.setxUrl(rs.getString("X_URL"));
//				movie.setInstaUrl(rs.getString("INSTA_URL"));
//				movie.setTgln(rs.getString("TGLN"));
//				movie.setOrgnlTtl(rs.getString("ORGNL_TTL"));
//				movie.setPlyng(rs.getString("PLYNG"));
//				movie.setOrgnlLngg(rs.getString("ORGNL_LNGG"));
//				movie.setBdgt(rs.getLong("BDGT"));
//				movie.setBxOffcRvn(rs.getLong("BX_OFFC_RVN"));
				movieList.add(movie);
			}
			return movieList;
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다.", sqle);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void main(String[] args) {
//		MvVO movie = selectMovie("1-spider-man-brand-new-day");
//		System.out.println(movie);
		List<GnrVO> genreList = selectGenre("1-spider-man-brand-new-day");
		System.out.println(genreList);
		List<MvVO> movieList = selectMovieOf("3-adventure");
		System.out.println(movieList.toString().replaceAll("\\], ", "],\n"));
	}
}
