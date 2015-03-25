package com.translator.util;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Json 解析类
 * @author Concise
 *
 */
public class JsonUtil {

	/**
	 * 解析翻译的Json
	 * @param jsonCode
	 * @return
	 */
	public static String transalteJson(String jsonCode){
		JSONObject obj = new JSONObject(jsonCode);
		JSONArray array = obj.getJSONArray("trans_result");
		obj = new JSONObject(array.get(0).toString());
		return obj.get("dst").toString();
	}
}
