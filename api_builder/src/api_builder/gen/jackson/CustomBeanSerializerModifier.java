package api_builder.gen.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import api_builder.gen.jackson.serializer.VoitureRoueSerializer;
import api_builder.gen.api.bean.VoitureRoue;
import api_builder.gen.jackson.serializer.VoitureSerializer;
import api_builder.gen.api.bean.Voiture;
import api_builder.gen.jackson.serializer.RoueSerializer;
import api_builder.gen.api.bean.Roue;
import api_builder.gen.jackson.serializer.ConducteurSerializer;
import api_builder.gen.api.bean.Conducteur;

// Generated 7 févr. 2018 16:17:49 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp

public class CustomBeanSerializerModifier extends BeanSerializerModifier {
	@Override
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
		if (beanDesc.getBeanClass() == VoitureRoue.class) {
			VoitureRoueSerializer ser = new VoitureRoueSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		if (beanDesc.getBeanClass() == Voiture.class) {
			VoitureSerializer ser = new VoitureSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		if (beanDesc.getBeanClass() == Roue.class) {
			RoueSerializer ser = new RoueSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		if (beanDesc.getBeanClass() == Conducteur.class) {
			ConducteurSerializer ser = new ConducteurSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		return serializer;
	}
}
