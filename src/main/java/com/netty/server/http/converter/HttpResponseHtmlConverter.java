package com.netty.server.http.converter;

import java.io.IOException;

import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;

import com.netty.server.http.HttpServerContext;
import com.netty.server.http.message.HttpResponseMessage;
import com.netty.server.utils.Constant;

public class HttpResponseHtmlConverter extends HttpResponseConverter {
	
	private static final String HEADER_HTML_CONTENT_TYPE = "text/html; charset=%s";

	@Override
	public HttpResponse buildResponse(HttpServerContext serverContext, HttpResponseMessage bizResponse) throws IOException{

		HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, parseStatus(bizResponse,HttpResponseStatus.OK));
		
		response.setHeader(Constant.Http.HEADER_CONTENT_TYPE, String.format(HEADER_HTML_CONTENT_TYPE, Constant.Http.DEFAULT_CHARSET));

		return response;
	}

}
