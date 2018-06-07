package api_builder.gen.jackson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;

import api_builder.gen.bean.Conducteur;
import api_builder.gen.bean.Roue;
import api_builder.gen.bean.Voiture;
import api_builder.gen.bean.VoitureRoue;
import api_builder.gen.jackson.deserializer.ConducteurDeserializer;
@Component
public class CustomHandlerInstantiator extends HandlerInstantiator {

	@Autowired
	private ConducteurDeserializer conducteurDeser;

	@Override
	public JsonDeserializer<?> deserializerInstance(DeserializationConfig config, Annotated annotated,
			Class<?> deserClass) {
		if(deserClass.equals(Voiture.class)) {
			
		}else if(deserClass.equals(VoitureRoue.class)) {

		}else if(deserClass.equals(Conducteur.class)) {
			return conducteurDeser;
		}else if(deserClass.equals(Roue.class)) {

		}
		return null;
	}

	@Override
	public KeyDeserializer keyDeserializerInstance(DeserializationConfig config, Annotated annotated,
			Class<?> keyDeserClass) {
// Return null and let the default behavior happen
		
		return null;
	}

	@Override
	public JsonSerializer<?> serializerInstance(SerializationConfig config, Annotated annotated, Class<?> serClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> config, Annotated annotated,
			Class<?> builderClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeIdResolver typeIdResolverInstance(MapperConfig<?> config, Annotated annotated, Class<?> resolverClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
