package com.eomcs.lucene.lucene;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.spi.ErrorCode;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import com.saltlux.edu.server.NewsInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saltlux.edu.server.InputParams;
import com.saltlux.edu.server.OutputParams;


public class SearchIndex {
	public OutputParams search(InputParams input) {
		
		OutputParams output = new OutputParams();
		output.list = new ArrayList<>();
		
		try {
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("C:\\Temp\\new_news")));
		IndexSearcher searcher = new IndexSearcher(reader);
		
		BooleanQuery bquery = new BooleanQuery();
		try {
			Query query = new TermQuery(new Term(input.field, input.value));
			bquery.add(query, Occur.MUST);
		} catch (Exception e) {
			if (input.field == null) {
				output.errorCode = 1;
				output.errorMessage = "field 와 value 의 값이 존재 하지 않습니다. 다시 설정해주시기 바랍니다.";
			} else {
				output.errorCode = 2;
				output.errorMessage = "value의 값이 존재 하지 않습니다. 다시 설정해주시기 바랍니다.";
			}
		}
		
		Sort sort = new Sort(new SortField("DATE", Type.INT, true));
				
		TopDocs tds = searcher.search(bquery, input.max , sort);
		
		long totalcount = tds.totalHits;
		output.totalcount = totalcount;
		if (output.totalcount == 0) {
			output.errorCode = 3;
			output.errorMessage = "해당 검색 결과가 없습니다.";
		}
			
		ScoreDoc[] sds = tds.scoreDocs;

		
		for(int i =0; i < sds.length; i++) {
			float score = sds[i].score;
			if (Float.isNaN(score)) {
				score = 0;
			}
			int docid = sds[i].doc;
			Document doc = reader.document(docid);
			String title = doc.get("TITLE");
			String content = doc.get("CONTENT");
			String date = doc.get("DATE");
			String id = doc.get("ID");
			
			NewsInfo info = new NewsInfo();
			info.content = content;
			info.title = title;
			info.id = id;
			info.date = Integer.parseInt(date);
			output.list.add(info);
		}
		
		reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
}
