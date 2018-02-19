
package api_builder.app.gen.jackson.serializer;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.*;

import java.util.Iterator;

// Generated 15 f�vr. 2018 21:56:02 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.bean.VoitureRoue
 * @author Hibernate Tools
 */
public class VoitureRoueSerializer extends StdSerializer<VoitureRoue>{

	public JsonSerializer<Object> defaultSerializer;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

	public VoitureRoueSerializer() {
		this(null);
	}

	public VoitureRoueSerializer(Class<VoitureRoue> t) {
		super(t);
	}

	@Override
	public void serialize(VoitureRoue voitureroue, JsonGenerator jg, SerializerProvider sp) throws IOException {
		jg.writeStartObject();
				if(voitureroue.getId() == null){
					jg.writeNullField("id");
				}else{
				
				
				
				
				}
			if(voitureroue.getRoue() == null){
				jg.writeNullField("roue");
			}else{
				jg.writeNumberField("roue",  voitureroue.getRoue().getId());
			}
			if(voitureroue.getVoiture() == null){
				jg.writeNullField("voiture");
			}else{
				jg.writeNumberField("voiture",  voitureroue.getVoiture().getId());
			}
		jg.writeEndObject();
	}
	
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

