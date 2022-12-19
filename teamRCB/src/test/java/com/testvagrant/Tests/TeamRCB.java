package com.testvagrant.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testvagrant.data.DataReader;


public class TeamRCB extends DataReader {
	
	public JSONArray TeamRCB() throws IOException{
		JSONArray playersArray=getJsonDataToArray(System.getProperty("user.dir")+"//src//test//java//com//testvagrant//data//Team.json");
		return playersArray;
	}
	
	
	@Test(priority=1)
	public void getForeignPlayers() throws IOException {
		JSONArray playersArray = TeamRCB();
		int playerCount = 0;
		for(int i = 0; i < playersArray.length(); i++) {
			JSONObject obj = (JSONObject) playersArray.get(i);
			if(!obj.get("country").equals("India")){
				playerCount++;
			}
		}
		Assert.assertEquals(playerCount, 4);
		
	}
	
	@Test(priority=2)
	public void getWicketKeeperCount() throws IOException {	
		JSONArray playersArray = TeamRCB();
		int wicketKeeper = 0;
		for(int i = 0; i < playersArray.length(); i++) {
			JSONObject obj = (JSONObject) playersArray.get(i);
			if(obj.get("role").equals("Wicket-keeper")){
				wicketKeeper++;
			}
		}
			if(wicketKeeper >= 1) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		
	}
	
	


}
