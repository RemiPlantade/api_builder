package api_builder.gen.jackson;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;

public class CustomBeanDeserializationFactory extends BeanDeserializerFactory  {
	
	private ApplicationContext applicationContext;

	

	public CustomBeanDeserializationFactory(DeserializerFactoryConfig config) {
		super(config);
		// TODO Auto-generated constructor stub
	}
	
	



}
