package com.meteoru.googleimagesearch.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageResult {
    public String tbUrl;
    public String url;
    public String title;
    public int height;
    public int width;

    // new ImageResult(..raw item json..)
    public ImageResult(JSONObject json) {
        try {
            if (json.getString("tbUrl") != null) {
                this.tbUrl = json.getString("tbUrl");
            }
            if (json.getString("url") != null) {
                this.url = json.getString("url");
            }
            if (json.getString("title") != null) {
                this.title = json.getString("title");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Take an array of Json images and return an ArrayList of image objects
    // ImageResult.fromJSONArray([..., ...])
    public static ArrayList<ImageResult> fromJSONArray(JSONArray array) {
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new ImageResult(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
