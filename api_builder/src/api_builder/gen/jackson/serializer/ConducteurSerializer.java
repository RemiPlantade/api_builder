
package api_builder.gen.jackson.serializer;
import api_builder.gen.api.bean.Conducteur;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.gen.jackson.Views;
import api_builder.gen.api.bean.Conducteur;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.api.bean.Conducteur
 * @author Hibernate Tools
 */
public class ConducteurSerializer extends StdSerializer<Conducteur>{

	public JsonSerializer<Object> defaultSerializer;

	public ConducteurSerializer() {
		this(null);
	}

	public ConducteurSerializer(Class<Conducteur> t) {
		super(t);
	}

	@Override
	public void serialize(Conducteur conducteur, JsonGenerator jg, SerializerProvider sp) throws IOException {
		if(sp.getActiveView().equals(Views.ConducteurView.class)) {
			defaultSerializer.serialize(conducteur, jg, sp);
		}else {
			jg.writeString("/conducteur/id/" + conducteur.getIdconducteur());
		}

	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

