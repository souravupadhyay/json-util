/**
 * JSONUtil - Json Utility
 * @author souravupadhyay
 */

package com.wah.util.json;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public final class JSONUtil {

  /**
   * Convert JSONObject to Map<String, Object>
   * @param JSONObject
   * @return Map
   * @author souravupadhyay
   */
  public static Map<String, Object> toMap(JSONObject object) throws JSONException {
    Map<String, Object> map = new HashMap<String, Object>();
    if(object == JSONObject.NULL)
      return map;
    Iterator<String> keysItr = object.keys();
    while(keysItr.hasNext()) {
      String key = keysItr.next();
      Object value = object.get(key);
      if(value instanceof JSONArray)
        value = toList((JSONArray) value);
      else if(value instanceof JSONObject)
        value = toMap((JSONObject) value);
      map.put(key, value);
    }
    return map;
  }

  /**
   * Convert JSONArray to List
   * @param JSONArray
   * @return List
   * @author souravupadhyay
   */
  public static List<Object> toList(JSONArray array) throws JSONException {
    List<Object> list = new ArrayList<Object>();
    for(int i = 0; i < array.length(); i++)
      list.add(array.get(i));
    return list;
  }

}
