/**
 * 
 */
package com.slashandpair.datastructures;

import org.json.JSONObject;

import lombok.Data;

@Data
public class ClickData {
	private String positionX;
	private String positionY;
	
	public ClickData(String positionX, String positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public ClickData (String json){
		JSONObject jsonObj = new JSONObject(json);
		this.positionX = (String) jsonObj.get("positionX");
		this.positionY = (String) jsonObj.get("positionY");
	}
	
	public String convertDataInJson(){
		String jsonString = new JSONObject()
		.put("typeData", "ClickData")
	    .put("positionX", this.positionX)
	    .put("positionY", this.positionY).toString();
	    return jsonString;
	}	
}