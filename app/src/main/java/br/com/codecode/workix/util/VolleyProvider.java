package br.com.codecode.workix.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by felipe on 06/12/16.
 */

public class VolleyProvider {

    private static VolleyProvider mInstance;

    private RequestQueue mRequestQueue;

    private ImageLoader mImageLoader;

    private static Context context;


    private VolleyProvider(Context context) {

        VolleyProvider.context = context;

        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,

                new ImageLoader.ImageCache() {

                    private final LruCache<String, Bitmap>
                            cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized VolleyProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyProvider(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {

        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}