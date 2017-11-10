package com.framework.automation.cucumber.run;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.skyscreamer.jsonassert.JSONAssert;

import com.framework.automation.cucumber.utilities.HttpUtil;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import com.framework.automation.cucumber.utilities.TestDataCsvReader;

public class Running {

	private final static String JSON_DATA = "{" + "  \"geodata\": [" + "    {" + "      \"id\": \"1\","
			+ "      \"name\": \"Julie Sherman\"," + "      \"gender\" : \"female\","
			+ "      \"latitude\" : \"37.33774833333334\"," + "      \"longitude\" : \"-121.88670166666667\"" + "    },"
			+ "    {" + "      \"id\": \"2\"," + "      \"name\": \"Johnny Depp\"," + "      \"gender\" : \"male\","
			+ "      \"latitude\" : \"37.336453\"," + "      \"longitude\" : \"-121.884985\"" + "    }" + "  ]" + "}";

	private static final String jsonFilePath = System.getProperty("user.dir")
			+ "/src/main/resources/testdata/example/jsonTestFile.json";

	public static void main(final String[] argv) throws Exception {
		// final JSONObject obj = new JSONObject(JSON_DATA);
		// final JSONArray geodata = obj.getJSONArray("geodata");
		// final int n = geodata.length();
		// for (int i = 0; i < n; ++i) {
		// final JSONObject person = geodata.getJSONObject(i);
		// System.out.println(person.getInt("id"));
		// System.out.println(person.getString("name"));
		// System.out.println(person.getString("gender"));
		// System.out.println(person.getDouble("latitude"));
		// System.out.println(person.getDouble("longitude"));
		// }

		// TestDataCsvReader.log.info(TestDataCsvReader.loadBusinessObjectFromCsv("testdata/example/hopperTest.csv",
		// "hopper", ""));

		//////////////////////////////////////////////////////
		
//		FileReader reader = new FileReader(jsonFilePath);
//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//
//		// get a String from the JSON object
//		long id = (long) jsonObject.get("id");
//		String firstName = (String) jsonObject.get("firstname");
//		JSONArray lang = (JSONArray) jsonObject.get("languages");
//
//		System.out.println("The id is: " + id);
//		System.out.println("The first name is: " + firstName);
//		for (int i = 0; i < lang.size(); i++) {
//			System.out.println("The " + i + " element is: " + lang.get(i));
//		}
//
//		Iterator i = lang.iterator();
//
//		// take each value from the json array separately
//		while (i.hasNext()) {
//			JSONObject innerObj = (JSONObject) i.next();
//			System.out.println("language " + innerObj.get("lang") +
//					" with level " + innerObj.get("knowledge"));
//		}
//
//		// handle a structure into the json object
//		JSONObject structure = (JSONObject) jsonObject.get("job");
//		System.out.println("Into job structure, name: " + structure.get("name"));

		
//		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
//		String actual =   "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
//		//JSONAssert.assertEquals(expected, actual, false);
//		
//		String test1= "{name:\"Joe\", id:1}";
//		String test2= "{id:1,name:\"Joe\"}";
//		JsonParser parser = new JsonParser();
//		JsonElement o1 = parser.parse(test1);
//		JsonElement o2 = parser.parse(test2);
//		System.out.println(o1.equals(o2));

		String urlStr = "https://openapi.youdao.com/api";

		HttpUtil util = new HttpUtil();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("q", "good");
		params.put("salt", "1496238482428");
		params.put("sign", "02E15CDAF871B698FE04EE32FD2CF155");
		params.put("from", "en");
		params.put("appKey", "7743eee7f7e11d75");
		params.put("to", "zh-CHS");

		String resultPost = util.httpPost(urlStr, params);
		String resultGet = util.httpGet(urlStr, params);
		System.out.println(resultPost);
		System.out.println(resultGet);

		JsonParser parser = new JsonParser();
		JsonElement o1 = parser.parse(resultPost);
		JsonElement o2 = parser.parse(resultGet);
		System.out.println(o1.equals(o2));


	}
	
	
	
	
}
