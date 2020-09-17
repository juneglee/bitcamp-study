package com.eomcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class search {

  public class NewsInfo {
    StringBuilder createDate = new StringBuilder();
    StringBuilder title = new StringBuilder();
    StringBuilder content = new StringBuilder();
  }
  
  public void create(String filename) throws Exception {
	File file = new File("news_sample2.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
    
    String line = null;
    NewsInfo info = null;
    int contentCase = -1;
    while((line = reader.readLine()) != null) {
      line = line.trim();
      
      if (line.length() == 0) {
        continue;
      }
      
      if (line.equals("<CREATE_DATE>")) {
        writeJson(info);
        info = new NewsInfo();
        contentCase = 1;
      } else if (line.equals("<TITLE>")) {
        contentCase = 2;
      } else if (line.equals("<CONTENT>")) {
        contentCase = 3;
      } else {
        if (contentCase == 1) {
          info.createDate.append(line);
        } else if (contentCase == 2) {
          info.title.append(line);
        } else {
          info.content.append(line).append(' ');
        }
      }
    }
    writeJson(info);
    
    reader.close();
  }
  
  public void writeJson(NewsInfo info) {
    if (info == null) {
      return;
    }
  }

}
