package com.ecommerce.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;

public class DataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
		
		config.getExposureConfiguration()
				.forDomainType(Product.class)
					.withItemExposure((metaData, httpMethod) -> httpMethod.disable(theUnsupportedActions))
					.withCollectionExposure((metaData, httpMethod) -> httpMethod.disable(theUnsupportedActions));
		
		config.getExposureConfiguration()
				.forDomainType(ProductCategory.class)
					.withItemExposure((metaData, httpMethod) -> httpMethod.disable(theUnsupportedActions))
					.withCollectionExposure((metaData, httpMethod) -> httpMethod.disable(theUnsupportedActions));
	}
}
