package pl.bugbreaker.opensusehowto;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Handler mHandler;

    private static final String TAG_00 = "home";
    private static final String TAG_01 = "gui_yast";
    private static final String TAG_02 = "gui_network";
    private static final String TAG_03 = "gui_users";
    private static final String TAG_04 = "gui_remote";
    private static final String TAG_05 = "gui_disks";
    private static final String TAG_06 = "gui_install";
    private static final String TAG_07 = "gui_custom";
    private static final String TAG_08 = "gui_gvim";
    private static final String TAG_09 = "cli_fs";
    private static final String TAG_10 = "cli_intro";
    private static final String TAG_11 = "cli_vim";
    private static final String TAG_12 = "cli_remote";
    private static final String TAG_13 = "cli_init";
    private static final String TAG_14 = "cli_process";
    private static final String TAG_15 = "cli_users";
    private static final String TAG_16 = "cli_software";
    private static final String TAG_17 = "cli_admin";
    private static final String TAG_18 = "cli_rescue";
    public static String CURR_TAG = TAG_00;

    private NavigationView navigationView;
    public int navItemIndex = 0;
    private String[] fragmentTitles;
    private boolean shouldLoadHomeOnBack = true;
    Fragment fragment;

    Utils u = Utils.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentTitles = getResources().getStringArray(R.array.nav_fragment_titles);
        mHandler = new Handler();
        navigationView = findViewById(R.id.nav_view);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURR_TAG = TAG_00;
            loadHomeFragment();
        }

    }

    public void loadHomeFragment() {
        selectNavMenu();
        setToolbarTitle();
        if (getSupportFragmentManager().findFragmentByTag(CURR_TAG) != null) {
            drawer.closeDrawers();
            return;
        }
        Log.d("FragmentTransaction","Step before transaction");

        Runnable pendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                Log.d("FragmentTransaction","Transaction began");
                fragmentTransaction.replace(R.id.frame_container, fragment, CURR_TAG);
                fragmentTransaction.commit();
                Log.d("FragmentTransaction","Transaction "+CURR_TAG+" is finished");
            }
        };

        mHandler.post(pendingRunnable);
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawers();
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                u.setItemLoaded(0);
                fragment = new HomeFragment();
                return fragment;
            case 1:
                u.setItemLoaded(1);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 2:
                u.setItemLoaded(2);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 3:
                u.setItemLoaded(3);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 4:
                u.setItemLoaded(4);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 5:
                u.setItemLoaded(5);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 6:
                u.setItemLoaded(6);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 7:
                u.setItemLoaded(7);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 8:
                u.setItemLoaded(8);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 9:
                u.setItemLoaded(9);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 10:
                u.setItemLoaded(10);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 11:
                u.setItemLoaded(11);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 12:
                u.setItemLoaded(12);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 13:
                u.setItemLoaded(13);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 14:
                u.setItemLoaded(14);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 15:
                u.setItemLoaded(15);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 16:
                u.setItemLoaded(16);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 17:
                u.setItemLoaded(17);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            case 18:
                u.setItemLoaded(18);
                new AsyncListLoad(u.getURL(),this).execute();
                fragment = new ContentFragment();
                return fragment;
            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(fragmentTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(false);
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURR_TAG = TAG_00;
                        break;
                    case R.id.gui_yast:
                        navItemIndex = 1;
                        CURR_TAG = TAG_01;
                        break;
                    case R.id.gui_network:
                        navItemIndex = 2;
                        CURR_TAG = TAG_02;
                        break;
                    case R.id.gui_users:
                        navItemIndex = 3;
                        CURR_TAG = TAG_03;
                        break;
                    case R.id.gui_remote:
                        navItemIndex = 4;
                        CURR_TAG = TAG_04;
                        break;
                    case R.id.gui_disks:
                        navItemIndex = 5;
                        CURR_TAG = TAG_05;
                        break;
                    case R.id.gui_install:
                        navItemIndex = 6;
                        CURR_TAG = TAG_06;
                        break;
                    case R.id.gui_custom:
                        navItemIndex = 7;
                        CURR_TAG = TAG_07;
                        break;
                    case R.id.gui_gvim:
                        navItemIndex = 8;
                        CURR_TAG = TAG_08;
                        break;
                    case R.id.cli_fs:
                        navItemIndex = 9;
                        CURR_TAG = TAG_09;
                        break;
                    case R.id.cli_intro:
                        navItemIndex = 10;
                        CURR_TAG = TAG_10;
                        break;
                    case R.id.cli_vim:
                        navItemIndex = 11;
                        CURR_TAG = TAG_11;
                        break;
                    case R.id.cli_remote:
                        navItemIndex = 12;
                        CURR_TAG = TAG_12;
                        break;
                    case R.id.cli_init:
                        navItemIndex = 13;
                        CURR_TAG = TAG_13;
                        break;
                    case R.id.cli_process:
                        navItemIndex = 14;
                        CURR_TAG = TAG_14;
                        break;
                    case R.id.cli_users:
                        navItemIndex = 15;
                        CURR_TAG = TAG_15;
                        break;
                    case R.id.cli_software:
                        navItemIndex = 16;
                        CURR_TAG = TAG_16;
                        break;
                    case R.id.cli_admin:
                        navItemIndex = 17;
                        CURR_TAG = TAG_17;
                        break;
                    case R.id.cli_rescue:
                        navItemIndex = 18;
                        CURR_TAG = TAG_18;
                        break;
                }
                loadHomeFragment();

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeOnBack) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURR_TAG = TAG_00;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
