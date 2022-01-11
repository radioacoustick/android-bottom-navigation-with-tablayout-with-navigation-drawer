package com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.radioacoustick.android_bottom_navigation_with_tablayout_with_navigation_drawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	ActivityMainBinding binding;
	private AppBarConfiguration mAppBarConfiguration;
	private DrawerLayout drawer;
	private NavController navController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		binding.appBarMain.fab.setOnClickListener(view ->
			 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				  .setAction("Action", null).show());
		drawer = binding.drawerLayout;
		BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		mAppBarConfiguration = new AppBarConfiguration.Builder(
			 R.id.nav_home, R.id.nav_dashboard, R.id.nav_notifications)
			 .setOpenableLayout(binding.drawerLayout)
			 .build();
		navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
		NavigationUI.setupWithNavController(bottomNavView, navController);
		binding.navView.setNavigationItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		return NavigationUI.navigateUp(navController, mAppBarConfiguration)
			 || super.onSupportNavigateUp();
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.menu_slideshow)
			navController.navigate(R.id.nav_slideshow);
		else if (id == R.id.menu_gallery)
			navController.navigate(R.id.nav_gallery);
		drawer.closeDrawer(GravityCompat.START);
		return false;
	}
}