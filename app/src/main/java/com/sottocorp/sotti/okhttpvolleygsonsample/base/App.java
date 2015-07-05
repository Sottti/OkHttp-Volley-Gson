package com.sottocorp.sotti.okhttpvolleygsonsample.base;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.sottocorp.sotti.okhttpvolleygsonsample.others.LruBitmapCache;
import com.sottocorp.sotti.okhttpvolleygsonsample.others.OkHttpStack;
import com.squareup.okhttp.OkHttpClient;

/**
 * Global application singleton mInstance.
 *
 * @author https://plus.google.com/+PabloCostaTirado/about
 */
public class App extends Application
{
    // Singleton application mInstance
    private static App mInstance;

    // Volley request queue
    private RequestQueue mRequestQueue;

    // Volley image cache
    private LruBitmapCache mLruBitmapCache;

    // Volley image loader
    private ImageLoader mImageLoader;

    @Override
    public void onCreate()
    {
        super.onCreate();

        mInstance = this;
    }

    /**
     * Returns the application instance
     *
     * @return the application instance
     */
    public static App getInstance()
    {
        return mInstance;
    }

    /**
     * Returns a Volley request queue for creating network requests
     *
     * @return {@link com.android.volley.RequestQueue}
     */
    public RequestQueue getVolleyRequestQueue()
    {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(this, new OkHttpStack(new OkHttpClient()));
        }
        return mRequestQueue;
    }

    /**
     * Adds a request to the Volley request queue
     *
     * @param request is the request to add to the Volley queue
     */
    public static void addRequest(Request<?> request)
    {
        getInstance().getVolleyRequestQueue().add(request);
    }

    /**
     * Adds a request to the Volley request queue with a given tag
     *
     * @param request is the request to be added
     * @param tag tag identifying the request
     */
    public static void addRequest(Request<?> request, String tag)
    {
        request.setTag(tag);
        addRequest(request);
    }

    /**
     * Cancels all the request in the Volley queue for a given tag
     *
     * @param tag associated with the Volley requests to be cancelled
     */
    public static void cancelAllRequests(String tag)
    {
        if (getInstance().getVolleyRequestQueue() != null)
        {
            getInstance().getVolleyRequestQueue().cancelAll(tag);
        }
    }

    /**
     * Returns an image loader instance to be used with Volley.
     *
     * @return {@link com.android.volley.toolbox.ImageLoader}
     */
    public ImageLoader getVolleyImageLoader()
    {
        if (mImageLoader == null)
        {
            mImageLoader = new ImageLoader
                    (
                            getVolleyRequestQueue(),
                            App.getInstance().getVolleyImageCache()
                    );
        }

        return mImageLoader;
    }

    /**
     * Returns a bitmap cache to use with volley.
     *
     * @return {@link LruBitmapCache}
     */
    private LruBitmapCache getVolleyImageCache()
    {
        if (mLruBitmapCache == null)
        {
            mLruBitmapCache = new LruBitmapCache(mInstance);
        }
        return mLruBitmapCache;
    }

}
