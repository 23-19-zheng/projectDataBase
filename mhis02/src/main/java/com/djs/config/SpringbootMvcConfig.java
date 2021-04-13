package com.djs.config;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.djs.interceptor.SystemInterceptor;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class SpringbootMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Date>() {
            @SneakyThrows
            @Override
            public Date convert(String s) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date parse;
				try {
					parse = sdf.parse(s);
					return parse;
				} catch (ParseException e) {
					e.printStackTrace();
				}
               return null;
            }
        });
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor in = new SystemInterceptor();
        registry.addInterceptor(in)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/upload");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT")
                .maxAge(3600);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	 //1、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //2、添加fastjson的配置信息 
        FastJsonConfig config = new FastJsonConfig();      
        config.setCharset(Charset.forName("UTF-8"));
        config.setDateFormat("yyyy-MM-dd");
        config.setSerializerFeatures(
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );
      //3、在convert中添加配置信息
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }
}
