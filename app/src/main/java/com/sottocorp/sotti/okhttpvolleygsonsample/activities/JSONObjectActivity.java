package com.sottocorp.sotti.okhttpvolleygsonsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sottocorp.sotti.okhttpvolleygsonsample.R;
import com.sottocorp.sotti.okhttpvolleygsonsample.api.ApiRequest;
import com.sottocorp.sotti.okhttpvolleygsonsample.api.GsonRequest;
import com.sottocorp.sotti.okhttpvolleygsonsample.base.App;
import com.sottocorp.sotti.okhttpvolleygsonsample.dataModel.DummyObject;

/**
 * Demonstrates how to make a JSON Object request
 *
 * @author https://plus.google.com/+PabloCostaTirado/about
 */
public class JSONObjectActivity extends AppCompatActivity
{
    private TextView mTitle, mBody;
    private static final String mTAG = "TagOne";

    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_object_request);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);

        final GsonRequest<DummyObject> gsonRequest = ApiRequest.getDummyObject
                (new Response.Listener<DummyObject>()
                 {
                     @Override
                     public void onResponse(DummyObject dummyObject)
                     {
                         // Deal with the DummyObject here
                         mProgressBar.setVisibility(View.GONE);
                         mContent.setVisibility(View.VISIBLE);
                         setData(dummyObject);
                     }
                 }
                        ,
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                // Deal with the error here
                                mProgressBar.setVisibility(View.GONE);
                                mErrorView.setVisibility(View.VISIBLE);
                            }
                        }
                );

        App.addRequest(gsonRequest, mTAG);
    }

    @Override
    protected void onStop()
    {
        App.cancelAllRequests(mTAG);

        super.onStop();
    }

    /**
     * Sets the data in the UI
     *
     * @param dummyObject is the object to get the data from
     */
    private void setData(DummyObject dummyObject)
    {
        mTitle.setText(dummyObject.getTitle());
        mBody.setText(dummyObject.getBody());
    }
}
