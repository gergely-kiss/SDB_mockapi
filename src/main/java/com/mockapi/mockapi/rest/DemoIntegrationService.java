package com.mockapi.mockapi.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@Service
public class DemoIntegrationService
{
    @Value("${server.port}")
    private String serverPort;


    public String callDemoApi()
    {
        String url = "http://localhost:" + serverPort + AppConstants.DEMO_URL;
        JSONObject responseJSONObject = new JSONObject(
            new RestTemplate().getForEntity(url, String.class).getBody());
        Set<JSONObjectWithTypeAndId> jsonObjectsFinalKeys = new HashSet<>();
        findAllKeysWithValues(responseJSONObject, null, jsonObjectsFinalKeys);
        return jsonObjectsFinalKeys.toString();
    }

    public void findAllKeysWithValues(Object object, String key,
                                      Set<JSONObjectWithTypeAndId> findAllKeysWithValues)
    {
        if (object instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject) object;
            jsonObject.keySet().forEach(childKey -> {
                findAllKeysWithValues(jsonObject.get(childKey),
                    key != null ? key + "." + childKey : childKey,
                    findAllKeysWithValues);
            });
        } else if (object instanceof JSONArray)
        {
            JSONArray jsonArray = (JSONArray) object;
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put(key, jsonArray);
            findAllKeysWithValues.add(JSONObjectWithTypeAndId.builder().
                jsonObject(jsonObject1).dataType(DataType.ARRAY).build());
            IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::get)
                .forEach(jsonObject -> findAllKeysWithValues(jsonObject, key,
                    findAllKeysWithValues));
        } else
        {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put(key, object);
            findAllKeysWithValues.add(JSONObjectWithTypeAndId.builder().
                jsonObject(jsonObject1).dataType(DataType.OBJECT).build());
        }
    }

 /*   public void findAllKeys(Object object, String key, Set<String> finalKeys)
    {
        if (object instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject) object;
            jsonObject.keySet().forEach(childKey -> {
                findAllKeys(jsonObject.get(childKey),
                    key != null ? key + "." + childKey : childKey, finalKeys);
            });
        } else if (object instanceof JSONArray)
        {
            JSONArray jsonArray = (JSONArray) object;
            finalKeys.add(key);

            IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::get)
                .forEach(jsonObject -> findAllKeys(jsonObject, key, finalKeys));
        } else
        {
            finalKeys.add(key);
        }
    }
*/
/*
    public void printJSON(JSONObject jsonObj)
    {
        for (Object keyObj : jsonObj.keySet())
        {
            String key = (String) keyObj;
            Object valObj = jsonObj.get(key);
            if (valObj instanceof JSONArray)
            {
                JSONArray jsonArray = (JSONArray) valObj;
                responseSum.getJsonArrayWithKeyList().add(
                    new JsonArrayWithKey(key, jsonArray));
                printJSONArray(jsonArray);
            } else if (valObj instanceof JSONObject)
            {
                JSONObject val = (JSONObject) valObj;
                responseSum.getJsonObjectList().add(new JsonObjectWithKey(val));
                printJSON(val);
            } else
            {
                responseSum.getJsonObjectList().add(
                    new JsonObjectWithKey(
                        new JSONObject().put(key, valObj.toString())));
            }
        }
    }

    public void printJSONArray(JSONArray jsonArray)
    {
        for (int i = 0; i < jsonArray.length(); i++)
        {
            printJSON(jsonArray.getJSONObject(i));
        }
    }*/
}
