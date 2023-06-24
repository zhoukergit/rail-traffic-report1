package com.example.common.config;

import com.example.common.entity.SkipWrap;
import com.example.common.entity.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author zhouke
 * RestControllerAdvice：作用：对所有控制器中，被@RequestMapping注解标注的方法，
 * 进行增强
 */
@RestControllerAdvice(basePackages = "com.example")
public class ResponseResultInterceptor<T> implements ResponseBodyAdvice<Object> {
    /**
     * 是否启动结果响应拦截，当返回为true时，表示拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //自定义了一个注解SkipWrap,有些时候不需要进行包装,如进行RPC时
        if (returnType.getMethodAnnotation(SkipWrap.class) != null) {
            return false;
        }
        //  getGenericParameterType获取到的type带有泛型,建议使用getNestedParameterType
        return !returnType.getNestedParameterType().equals(R.class);
    }

    /**
     * 被拦截的响应，立即执行该方法。
     * body ：是请求控制器方法接口后，响应的内容。
     * 仅封装成功的返回,失败的返回请走统一异常处理
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // String类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            // 将数据包装在ResultVo里后转换为json串进行返回
            try {
                return objectMapper.writeValueAsString(R.success(body));
            } catch (JsonProcessingException e) {
                // 这里正常应该加如自定义的统一异常处理
                e.printStackTrace();
            }
        }
        return R.success(body);
    }


}