package com.letz.databus;

import android.media.metrics.Event;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class fragment extends Fragment
{

    TextView comingMessage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment, container, false);
        comingMessage = view.findViewById(R.id.textView);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessages(Messages messages)
    {
        comingMessage.setText(""+messages.message);
    }

    // subscribe this entire fragment to the Event Bus

    // 1st onStart
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override // unsubscribe
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();

    }
}