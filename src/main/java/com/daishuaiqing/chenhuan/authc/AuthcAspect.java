package com.daishuaiqing.chenhuan.authc;

import com.alibaba.fastjson.JSONObject;
import com.daishuaiqing.chenhuan.cache.LocalCache;
import com.daishuaiqing.chenhuan.util.HttpContextUtils;
import com.daishuaiqing.chenhuan.vo.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AuthcAspect {
	@Autowired
	LocalCache localCache;

	//切面使用的注解
	@Pointcut("@annotation(com.daishuaiqing.chenhuan.authc.RequiresAuthc)")
		public void authcPointCut() {
	}

	//切面拦截的方法需要进行的处理
	@Around("authcPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		//检查是否登录
		if(!checkAuthc(point)){
			HttpServletResponse response = HttpContextUtils.getHttpServletResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			CommonResult commonResult = new CommonResult().unauthorized("token失效或未登录");
			out.append(JSONObject.toJSONString(commonResult));
			out.flush();
			out.close();
			return null;
		}else{
			Object result = point.proceed();
			return result;
		}
	}

	//授权验证方法
	private boolean checkAuthc(ProceedingJoinPoint joinPoint) {
		//MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		//Method method = signature.getMethod();
		//RequiresAuthc requiresAuthc = method.getAnnotation(RequiresAuthc.class);
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String token = request.getHeader("token");
		if(token == null){
			return false;
		}
		if(localCache.getValue(token)!=null){
			return true;
		}else{
			return false;
		}
	}

	//获得请求头信息
	private Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
}
