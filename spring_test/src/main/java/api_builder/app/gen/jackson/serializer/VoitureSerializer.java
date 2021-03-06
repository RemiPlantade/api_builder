package api_builder.app.gen.jackson.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Voiture;

public class VoitureSerializer extends StdSerializer<Voiture> {

	public JsonSerializer<Object> defaultSerializer;

	public VoitureSerializer() {
		this(null);
	}

	public VoitureSerializer(Class<Voiture> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Voiture voit, JsonGenerator jg, SerializerProvider sp) throws IOException {
		System.out.println("Voiture serializer view :" + sp.getActiveView());
		if(sp.getActiveView() == Views.VoitureView.class) {
			defaultSerializer.serialize(voit, jg, sp);
		}else {
			jg.writeString("/voiture/id/" + voit.getIdvoiture());
		}
	}


	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;
		
	}
	

}
