package com.eomcs.lucene.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class indexTest {

	//색인 관리하기 : IndexWriter
  public static IndexWriterConfig createConfig() throws IOException {
    WhitespaceAnalyzer analyzer = new WhitespaceAnalyzer(); // <=> stardardAnalyzer
    IndexWriterConfig wconf = new IndexWriterConfig(Version.LATEST, analyzer);
    wconf.setOpenMode(OpenMode.CREATE_OR_APPEND);
    return wconf;
  }
  
  public static void main(String[] args) throws Exception {
     IndexWriter writer = new IndexWriter(FSDirectory.open(new File("C:\\Temp\\news")), createConfig());
     
     ///
     Document doc = new Document();
     
     // 필드를 채우기
     // text, string, int 각각 확인
     // 분류하는 데이터를 사용하여 필드를 채우기 
     doc.add(new TextField("CONTENT", "내일은 조금 쉬울려나 ....", Store.YES));
     doc.add(new TextField("TITLE", "내일 강의가 힘들어요", Store.YES));
     doc.add(new StringField("ID", "23424", Store.YES));
     doc.add(new IntField("DATE", 20200920, Store.YES));
     
     writer.addDocument(doc);
     ///
     
     writer.close();
  }
}
