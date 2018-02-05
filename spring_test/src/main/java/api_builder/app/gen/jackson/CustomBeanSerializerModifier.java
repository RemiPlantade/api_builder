package api_builder.app.gen.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import api_builder.app.gen.jackson.serializer.ConducteurSerializer;
import api_builder.app.gen.jackson.serializer.RoueSerializer;
import api_builder.app.gen.jackson.serializer.VoitureSerializer;
import api_builder.app.gen.model.Conducteur;
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.model.Voiture;

public class CustomBeanSerializerModifier extends BeanSerializerModifier {
	@Override
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
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
		if (beanDesc.getBeanClass() == Roue.class) {
			RoueSerializer ser = new RoueSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		return serializer;
	}
}
