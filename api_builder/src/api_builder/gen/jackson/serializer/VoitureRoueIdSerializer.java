
package api_builder.gen.jackson.serializer;
import api_builder.gen.api.bean.VoitureRoueId;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.gen.jackson.Views;
import api_builder.gen.api.bean.VoitureRoueId;

// Generated 7 févr. 2018 16:17:49 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.gen.api.bean.VoitureRoueId
 * @author Hibernate Tools
 */
public class VoitureRoueIdSerializer extends StdSerializer<VoitureRoueId>{

	public JsonSerializer<Object> defaultSerializer;

	public VoitureRoueIdSerializer() {
		this(null);
	}

	public VoitureRoueIdSerializer(Class<VoitureRoueId> t) {
		super(t);
	}

	@Override
	public void serialize(VoitureRoueId voitureroueid, JsonGenerator jg, SerializerProvider sp) throws IOException {
		defaultSerializer.serialize(voitureroueid, jg, sp);

	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

