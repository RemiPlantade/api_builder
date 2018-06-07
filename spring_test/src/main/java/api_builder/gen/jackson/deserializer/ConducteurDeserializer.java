package api_builder.gen.jackson.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;

import api_builder.gen.bean.Conducteur;
import api_builder.gen.bean.Voiture;
import api_builder.gen.service.VoitureService;

@Component
public class ConducteurDeserializer extends StdDeserializer<Conducteur> {
	@Autowired
	private VoitureService voitureServ;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

	public ConducteurDeserializer() {
		this(null);
	}

	public ConducteurDeserializer(Class<Conducteur> t) {
		super(t);
	}

	@Override
	public Conducteur deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		JsonNode node = arg0.getCodec().readTree(arg0);
		Integer id = null;
		String nom = null;
		String prenom = null;
		Date age = null;
		Set<Voiture> voitures = null;
		if(node.get("id") != null) {
			id = (Integer) node.get("id").numberValue();
		}
		if(node.get("nom") != null) {
			nom = node.get("nom").asText();
		}
		if(node.get("prenom") != null) {
			prenom = node.get("prenom").asText();
		}
		if(node.get("age") != null && !node.get("age").asText().toLowerCase().equals("null")) {
			System.out.println(node.get("age").asText());
			try {
				age = format.parse(node.get("age").asText());
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}


		if(node.get("voitures") != null) {
			voitures = new HashSet<>();
			for(Iterator<JsonNode> iter = ((ArrayNode)node.get("voitures")).elements(); iter.hasNext(); /* NOOP */) {
				IntNode iterNode = (IntNode) iter.next();
				Integer voituresId = (Integer) iterNode.numberValue();
				System.out.println("Find voiture by id : " + voituresId);
				Voiture voit = voitureServ.findVoitureById(voituresId);
				voitures.add(voit);
			}
		}
		System.out.print("Voiture size : ");
		System.out.println(voitures.size());
		return new Conducteur(nom, prenom,age,voitures);
	}

}
