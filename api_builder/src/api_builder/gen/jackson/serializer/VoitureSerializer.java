
package api_builder.gen.jackson.serializer;
import api_builder.gen.api.bean.Voiture;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.gen.jackson.Views;
import api_builder.gen.api.bean.Voiture;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.api.bean.Voiture
 * @author Hibernate Tools
 */
public class VoitureSerializer extends StdSerializer<Voiture>{

	public JsonSerializer<Object> defaultSerializer;

	public VoitureSerializer() {
		this(null);
	}

	public VoitureSerializer(Class<Voiture> t) {
		super(t);
	}

	@Override
	public void serialize(Voiture voiture, JsonGenerator jg, SerializerProvider sp) throws IOException {
		if(sp.getActiveView().equals(Views.VoitureView.class)) {
			defaultSerializer.serialize(voiture, jg, sp);
		}else {
			jg.writeString("/voiture/id/" + voiture.getIdvoiture());
		}

	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

