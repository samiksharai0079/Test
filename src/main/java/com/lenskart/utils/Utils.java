package com.lenskart.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {

	// to match the results obtaim from two different search
	public static boolean mapResultsSearch(List<String> searchResult, JSONArray apiResult) {
		int numberOfTimesValueMatched = 0;
		for (int i = 0; i < searchResult.size(); i++) {
			String searchResultName = searchResult.get(i);
			for (int j = 0; j < apiResult.length(); j++) {
				JSONObject object = apiResult.getJSONObject(j);
				String apiResultName = object.get("requiredDetail").toString();
				if (searchResultName.equals(apiResultName)) {
					numberOfTimesValueMatched++;
					break;
					}
					
			}
		}
		if (numberOfTimesValueMatched == searchResult.size())
			return true;

		return false;
	}
}
