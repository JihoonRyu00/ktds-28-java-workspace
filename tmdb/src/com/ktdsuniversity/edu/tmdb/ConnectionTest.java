package com.ktdsuniversity.edu.tmdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "TMDB";
		String userPassword = "TMDB";

		try {
			Connection conn = DriverManager.getConnection(url, userName, userPassword);
			System.out.println(conn.getSchema());
			String query = "SELECT * FROM MV";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("MV_ID        : " + rs.getString("MV_ID"));
				System.out.println("TTL          : " + rs.getString("TTL"));
				System.out.println("MV_RTNG      : " + rs.getString("MV_RTNG"));
				System.out.println("RNNG_TM      : " + rs.getInt("RNNG_TM"));
				System.out.println("SMMR         : " + rs.getString("SMMR"));
				System.out.println("RLS_DT       : " + rs.getString("RLS_DT"));
				System.out.println("MAIN_PSTR_URL: " + rs.getString("MAIN_PSTR_URL"));
				System.out.println("FB_URL       : " + rs.getString("FB_URL"));
				System.out.println("X_URL        : " + rs.getString("X_URL"));
				System.out.println("INSTA_URL    : " + rs.getString("INSTA_URL"));
				System.out.println("TGLN         : " + rs.getString("TGLN"));
				System.out.println("ORGNL_TTL    : " + rs.getString("ORGNL_TTL"));
				System.out.println("PLYNG        : " + rs.getString("PLYNG"));
				System.out.println("ORGNL_LNGG   : " + rs.getString("ORGNL_LNGG"));
				System.out.println("BDGT         : " + rs.getString("BDGT"));
				System.out.println("BX_OFFC_RVN  : " + rs.getString("BX_OFFC_RVN"));
				System.out.println("DEL_YN       : " + rs.getString("DEL_YN"));

				System.out.println("-".repeat(20));
			}
			System.out.println();
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}
}
