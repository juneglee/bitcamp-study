package com.eomcs.lucene.server;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.saltlux.edu.lucene.SearchIndex;
import com.saltlux.nrpc.AbstractHandler;
import com.saltlux.nrpc.AbstractHandlers;
import com.saltlux.nrpc.AbstractResponser;

import io.netty.handler.codec.http.HttpMethod;

public class HelloLucene extends AbstractHandler<InputParams, OutputParams> {

	private final Gson gson;

	public HelloLucene() {
		gson = new Gson();
	}

	// 127.0.0.1:8888/lucene?

	@Override
	protected InputParams unmarshalRESTRequest(HttpMethod method, String uriPath, Map<String, String> uriParams,
			Map<String, List<String>> queryParams, String httpContent) throws Exception {
		InputParams input = new InputParams();
		OutputParams output = new OutputParams();
		if (method == HttpMethod.POST) {
			input = gson.fromJson(httpContent, InputParams.class);
			return input;
		} else if (method == HttpMethod.GET) {
			try {
				List<String> plist = queryParams.get("field");
				input.field = plist.get(0);
				plist = queryParams.get("value");
				input.value = plist.get(0);
				plist = queryParams.get("sort");
				if (input.sortField == null) {
					input.sortField = "DATE";
				} else {
					input.sortField = plist.get(0);
				}
				plist = queryParams.get("sortvalue");
				if (input.sortValue  == null) {
					input.sortValue = "asc";
				} else {
					input.sortValue = plist.get(0);
				}
				plist = queryParams.get("max");
				if (queryParams.get("max") == null) {
					input.max = 10;
				} else {
					input.max = Integer.parseInt(plist.get(0));
				}
			} catch (Exception e) {
				System.out.println("error 발생");
			}

			return input;
		}
		return input;
	}


	@Override
	protected void doExecute(InputParams request, AbstractResponser<OutputParams> responser) {
		// 결과가 반환되는 부분 <-- 작업 !!
		// 이부분만 작업하면 된다.
		SearchIndex searcher = new SearchIndex();
		OutputParams output = searcher.search(request);
		responser.onResponse(output);
	}

	// 127.0.0.1:8888/hello?q=코로나
	@Override
	protected void registerHandler(AbstractHandlers handlers) {
		handlers.registerRESTHandler(HttpMethod.GET, "/lucene", this);
		handlers.registerRESTHandler(HttpMethod.POST, "/lucene", this);
	}

}
