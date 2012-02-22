package org.agmip.util;

/**
 * Simple JSON converter using Jackson
 */

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.agmip.core.types.*;
import org.agmip.core.types.weather.WeatherData;

public class JSONAdapter {
  public ObjectMapper mapper = new ObjectMapper();
  
  public JSONAdapter(){};
  
  public AdvancedHashMap<String,Object> fromJSON(String json) throws IOException {
    Map<String, Object> d = mapper.readValue(json, Map.class);
    AdvancedHashMap<String,Object> data = new AdvancedHashMap<String,Object>();
    for(String key: d.keySet()) {
      Map d2 = (Map) d.get(key);
      for(Object k: d2.keySet()) {
        data.put((String)k, d2.get(k));
      }
    }
    return data;
  }
  
  public AdvancedHashMap<String,Object> exportRecord(Map r) {
    AdvancedHashMap<String,Object> d = new AdvancedHashMap<String,Object>();
    d.put(r);
    return d;
  }
  
  public String toJSON(Object obj) throws IOException {
    return mapper.writeValueAsString(obj);
  }
}