package api_builder.app.gen.jackson.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.model.Voiture;

public class RoueSerializer extends StdSerializer<Roue> {

	public JsonSerializer<Object> defaultSerializer;

	public RoueSerializer() {
		this(null);
	}

	public RoueSerializer(Class<Roue> t) {
		super(t);
	}

	@Override
	public void serialize(Roue roue, JsonGenerator jg, SerializerProvider sp) throws IOException {
		if(sp.getActiveView().equals(Views.RoueView.class)) {
			defaultSerializer.serialize(roue, jg, sp);
		}else {
			jg.writeString("/roue/id/" + roue.getIdroue());
		}
	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;
		
	}
}
