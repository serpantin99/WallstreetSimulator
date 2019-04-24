package com.wallstreetsim.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wallstreetsim.R;
import com.wallstreetsim.activities.MainActivity;

public class MarketFragController extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.action_market));

        return inflater.inflate(R.layout.fragment_market, container, false);
    }
}
