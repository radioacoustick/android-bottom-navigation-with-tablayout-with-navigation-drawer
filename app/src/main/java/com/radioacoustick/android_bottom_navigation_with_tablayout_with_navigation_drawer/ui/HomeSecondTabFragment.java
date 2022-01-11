package com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.R;

public class HomeSecondTabFragment extends Fragment {

	public HomeSecondTabFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
									 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_home_second_tab, container, false);
	}
}