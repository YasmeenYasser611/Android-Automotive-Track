package com.example.day5_threads;

import android.content.Context;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor
{
    private Context context;

    public CacheInterceptor(Context context)
    {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request request = chain.request();

        // For offline mode, try to get cached response
        if (!NetworkUtil.isNetworkAvailable(context))
        {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);

        // For online mode, cache the response for 1 hour
        if (NetworkUtil.isNetworkAvailable(context))
        {
            int maxAge = 60 * 60; // read from cache for 1 hour
            response = response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build();
        }
        else
        {
            int maxStale = 60 * 15; // tolerate 15 minutes stale
            response = response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
        return response;
    }
}