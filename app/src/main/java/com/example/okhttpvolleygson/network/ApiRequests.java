package com.example.okhttpvolleygson.network;

import android.support.annotation.NonNull;

import com.android.volley.Response;
import com.example.okhttpvolleygson.dataModel.DummyObject;
import com.example.okhttpvolleygson.dataModel.DummyObjectDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sottocorp.okhttpvolleygson.BuildConfig;

import java.util.ArrayList;

public class ApiRequests
{
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(DummyObject.class, new DummyObjectDeserializer())
            .create();

    public static GsonGetRequest<DummyObject> getDummyObject
    (
            @NonNull final Response.Listener<DummyObject> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        final String url = BuildConfig.apiDomainName + "/v2/55973508b0e9e4a71a02f05f";

        return new GsonGetRequest<>
                (
                        url,
                        new TypeToken<DummyObject>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }

    public static GsonGetRequest<ArrayList<DummyObject>> getDummyObjectArray
    (
            @NonNull final Response.Listener<ArrayList<DummyObject>> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        final String url = BuildConfig.apiDomainName + "/v2/5597d86a6344715505576725";

        return new GsonGetRequest<>
                (
                        url,
                        new TypeToken<ArrayList<DummyObject>>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }


    public static GsonPostRequest getDummyObjectArrayWithPost
    (
            @NonNull final Response.Listener<DummyObject> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        final String url = BuildConfig.apiDomainName + "/dummyPath";

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "Ficus");
        jsonObject.addProperty("surname", "Kirkpatrick");

        final JsonArray squareGuys = new JsonArray();
        final JsonObject dev1 = new JsonObject();
        final JsonObject dev2 = new JsonObject();
        dev1.addProperty("name", "Jake Wharton");
        dev2.addProperty("name", "Jesse Wilson");
        squareGuys.add(dev1);
        squareGuys.add(dev2);

        jsonObject.add("squareGuys", squareGuys);

        final GsonPostRequest gsonPostRequest = new GsonPostRequest<>
                (
                        url,
                        jsonObject.toString(),
                        new TypeToken<DummyObject>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );

        gsonPostRequest.setShouldCache(false);

        return gsonPostRequest;
    }
}
