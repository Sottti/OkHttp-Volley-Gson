package com.sotti.okhttpvolleygson.base;

import android.app.Application;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.sotti.okhttpvolleygson.others.LruBitmapCache;
import com.sotti.okhttpvolleygson.others.OkHttp3Stack;

public class App extends Application {

  private static App sInstance;
  private RequestQueue mRequestQueue;
  private LruBitmapCache mLruBitmapCache;
  private ImageLoader mImageLoader;

  public static App getInstance() {
    return sInstance;
  }

  private static void addRequest(@NonNull
  final Request<?> request) {
    getInstance().getVolleyRequestQueue().add(request);
  }

  public static void addRequest(@NonNull
  final Request<?> request, @NonNull
  final String tag) {
    request.setTag(tag);
    addRequest(request);
  }

  public static void cancelAllRequests(@NonNull
  final String tag) {
    getInstance().getVolleyRequestQueue().cancelAll(tag);
  }

  @Override
  public void onCreate() {
    super.onCreate();
    sInstance = this;
  }

  @NonNull
  public RequestQueue getVolleyRequestQueue() {
    if (mRequestQueue == null) {
      mRequestQueue = Volley.newRequestQueue(this, new OkHttp3Stack());
    }

    return mRequestQueue;
  }

  @NonNull
  public ImageLoader getVolleyImageLoader() {
    if (mImageLoader == null) {
      mImageLoader = new ImageLoader
          (
              getVolleyRequestQueue(),
              App.getInstance().getVolleyImageCache()
          );
    }

    return mImageLoader;
  }

  @NonNull
  private LruBitmapCache getVolleyImageCache() {
    if (mLruBitmapCache == null) {
      mLruBitmapCache = new LruBitmapCache(sInstance);
    }

    return mLruBitmapCache;
  }

}
