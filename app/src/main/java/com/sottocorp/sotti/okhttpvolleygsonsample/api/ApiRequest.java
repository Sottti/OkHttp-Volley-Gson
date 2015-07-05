package com.sottocorp.sotti.okhttpvolleygsonsample.api;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
     * @return a dummy object
     */
    public static GsonRequest<DummyObject> getDummyObject
    (
            Response.Listener<DummyObject> listener,
            Response.ErrorListener errorListener
    )
    {
        final String url = "http://www.mocky.io/v2/55973508b0e9e4a71a02f05f";

        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(DummyObject.class, new DummyObjectDeserializer())
                .create();

        return new GsonRequest<>
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
     * @return an dummy object's array
     */
    public static GsonRequest<ArrayList<DummyObject>> getDummyObjectArray
    (
            Response.Listener<ArrayList<DummyObject>> listener,
            Response.ErrorListener errorListener
    )
    {
        final String url = "http://www.mocky.io/v2/5597d86a6344715505576725";

        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(DummyObject.class, new DummyObjectDeserializer())
                .create();

        return new GsonRequest<>
                (
                        url,
                        new TypeToken<ArrayList<DummyObject>>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }
}
