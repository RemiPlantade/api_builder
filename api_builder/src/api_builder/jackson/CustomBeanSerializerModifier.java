package api_builder.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import api_builder.jackson.serializer.RoueSerializer;
import api_builder.bean.Roue;
import api_builder.jackson.serializer.VoitureSerializer;
import api_builder.bean.Voiture;
import api_builder.jackson.serializer.ConducteurSerializer;
import api_builder.bean.Conducteur;
import api_builder.jackson.serializer.VoitureRoueSerializer;
import api_builder.bean.VoitureRoue;

// Generated 8 févr. 2018 16:16:13 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp

public class CustomBeanSerializerModifier extends BeanSerializerModifier {
	@Override
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
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
		if (beanDesc.getBeanClass() == Conducteur.class) {
			ConducteurSerializer ser = new ConducteurSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		if (beanDesc.getBeanClass() == VoitureRoue.class) {
			VoitureRoueSerializer ser = new VoitureRoueSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		return serializer;
	}
}
