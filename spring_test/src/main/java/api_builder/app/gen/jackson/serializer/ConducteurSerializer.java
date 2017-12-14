package api_builder.app.gen.jackson.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Conducteur;
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.model.Voiture;
import api_builder.app.gen.model.VoitureRoue;

public class ConducteurSerializer extends StdSerializer<Conducteur> {

	public JsonSerializer<Object> defaultSerializer;

	public ConducteurSerializer() {
		this(null);
	}

	public ConducteurSerializer(Class<Conducteur> t) {
		super(t);
	}

	@Override
	public void serialize(Conducteur cond, JsonGenerator jg, SerializerProvider sp) throws IOException {
		System.out.println("Conducteur serializer view :" + sp.getActiveView());
		if(sp.getActiveView().equals(Views.ConducteurView.class)) {
			defaultSerializer.serialize(cond, jg, sp);
		}else {
			jg.writeString("/coducteur/id/" + cond.getIdconducteur());
		}
	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}
