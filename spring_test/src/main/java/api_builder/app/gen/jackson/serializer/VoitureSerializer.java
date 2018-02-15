package api_builder.app.gen.jackson.serializer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Voiture;
import api_builder.app.gen.model.VoitureRoue;

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
	public void serialize(Voiture voiture, JsonGenerator jg, SerializerProvider sp) throws IOException {
		System.out.println("Voiture serializer view :" + sp.getActiveView());
		//		if(sp.getActiveView() == Views.VoitureView.class) {
		//			defaultSerializer.serialize(voit, jg, sp);
		//		}else {
		//			jg.writeString("/voiture/id/" + voit.getId());
		//		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		jg.writeStartObject();
		jg.writeNumberField("id", voiture.getId());
		jg.writeNumberField("conducteur",voiture.getConducteur().getId());
		jg.writeStringField("marque",voiture.getMarque());
		jg.writeStringField("immat",voiture.getImmat());
		jg.writeStringField("datecircul",format.format(voiture.getDatecircul()));
		// check if voitureRoue is Set or Array 
		jg.writeArrayFieldStart("voitureRoues");
		for(Iterator<VoitureRoue> iter = voiture.getVoitureRoues().iterator(); iter.hasNext(); /* NOOP */) {
			VoitureRoue voitureroue = iter.next();
			//jg.writeNumber(voitureroue.getRoue().getId());
			jg.writeObject(voitureroue);
		}
		jg.writeEndArray();
		jg.writeEndObject();
	}


public void setDefaultSerializer(JsonSerializer<Object> serializer) {
	defaultSerializer = serializer;

}


}
