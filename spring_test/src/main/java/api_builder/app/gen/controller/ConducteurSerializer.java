
package api_builder.app.gen.controller;
import api_builder.app.gen.model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Conducteur;
import java.util.Iterator;

// Generated 15 f�vr. 2018 21:56:02 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp

import java.util.Date;
import java.util.Set;

/**
 * Home object for domain model class Conducteur.
 * @see api_builder.bean.Conducteur
 * @author Hibernate Tools
 */
public class ConducteurSerializer extends StdSerializer<Conducteur>{

	public JsonSerializer<Object> defaultSerializer;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

	public ConducteurSerializer() {
		this(null);
	}

	public ConducteurSerializer(Class<Conducteur> t) {
		super(t);
	}

	@Override
	public void serialize(Conducteur conducteur, JsonGenerator jg, SerializerProvider sp) throws IOException {
		jg.writeStartObject();
				jg.writeNumberField("id",  conducteur.getId());
				
				
				
				if(conducteur.getNom() == null){
					jg.writeNullField("nom");
				}else{
				
				jg.writeStringField("nom",  conducteur.getNom());
				
				
				}
				if(conducteur.getPrenom() == null){
					jg.writeNullField("prenom");
				}else{
				
				jg.writeStringField("prenom",  conducteur.getPrenom());
				
				
				}
				if(conducteur.getAge() == null){
					jg.writeNullField("age");
				}else{
					jg.writeStringField("age",format.format(conducteur.getAge()));
				}
			if(conducteur.getVoitures() == null){
				jg.writeNullField("voitures");
			}else{
				jg.writeArrayFieldStart("voitures");
				for(Iterator<Voiture> iter = conducteur.getVoitures().iterator(); iter.hasNext(); /* NOOP */) {
					Voiture voiture = iter.next();
					jg.writeObject(voiture.getId());
				}
				jg.writeEndArray();
			}
		jg.writeEndObject();
	}
	
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

