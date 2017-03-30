package com.example.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteMeshConfig {
	
	@Bean
	FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new ConfigurableSiteMeshFilter() {
			//데코레이터 여러개 정의할 수도 있음 지금은 기본적인 거 1개만 있는것.
			//컨트리 메뉴에 저 주소를 데코레이터한다는 뜻 
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder.addDecoratorPath("/country/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/city/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/dept/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/emp/*", "/WEB-INF/decorators/default.jsp");
//				builder.addDecoratorPath("/xxx/*", "/WEB-INF/decorators/default.jsp");
			}
		});
//		filter.addUrlPatterns("/*");
		return filter;
	}

}
