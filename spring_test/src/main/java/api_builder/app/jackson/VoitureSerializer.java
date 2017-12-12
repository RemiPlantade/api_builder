package api_builder.app.jackson;

import java.io.IOException;
import java.lang.reflect.Field;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.model.Voiture;

public class VoitureSerializer extends StdSerializer<Voiture> {

	public JsonSerializer<Object> defaultSerializer;

	public VoitureSerializer() {
		this(null);
	}

	public VoitureSerializer(Class<Voiture> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Voiture voit, JsonGenerator jg, SerializerProvider sp) throws IOException {
		if(sp.getActiveView().equals(Views.VoitureView.class)) {
//			Field[] fields = Voiture.class.getDeclaredFields();
//			System.out.println("Yolo !!!!" + fields.length);
//			jg.writeStartObject();
//			for (Field field : fields) {
//				if(!field.isAccessible()) {
//					Class typeField = field.getType();
//					field.setAccessible(true);
//					try {
//						if(typeField.equals(int.class)){
//							jg.writeNumberField(field.getName(), field.getInt(voit) );
//						}else if(typeField.equals(double.class)){
//							jg.writeNumberField(field.getName(), field.getDouble(voit) );
//						}else if(typeField.equals(float.class)) {
//							jg.writeNumberField(field.getName(), field.getFloat(voit) );
//						}else if(typeField.equals(boolean.class)) {
//							jg.writeBooleanField(field.getName(), field.getBoolean(voit));
//						}else if(typeField.equals(String.class)) {
//							jg.writeStringField(field.getName(), (String) field.get(voit));
//						}else {
//							jg.writeObject(field.get(voit));
//						}
//					} catch (IllegalArgumentException | IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			jg.writeEndObject();
			defaultSerializer.serialize(voit, jg, sp);
		}else {
			jg.writeString("/voiture/id/" + voit.getIdvoiture());
		}
	}


	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;
		
	}
	

}
