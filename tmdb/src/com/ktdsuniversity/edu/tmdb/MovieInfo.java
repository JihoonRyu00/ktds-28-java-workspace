package com.ktdsuniversity.edu.tmdb;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.bckgrnd.vo.BckgrndVO;
import com.ktdsuniversity.edu.tmdb.common.utils.DBConnector;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.kywrd.vo.KywrdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;
import com.ktdsuniversity.edu.tmdb.pstr.vo.PstrVO;
import com.ktdsuniversity.edu.tmdb.str.vo.StrVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

public class MovieInfo {

	private DBConnector connector;

	public MovieInfo() {
		this.connector = DBConnector.builder().setDriverClassName("oracle.jdbc.driver.OracleDriver")
				.setUrl("jdbc:oracle:thin:@localhost:1521:XE").setSchemaName("TMDB").setPassword("TMDB").connect();
	}

	public MvVO selectMovie(String mvId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT MV_ID                                   ");
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
		query.append(" WHERE DEL_YN = 'N'                            ");
		query.append("   AND MV_ID = ?                               ");

		return this.connector.selectBuilder(MvVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, mvId)) //
				.selectOne();
	}

	public void setGenres(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.GNR_ID            ");
		query.append("	   , G.NM                ");
		query.append("  FROM GNR G               ");
		query.append(" INNER JOIN MV_GNR MG      ");
		query.append(" 	  ON G.GNR_ID = MG.GNR_ID");
		query.append(" WHERE MG.MV_ID = ?        ");
		List<GnrVO> genreList = this.connector.selectBuilder(GnrVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setGnrList(genreList);
	}

	public void setKeywords(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT K.KYWRD_ID              ");
		query.append("	   , k.KYWRD                 ");
		query.append("  FROM MV_KYWRD MK             ");
		query.append(" INNER JOIN KYWRD K            ");
		query.append("    ON MK.KYWRD_ID = K.KYWRD_ID");
		query.append(" WHERE MK.MV_ID = ?            ");
		List<KywrdVO> keywordList = this.connector.selectBuilder(KywrdVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setKywrdList(keywordList);
	}

	public void setVideos(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT VD_ID    ");
		query.append("     , URL      ");
		query.append("  FROM VD       ");
		query.append(" WHERE MV_ID = ?");
		List<VdVO> keywordList = this.connector.selectBuilder(VdVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setVdList(keywordList);
	}

	public void setBackgrounds(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT BCKGRND_ID");
		query.append("     , URL       ");
		query.append("  FROM BCKGRND   ");
		query.append(" WHERE MV_ID = ? ");
		List<BckgrndVO> keywordList = this.connector.selectBuilder(BckgrndVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setBckgrndList(keywordList);
	}

	public void setPosters(MvVO movie) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT PSTR_ID  ");
		query.append("     , URL      ");
		query.append("  FROM PSTR     ");
		query.append(" WHERE MV_ID = ?");
		List<PstrVO> keywordList = this.connector.selectBuilder(PstrVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setPstrList(keywordList);
	}

	public void setCasts(MvVO movie) {
		final StringBuffer query = new StringBuffer();
		query.append("SELECT STR_ID   ");
		query.append("	   , MV_ID    ");
		query.append("	   , INVLVD_ID");
		query.append("	   , RL       ");
		query.append("  FROM STR      ");
		query.append(" WHERE MV_ID = ?");
		List<StrVO> strList = this.connector.selectBuilder(StrVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setStrList(strList);

		query.delete(0, query.length());
		query.append("SELECT INVLVD_ID    ");
		query.append("	   , PRFL_URL     ");
		query.append("	   , NM           ");
		query.append("  FROM INVLVD       ");
		query.append(" WHERE INVLVD_ID = ?");
		strList.forEach(str -> {
			// 람다 함수 내부에서는 외부의 지역 변수를 사용할 수 없다.
			// 람다 함수 내부에서 사용할 수 있는 것: 람다 내부의 지역 변수, 람다 외부의 상수, 멤버 변수
			InvlvdVO involved = this.connector.selectBuilder(InvlvdVO.class, query) //
					.setParams(pstmt -> pstmt.setString(1, str.getInvlvdId())) //
					.selectOne();
			str.setInvlvdVO(involved);
		});
	}

	public void setFilmmakers(MvVO movie) {
		final StringBuffer query = new StringBuffer();
		query.append("SELECT FLMMKR_ID");
		query.append("	   , MV_ID    ");
		query.append("	   , INVLVD_ID");
		query.append("	   , PRT      ");
		query.append("	   , RL       ");
		query.append("  FROM FLMMKR   ");
		query.append(" WHERE MV_ID = ?");
		List<FlmmkrVO> flmmkrList = this.connector.selectBuilder(FlmmkrVO.class, query) //
				.setParams(pstmt -> pstmt.setString(1, movie.getMvId())) //
				.selectList();
		movie.setFlmmkrList(flmmkrList);

		query.delete(0, query.length());
		query.append("SELECT INVLVD_ID    ");
		query.append("	   , PRFL_URL     ");
		query.append("	   , NM           ");
		query.append("  FROM INVLVD       ");
		query.append(" WHERE INVLVD_ID = ?");
		flmmkrList.forEach(str -> {
			InvlvdVO involved = this.connector.selectBuilder(InvlvdVO.class, query) //
					.setParams(pstmt -> pstmt.setString(1, str.getInvlvdId())) //
					.selectOne();
			str.setInvlvdVO(involved);
		});
	}

	public static void main(String[] args) {
		MovieInfo movieInfo = new MovieInfo();

		MvVO movie = movieInfo.selectMovie("10-deadpool");
		System.out.println(movie);

		movieInfo.setGenres(movie);
		System.out.println(movie.getGnrList().toString().replaceAll("\\], ", "],\n"));

		movieInfo.setKeywords(movie);
		System.out.println(movie.getKywrdList().toString().replaceAll("\\], ", "],\n"));
		movieInfo.setVideos(movie);
		System.out.println(movie.getVdList().toString().replaceAll("\\], ", "],\n"));
		movieInfo.setBackgrounds(movie);
		System.out.println(movie.getBckgrndList().toString().replaceAll("\\], ", "],\n"));
		movieInfo.setPosters(movie);
		System.out.println(movie.getPstrList().toString().replaceAll("\\], ", "],\n"));

		movieInfo.setCasts(movie);
		System.out.println(movie.getStrList().toString().replaceAll("\\], ", "],\n"));
		movie.getStrList().forEach(str -> {
			System.out.println(str.getInvlvdVO());
		});

		movieInfo.setFilmmakers(movie);
		System.out.println(movie.getFlmmkrList().toString().replaceAll("\\], ", "],\n"));
		movie.getFlmmkrList().forEach(str -> {
			System.out.println(str.getInvlvdVO());
		});

		movieInfo.connector.close();
	}
}
