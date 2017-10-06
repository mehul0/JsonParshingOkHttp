package com.mehul.jsonparshing.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mehul.jsonparshing.R;

/**
 * Created by Micky on 10/5/2017.
 */

public class FragmentMain extends Fragment implements View.OnClickListener {

    public static final String TAG = "MainFragment";

    FragmentMainEvent mFragmentMainEvent;

    public interface FragmentMainEvent{
        void FragmentMainEventClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mFragmentMainEvent = (FragmentMainEvent) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mFragmentMainEvent = (FragmentMainEvent) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv;

        tv = view.findViewById(R.id.tv);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mFragmentMainEvent = null;
    }

    @Override
    public void onClick(View view) {

    }
}
