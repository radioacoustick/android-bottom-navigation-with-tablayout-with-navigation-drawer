package com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.R;


public class SlideshowFragment extends Fragment {

	public SlideshowFragment() {
		// Required empty public constructor
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
									 ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_slideshow, container, false);
		TextView textView = rootView.findViewById(R.id.text_slideshow);
		textView.setText(getString(R.string.menu_slideshow));
		return rootView;
	}

}