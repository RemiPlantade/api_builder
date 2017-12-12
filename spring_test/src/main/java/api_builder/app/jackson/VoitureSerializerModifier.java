package api_builder.app.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import api_builder.app.gen.model.Voiture;

public class VoitureSerializerModifier extends BeanSerializerModifier {
	@Override
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
		if (beanDesc.getBeanClass() == Voiture.class) {
			VoitureSerializer ser = new VoitureSerializer();
			ser.setDefaultSerializer((JsonSerializer<Object>)serializer);
			return ser;
		}
		return serializer;
	}
}
