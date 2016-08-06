package com.example.okhttpvolleygson.network;

import android.support.annotation.NonNull;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

public class GsonPostRequest<T> extends JsonRequest<T>
{
    private final Gson gson;
    private final Type type;
    private final Response.Listener<T> listener;

    public GsonPostRequest
    (
            @NonNull final String url,
            @NonNull final String body,
            @NonNull final Type type,
            @NonNull final Gson gson,
            @NonNull final Response.Listener<T> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        super(Method.POST, url, body, listener, errorListener);

        this.gson = gson;
        this.type = type;
        this.listener = listener;
    }

    @Override
    protected void deliverResponse(T response)
    {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response)
    {
        try
        {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            return (Response<T>) Response.success
                    (
                            gson.fromJson(json, type),
                            HttpHeaderParser.parseCacheHeaders(response)
                    );
        }
        catch (UnsupportedEncodingException e)
        {
            return Response.error(new ParseError(e));
        }
        catch (JsonSyntaxException e)
        {
            return Response.error(new ParseError(e));
        }
    }
}
