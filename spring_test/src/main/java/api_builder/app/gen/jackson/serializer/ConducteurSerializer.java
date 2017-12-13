package api_builder.app.gen.jackson.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Conducteur;
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.model.Voiture;
import api_builder.app.gen.model.VoitureRoue;

public class ConducteurSerializer extends StdSerializer<Conducteur> {

	public JsonSerializer<Object> defaultSerializer;

	public ConducteurSerializer() {
		this(null);
	}

	public ConducteurSerializer(Class<Conducteur> t) {
		super(t);
	}

	@Override
	public void serialize(Conducteur cond, JsonGenerator jg, SerializerProvider sp) throws IOException {
		System.out.println("Conducteur serializer view :" + sp.getActiveView());
		if(sp.getActiveView().equals(Views.ConducteurView.class)) {
			Field[] fields = Conducteur.class.getDeclaredFields();
			System.out.println("Yolo !!!!" + fields.length);
			jg.writeStartObject();
			for (Field field : fields) {
				if(!field.isAccessible()) {
					Class typeField = field.getType();
					field.setAccessible(true);
					try {
						if(typeField.equals(int.class)){
							jg.writeNumberField(field.getName(), field.getInt(cond) );
						}else if(typeField.equals(double.class)){
							jg.writeNumberField(field.getName(), field.getDouble(cond) );
						}else if(typeField.equals(float.class)) {
							jg.writeNumberField(field.getName(), field.getFloat(cond) );
						}else if(typeField.equals(boolean.class)) {
							jg.writeBooleanField(field.getName(), field.getBoolean(cond));
						}else if(typeField.equals(String.class)) {
							jg.writeStringField(field.getName(), (String) field.get(cond));
						}else if(typeField.equals(Voiture.class)){
							jg.writeStringField(field.getName(),field.getName() + "/id/"+((Voiture)field.get(cond)).getIdvoiture());
						}else if(typeField.equals(Roue.class)){
							jg.writeStringField(field.getName(),field.getName() + "/id/"+((Roue)field.get(cond)).getIdroue());
						}else if(typeField.isArray()){
							jg.writeStartArray();
							for (Object obj : (Set)field.get(cond)) {
								jg.writeObject(obj);
							}
							jg.writeEndArray();
						}else {
							jg.writeObjectField(field.getName(), field.get(cond));
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
			jg.writeEndObject();
		}else {
			jg.writeString("/coducteur/id/" + cond.getIdconducteur());
		}
	}
	public void setDefaultSerializer(JsonSerializer<Object> serializer) {
		defaultSerializer = serializer;

	}
}
