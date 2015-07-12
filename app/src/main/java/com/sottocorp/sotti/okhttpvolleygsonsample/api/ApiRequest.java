package com.sottocorp.sotti.okhttpvolleygsonsample.api;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sottocorp.sotti.okhttpvolleygsonsample.dataModel.DummyObject;
import com.sottocorp.sotti.okhttpvolleygsonsample.dataModel.DummyObjectDeserializer;

import java.util.ArrayList;

/**
 * Request to API
 *
 * @author https://plus.google.com/+PabloCostaTirado/about
 *
 */
public class ApiRequest
{
    /**
     * Returns a dummy object
     *
     * @param listener is the listener for the correct answer
     * @param errorListener is the listener for the error response
     *
     * @return @return {@link com.sottocorp.sotti.okhttpvolleygsonsample.api.GsonGetRequest}
     */
    public static GsonGetRequest<DummyObject> getDummyObject
    (
            Response.Listener<DummyObject> listener,
            Response.ErrorListener errorListener
    )
    {
        final String url = "http://www.mocky.io/v2/55973508b0e9e4a71a02f05f";

        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(DummyObject.class, new DummyObjectDeserializer())
                .create();

        return new GsonGetRequest<>
                (
                        url,
                        new TypeToken<DummyObject>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }

    /**
     * Returns a dummy object's array
     *
     * @param listener is the listener for the correct answer
     * @param errorListener is the listener for the error response
     *
     * @return {@link com.sottocorp.sotti.okhttpvolleygsonsample.api.GsonGetRequest}
     */
    public static GsonGetRequest<ArrayList<DummyObject>> getDummyObjectArray
    (
            Response.Listener<ArrayList<DummyObject>> listener,
            Response.ErrorListener errorListener
    )
    {
        final String url = "http://www.mocky.io/v2/5597d86a6344715505576725";

        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(DummyObject.class, new DummyObjectDeserializer())
                .create();

        return new GsonGetRequest<>
                (
                        url,
                        new TypeToken<ArrayList<DummyObject>>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }


    /**
     * An example call (not used in this example app) to demonstrate how to do a Volley POST call
     * and parse the response with Gson.
     *
     * @param listener is the listener for the success response
     * @param errorListener is the listener for the error response
     *
     * @return {@link com.sottocorp.sotti.okhttpvolleygsonsample.api.GsonPostRequest}
     */
    public static GsonPostRequest getDummyObjectArrayWithPost
            (
                    Response.Listener<DummyObject> listener,
                    Response.ErrorListener errorListener
            )
    {
        final String url = "http://PostApiEndpoint";
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(DummyObject.class, new DummyObjectDeserializer())
                .create();

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
                        new TypeToken<DummyObject>()
                        {
                        }.getType(),
                        gson,
                        listener,
                        errorListener
                );

        gsonPostRequest.setShouldCache(false);

        return gsonPostRequest;
    }
}
