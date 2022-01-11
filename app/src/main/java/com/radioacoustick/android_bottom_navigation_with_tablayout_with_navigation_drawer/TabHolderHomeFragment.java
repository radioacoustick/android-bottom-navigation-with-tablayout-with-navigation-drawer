package com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.ui.HomeFirstTabFragment;
import com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.ui.HomeSecondTabFragment;

public class TabHolderHomeFragment extends Fragment {

	private TabLayout tabLayout;
	private ViewPager2 viewPager;

	public TabHolderHomeFragment() {
		// Required empty public constructor
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
									 ViewGroup container, Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_home_tab_holder, container, false);
	}


	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		ViewStateAdapter viewStateAdapter = new ViewStateAdapter(this);
		viewPager = view.findViewById(R.id.viewPager2);
		viewPager.setOffscreenPageLimit(1);
		viewPager.setAdapter(viewStateAdapter);
		tabLayout = view.findViewById(R.id.tabLayout);
		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
		viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
			@Override
			public void onPageSelected(int position) {
				tabLayout.selectTab(tabLayout.getTabAt(position));
			}
		});
	}

	@SuppressWarnings("InnerClassMayBeStatic")
	private class ViewStateAdapter extends FragmentStateAdapter {

		public ViewStateAdapter(Fragment fragment) {
			super(fragment);
		}

		@NonNull
		@Override
		public Fragment createFragment(int position) {
			Fragment fragment;
			if (position == 0) {
				fragment = new HomeFirstTabFragment();
			} else {
				fragment = new HomeSecondTabFragment();
			}
			return fragment;
		}

		@Override
		public int getItemCount() {
			// Hardcoded, use lists
			return 2;
		}
	}
}