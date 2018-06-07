package api_builder.gen.jackson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

import api_builder.gen.bean.Conducteur;
import api_builder.gen.bean.Roue;
import api_builder.gen.bean.Voiture;
import api_builder.gen.jackson.deserializer.ConducteurDeserializer;
import api_builder.gen.jackson.serializer.RoueSerializer;
import api_builder.gen.jackson.serializer.VoitureSerializer;
import api_builder.gen.service.VoitureService;

// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp
@Component
public class CustomBeanDeserializerModifier extends BeanDeserializerModifier {
	@Autowired
	private ConducteurDeserializer conductDeser;

	@Override
	public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc,
			JsonDeserializer<?> deserializer) {
		if (beanDesc.getBeanClass() == Conducteur.class) {
			return conductDeser;
		}
//		if (beanDesc.getBeanClass() == Roue.class) {
//			RoueSerializer deser = new RoueSerializer();
//			deser.setDefaultSerializer((JsonSerializer<Object>)deserializer);
//			return deser;
//		}
//		if (beanDesc.getBeanClass() == Voiture.class) {
//			VoitureSerializer deser = new VoitureSerializer();
//			deser.setDefaultSerializer((JsonSerializer<Object>)deserializer);
//			return deser;
//		}
		return deserializer;
	}

}
