package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataReader {
	public List<HashMap<String, String>> geJsonDataToMap() throws IOException {
		//FilUtils coming from commons.io package
		//read json toString
		String f=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//resources//utilities//purchaseOrder.json"), StandardCharsets.UTF_8);
		//String to HashMap Json Databind
		//add jar jackson-databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(f, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
	}
}
