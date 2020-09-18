package com.eomcs.lucene.cluster;

import com.saltlux.dor.api.IN2TopNSearch;
import com.saltlux.dor.api.common.query.IN2Query;

public class TopNSearch {
	public static void search() {
		IN2TopNSearch searcher = new IN2TopNSearch();
		searcher.setServer("127.0.0.1", 10000);
		
		searcher.addIndex("NEWS");
		searcher.setContentField("TMS_RAW_STREAM");
		searcher.setSearchCount(200);
		searcher.setResultCount(100);
		searcher.setQuery(IN2Query.MatchingAllDocQuery()); 
		
		//여기를 날짜 별로 여러번 호출하도록 
		boolean flag = searcher.analyzeDocument();
		
		
		if (flag) {
			String[][] keywords = searcher.getSubjectInfo();
			System.out.println(keywords.length);
			for (int i = 0; i <keywords.length; i++) {
				System.out.println(keywords[i][0] + "\t" + keywords[i][1]);
			}
		}
	}
	public static void main(String[] args) {
		search();
	}
}
