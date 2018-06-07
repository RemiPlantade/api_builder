
package api_builder.gen.jackson.serializer;
import api_builder.gen.bean.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.gen.jackson.Views;
import api_builder.gen.bean.Voiture;
import java.util.Iterator;

// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp

import java.util.Date;
import java.util.Set;

/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.bean.Voiture
 * @author Hibernate Tools
 */
public class VoitureSerializer extends StdSerializer<Voiture>{

	public JsonSerializer<Object> defaultSerializer;

	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

	public VoitureSerializer() {
		this(null);
	}

	public VoitureSerializer(Class<Voiture> t) {
		super(t);
	}

	@Override
	public void serialize(Voiture voiture, JsonGenerator jg, SerializerProvider sp) throws IOException {
		jg.writeStartObject();
		if(voiture.getId() == null){
			jg.writeNullField("id");
		}else{
			jg.writeNumberField("id",  voiture.getId());
		}
		if(voiture.getConducteur() == null){
			jg.writeNullField("conducteur");
		}else{
			jg.writeNumberField("conducteur",  voiture.getConducteur().getId());
		}
		if(voiture.getMarque() == null){
			jg.writeNullField("marque");
		}else{
			jg.writeStringField("marque",  voiture.getMarque());
		}
		if(voiture.getImmat() == null){
			jg.writeNullField("immat");
		}else{
			jg.writeStringField("immat",  voiture.getImmat());
		}
		if(voiture.getDatecircul() == null){
			jg.writeNullField("datecircul");
		}else{
			jg.writeStringField("datecircul",format.format(voiture.getDatecircul()));
		}
		if(voiture.getVoitureRoues() == null){
			jg.writeNullField("voitureRoues");
		}else{
			jg.writeArrayFieldStart("voitureRoues");
			for(Iterator<VoitureRoue> iter = voiture.getVoitureRoues().iterator(); iter.hasNext(); /* NOOP */) {
				VoitureRoue voitureroue = iter.next();
				jg.writeObject(voitureroue.getId());
			}
			jg.writeEndArray();
		}
		jg.writeEndObject();
	}

	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

