package com.dineshlearnings.apigateway.filters;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Configuration
public class PostFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse response = ctx.getResponse();
		logger.info("ResponseStatus: " + response.getStatus());

		try (InputStream IS = ctx.getResponseDataStream()) {
			String responseData = CharStreams.toString(new InputStreamReader(IS, CharEncoding.UTF_8));
			logger.info("Response: {}" + responseData);
			ctx.setResponseBody(responseData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
