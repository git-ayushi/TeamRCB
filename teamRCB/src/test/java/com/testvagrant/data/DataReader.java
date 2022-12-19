package com.testvagrant.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	
	public JSONArray getJsonDataToArray(String filePath) throws IOException {
		
		//readFileToString will scan entire content of json file and convert it to string
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		JSONObject obj = new JSONObject(jsonContent);
		JSONArray arr = obj.getJSONArray("player");
			
		return arr;
		}

 }

