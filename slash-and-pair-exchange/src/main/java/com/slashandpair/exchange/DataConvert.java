package com.slashandpair.exchange;

import org.json.JSONObject;

import com.slashandpair.datastructures.ClickData;
import com.slashandpair.datastructures.GyroscopeData;
import com.slashandpair.datastructures.ObjectData;

/**
 * This class serializes and deserializes the sensor data.
 * @author Carlos
 * @author Victor
 * @author Guillermo
 */
public class DataConvert {
		
	public static String mappingUserAndJson(String userId, String json){
		JSONObject jsonObj = new JSONObject(json);
		
		return jsonObj.put("userId", userId).toString();
	}
	
	public static Object mappingFromJson(String json){
		JSONObject jsonObj = new JSONObject(json);
		String userId = (String) jsonObj.get("userId");
		String type = (String) jsonObj.get("typeData");
		
		switch(type) {
			case "ClickData":
				return new ObjectData (userId, new ClickData(json).convertDataInJson());
			
			case "GyroscopeData":
				return new ObjectData (userId, new GyroscopeData(json).convertDataInJson());
		}
		
		return null;
	}
}
