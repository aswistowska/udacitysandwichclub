package com.udacity.sandwichclub.utils;

import android.media.Image;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject name = sandwichJSON.getJSONObject("name");
            String mainName = name.getString("mainName");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            JSONArray alsoKnownAsJsonArray = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++){
                String currentString = alsoKnownAsJsonArray.getString(i);
                alsoKnownAs.add(currentString);
            }
            String placeOfOrigin = sandwichJSON.getString("placeOfOrigin");
            String description = sandwichJSON.getString("description");
            String image = sandwichJSON.getString("image");
            ArrayList<String> ingredients = new ArrayList<>();
            JSONArray ingredientsArray = sandwichJSON.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsArray.length(); i++) {
                String currentString = ingredientsArray.getString(i);
                ingredients.add(currentString);
            }

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
