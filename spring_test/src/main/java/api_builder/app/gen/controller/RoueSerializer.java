
package api_builder.app.gen.controller;
import api_builder.app.gen.model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Roue;
import java.util.Iterator;

// Generated 15 f�vr. 2018 21:56:02 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp

import java.util.Set;

/**
 * Home object for domain model class Roue.
 * @see api_builder.bean.Roue
 * @author Hibernate Tools
 */
public class RoueSerializer extends StdSerializer<Roue>{

	public JsonSerializer<Object> defaultSerializer;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

	public RoueSerializer() {
		this(null);
	}

	public RoueSerializer(Class<Roue> t) {
		super(t);
	}

	@Override
	public void serialize(Roue roue, JsonGenerator jg, SerializerProvider sp) throws IOException {
		jg.writeStartObject();
				jg.writeNumberField("id",  roue.getId());
				
				
				
				if(roue.getRayon() == null){
					jg.writeNullField("rayon");
				}else{
				jg.writeNumberField("rayon",  roue.getRayon());
				
				
				
				}
				if(roue.getLargeur() == null){
					jg.writeNullField("largeur");
				}else{
				jg.writeNumberField("largeur",  roue.getLargeur());
				
				
				
				}
			if(roue.getVoitureRoues() == null){
				jg.writeNullField("voitureRoues");
			}else{
				jg.writeArrayFieldStart("voitureRoues");
				for(Iterator<VoitureRoue> iter = roue.getVoitureRoues().iterator(); iter.hasNext(); /* NOOP */) {
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

