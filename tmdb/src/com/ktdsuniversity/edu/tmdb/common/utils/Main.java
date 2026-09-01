package com.ktdsuniversity.edu.tmdb.common.utils;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class Main {

	public static void main(String[] args) {
		DBConnector dbConn = DBConnector.builder()
										.setDriverClassName("oracle.jdbc.driver.OracleDriver")
										.setUrl("jdbc:oracle:thin:@localhost:1521:XE")
										.setSchemaName("TMDB")
										.setPassword("TMDB")
										.connect();

		String query = " SELECT BDGT as bbggddtt, BX_OFFC_RVN as rvn, MV_ID, TTL, SMMR, MV_RTNG, RLS_DT, MAIN_PSTR_URL, X_URL FROM MV WHERE MV_ID = ? ";
		MvVO mv = dbConn.selectBuilder(MvVO.class, query)
						.setParams(pstmt -> {
							pstmt.setString(1, "1-spider-man-brand-new-day");
						})
						.addRenameColumn("bbggddtt", "BDGT")
						.addRenameColumn("rvn", "BX_OFFC_RVN")
						.selectOne();
		dbConn.close();
		System.out.println(mv);


	}
}