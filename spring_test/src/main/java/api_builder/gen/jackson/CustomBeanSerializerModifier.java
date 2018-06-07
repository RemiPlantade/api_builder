package api_builder.gen.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import api_builder.gen.jackson.serializer.ConducteurSerializer;
import api_builder.gen.bean.Conducteur;
import api_builder.gen.jackson.serializer.VoitureRoueSerializer;
import api_builder.gen.bean.VoitureRoue;
import api_builder.gen.jackson.serializer.RoueSerializer;
import api_builder.gen.bean.Roue;
import api_builder.gen.jackson.serializer.VoitureSerializer;
import api_builder.gen.bean.Voiture;

// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp
@Component
public class CustomBeanSerializerModifier extends BeanSerializerModifier {
	@Override
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
		if (beanDesc.getBeanClass() == Conducteur.class) {
			ConducteurSerializer ser = new ConducteurSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		if (beanDesc.getBeanClass() == Roue.class) {
			RoueSerializer ser = new RoueSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		if (beanDesc.getBeanClass() == Voiture.class) {
			VoitureSerializer ser = new VoitureSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		return serializer;
	}
}
