package com.eomcs.lucene.lucene;

import java.io.File;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class SearchTest {
	
	// 필드명 : 값
	// 반환해야 할는 갯수
	// 소트필드 : asc|desc
	
	public static void main(String[] args) throws Exception{
		
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("C:\\Temp\\new_news")));
		
		IndexSearcher searcher = new IndexSearcher(reader);
		
		BooleanQuery bquery = new BooleanQuery();
		Query query = new TermQuery(new Term("TITLE", "오늘"));
		bquery.add(query, Occur.MUST);
		
//		Query query1 = new TermQuery(new Term("TITLE", "오늘"));
//		bquery.add(query1, Occur.MUST_NOT);
//		
//		NumericRangeQuery<Integer> query2 = NumericRangeQuery.newIntRange(
//				"DATE", 20200901, 20200930, true, true);
//		bquery.add(query2, Occur.MUST);
//		
		Sort sort = new Sort(new SortField("DATE", Type.INT, true));
				
		TopDocs tds = searcher.search(bquery, 10, sort);
		// TopFieldDocs tfds = searcher.search(bquery, 10, sort);
		long totalcount = tds.totalHits;
		System.out.println("total document = " + totalcount);
		ScoreDoc[] sds = tds.scoreDocs;
		
		for(int i =0; i < sds.length; i++) {
			float score = sds[i].score;
			if (Float.isNaN(score)) {
				score = 0;
			}
			int docid = sds[i].doc;
			Document doc = reader.document(docid);
			String title = doc.get("TITLE");
			String content = doc.get("DATE");
			System.out.println(score + "\t" + title + "\t" + content);
		}
		reader.close();
	}
}
