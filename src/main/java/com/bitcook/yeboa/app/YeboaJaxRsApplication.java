package com.bitcook.yeboa.app;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

import com.bitcook.yeboa.app.filters.AuthorizationFilter;
import com.bitcook.yeboa.app.mappers.JacksonJsonCollectionMapper;

/**
 * Registers the components to be used by the JAX-RS application
 * 
 * @author richmond
 * 
 */
public class YeboaJaxRsApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public YeboaJaxRsApplication() {
		
        packages("com.bitcook.yeboa.app");
        
//		// register application resources
//		register(PodcastsResource.class);
//		register(PodcastLegacyResource.class);
//
//		// register filters
//		register(RequestContextFilter.class);
//		register(LoggingResponseFilter.class);
//		register(CORSResponseFilter.class);
//
//		// register exception mappers
//		register(GenericExceptionMapper.class);
//		register(AppExceptionMapper.class);
//      register(CustomReasonPhraseExceptionMapper.class);
//		register(NotFoundExceptionMapper.class);
//
//		// register features
		//register(JacksonFeature.class);
		//register(Jackson2ObjectMapperBuilder.class);
		register(EntityFilteringFeature.class);
		register(JacksonJsonCollectionMapper.class);
		register(AuthorizationFilter.class);
		EncodingFilter.enableFor(this, GZipEncoder.class);		
//		property(EntityFilteringFeature.ENTITY_FILTERING_SCOPE, new Annotation[] {PodcastDetailedView.Factory.get()});
	}
}
