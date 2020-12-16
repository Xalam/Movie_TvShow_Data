package com.xalam.movietvshowrepo.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.databinding.ActivityMainBinding;
import com.xalam.movietvshowrepo.ui.favorite.FavoriteFragment;
import com.xalam.movietvshowrepo.ui.movie.MovieFragment;
import com.xalam.movietvshowrepo.ui.tvshow.TvShowFragment;
import com.xalam.movietvshowrepo.utils.BottomNavBehavior;

public class MainActivity extends AppCompatActivity {

    final Fragment fragmentMovie = new MovieFragment();
    final Fragment fragmentTvShow = new TvShowFragment();
    final Fragment fragmentFavorite = new FavoriteFragment();
    Fragment active = fragmentMovie;
    private ActivityMainBinding binding;
    private Menu menu;
    private MenuItem menuItem;
    private boolean doubleTapParam = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        getSupportFragmentManager().beginTransaction().add(R.id.frame_main, fragmentFavorite, "3").hide(fragmentFavorite).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_main, fragmentTvShow, "2").hide(fragmentTvShow).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_main, fragmentMovie, "1").commit();
        bottomNav();

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) binding.bottomNavMain.getLayoutParams();
        layoutParams.setBehavior(new BottomNavBehavior());
    }

    private void loadFragment(Fragment active, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .hide(active)
                .show(fragment)
                .commit();
    }

    private void bottomNav() {
        menu = binding.bottomNavMain.getMenu();
        menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        binding.bottomNavMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_movie:
                        menuItem = menu.getItem(0);
                        menuItem.setChecked(true);
                        loadFragment(active, fragmentMovie);
                        active = fragmentMovie;
                        break;
                    case R.id.menu_tv_show:
                        menuItem = menu.getItem(1);
                        menuItem.setChecked(true);
                        loadFragment(active, fragmentTvShow);
                        active = fragmentTvShow;
                        break;
                    case R.id.menu_favorite:
                        menuItem = menu.getItem(2);
                        menuItem.setChecked(true);
                        loadFragment(active, fragmentFavorite);
                        active = fragmentFavorite;
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onBackPressed() {
        if (doubleTapParam) {
            super.onBackPressed();
            return;
        }

        this.doubleTapParam = true;
        Toast.makeText(this, getString(R.string.tap_again), Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleTapParam = false;
            }
        }, 2000);
    }
}