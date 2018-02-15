
package api_builder.app.gen.jackson.serializer;
import api_builder.app.gen.model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.VoitureRoueId;
import java.util.Iterator;

// Generated 15 f�vr. 2018 21:56:02 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.bean.VoitureRoueId
 * @author Hibernate Tools
 */
public class VoitureRoueIdSerializer extends StdSerializer<VoitureRoueId>{

	public JsonSerializer<Object> defaultSerializer;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

	public VoitureRoueIdSerializer() {
		this(null);
	}

	public VoitureRoueIdSerializer(Class<VoitureRoueId> t) {
		super(t);
	}

	@Override
	public void serialize(VoitureRoueId voitureroueid, JsonGenerator jg, SerializerProvider sp) throws IOException {
	}
	
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}

