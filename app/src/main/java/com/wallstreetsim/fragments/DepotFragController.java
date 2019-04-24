package com.wallstreetsim.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.wallstreetsim.R;
import com.wallstreetsim.activities.MainActivity;

public class DepotFragController extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.action_myShares));
        View v = inflater.inflate(R.layout.fragment_depot, container, false);

        Button min60 = v.findViewById(R.id.min60);
        min60.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.min60:
                Ion.with(getContext())
                    .load("https://api.iextrading.com/1.0/stock/market/crypto?filter=symbol")
                    .asString()
                    .withResponse()
                    .setCallback(new FutureCallback<Response<String>>() {
                        @Override
                        public void onCompleted(Exception e, Response<String> result) {
                            // print the response code, ie, 200
                            Log.i("Response", String.valueOf(result.getHeaders().code()));
                            // print the String that was downloaded
                            Log.i("Response", result.getResult());
                        }
                    });
                Log.i("Response", "Asynchron");
                break;
            case R.id.min30:
                break;
        }

    }
}
