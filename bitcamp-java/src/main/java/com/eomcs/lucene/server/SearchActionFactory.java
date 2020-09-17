package com.eomcs.lucene.server;

import com.saltlux.nrpc.AbstractHandlers;

public class SearchActionFactory extends AbstractHandlers {
	
	public SearchActionFactory() {
		registerHandler(new HelloLucene());
	}
}
