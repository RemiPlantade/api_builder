
package api_builder.jackson.serializer;
import api_builder.bean.Roue;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.jackson.Views;
import api_builder.bean.Roue;

// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class Roue.
 * @see api_builder.bean.Roue
 * @author Hibernate Tools
 */
public class RoueSerializer extends StdSerializer<Roue>{

	public JsonSerializer<Object> defaultSerializer;

	public RoueSerializer() {
		this(null);
	}

	public RoueSerializer(Class<Roue> t) {
		super(t);
	}

	@Override
	public void serialize(Roue roue, JsonGenerator jg, SerializerProvider sp) throws IOException {
		if(sp.getActiveView().equals(Views.RoueView.class)) {
			defaultSerializer.serialize(roue, jg, sp);
		}else {
			jg.writeString("/roue/id/" + roue.getIdroue());
		}

	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

