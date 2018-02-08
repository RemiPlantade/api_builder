
package api_builder.jackson.serializer;
import api_builder.bean.VoitureRoue;
import api_builder.bean.VoitureRoueId;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.jackson.Views;
import api_builder.bean.VoitureRoue;

// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.bean.VoitureRoue
 * @author Hibernate Tools
 */
public class VoitureRoueSerializer extends StdSerializer<VoitureRoue>{

	public JsonSerializer<Object> defaultSerializer;

	public VoitureRoueSerializer() {
		this(null);
	}

	public VoitureRoueSerializer(Class<VoitureRoue> t) {
		super(t);
	}

	@Override
	public void serialize(VoitureRoue voitureroue, JsonGenerator jg, SerializerProvider sp) throws IOException {
		if(sp.getActiveView().equals(Views.VoitureRoueView.class)) {
			defaultSerializer.serialize(voitureroue, jg, sp);
		}else {
			jg.writeString("/voitureroue/id/" + voitureroue.getId());
		}

	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

