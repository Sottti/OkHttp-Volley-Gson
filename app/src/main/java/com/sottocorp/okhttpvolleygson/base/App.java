package com.sottocorp.okhttpvolleygson.base;

import android.app.Application;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.sottocorp.okhttpvolleygson.others.LruBitmapCache;
import com.sottocorp.okhttpvolleygson.others.OkHttpStack;
import com.squareup.okhttp.OkHttpClient;

/**
 * Global application singleton instance.
 */
public class App extends Application
{
    // Singleton application sInstance
    private static App sInstance;

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

        sInstance = this;
    }

    /**
     * @return the application singleton instance
     */
    public static App getInstance()
    {
        return sInstance;
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
     * @param request to be added to the Volley requests queue
     */
    private static void addRequest(@NonNull final Request<?> request)
    {
        getInstance().getVolleyRequestQueue().add(request);
    }

    /**
     * Adds a request to the Volley request queue with a given tag
     *
     * @param request is the request to be added
     * @param tag tag identifying the request
     */
    public static void addRequest(@NonNull final Request<?> request, @NonNull final String tag)
    {
        request.setTag(tag);
        addRequest(request);
    }

    /**
     * Cancels all the request in the Volley queue for a given tag
     *
     * @param tag associated with the Volley requests to be cancelled
     */
    public static void cancelAllRequests(@NonNull final String tag)
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
            mLruBitmapCache = new LruBitmapCache(sInstance);
        }
        return mLruBitmapCache;
    }

}
