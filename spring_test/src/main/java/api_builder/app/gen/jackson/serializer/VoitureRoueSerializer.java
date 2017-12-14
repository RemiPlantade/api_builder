package api_builder.app.gen.jackson.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Conducteur;
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.model.Voiture;
import api_builder.app.gen.model.VoitureRoue;

public class VoitureRoueSerializer extends StdSerializer<VoitureRoue> {

	public JsonSerializer<Object> defaultSerializer;

	public VoitureRoueSerializer() {
		this(null);
	}

	public VoitureRoueSerializer(Class<VoitureRoue> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(VoitureRoue voit, JsonGenerator jg, SerializerProvider sp) throws IOException {
		System.out.println("Voiture serializer view :" + sp.getActiveView());
		if(isDefaultSerializer(sp.getDefaultNullKeySerializer())) {
			System.out.println(" ===== VoitureRoue Serializer Default Serializer");
		}
		if(sp.getActiveView() == Views.VoitureRoueView.class) {
			defaultSerializer.serialize(voit, jg, sp);
		}else {
			jg.writeString("/voitureRoue/id/" + voit.getId());
		}
	}


	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;
		
	}
	

}
