package com.example.shivanya;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent i=new Intent(NavigationDrawerActivity.this,ProfileDetailsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel("डॅशबोर्ड", true, false); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel("प्रोफाईल तपशील", true, true); //Menu of Java Tutorials
        headerList.add(menuModel);
        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("प्रोफाईल", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("पासवर्ड बदला", false, false);
        childModelsList.add(childModel);

        /*childModel = new MenuModel("Java FileReader", false, false);
        childModelsList.add(childModel);*/


        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("कलेक्शन यादी", true, true); //Menu of Python Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel("आजची कलेक्शन यादी", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("आजच्या कलेक्शनचा तपशील", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("आजचे कलेक्शन", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("प्रलंबित कलेक्शन", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("कलेक्शनचा तपशील", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
//msg sending
        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("संदेश", true, true); //Menu of Python Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel("संदेश  पाठवा", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("वाढदिवसाचे संदेश  पाठवा", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        /*WebView webView = findViewById(R.id.webView);
                        webView.loadUrl(headerList.get(groupPosition).url);*/
                        Toast.makeText(NavigationDrawerActivity.this, "headerlist", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (model.menuName.length() > 0) {
                        /*WebView webView = findViewById(R.id.webView);
                        webView.loadUrl(model.url);*/

                        Toast.makeText(NavigationDrawerActivity.this, "model", Toast.LENGTH_SHORT).show();

                        onBackPressed();
                }
                }

                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                /*Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                System.out.println("positon of group"+groupPosition);
                System.out.println("positon of child"+childPosition);
                if(groupPosition==1 && childPosition==0)
                {
                Intent i=new Intent(NavigationDrawerActivity.this,ProfileDetailsActivity.class);
                startActivity(i);
                finish();
                }
                if(groupPosition==1 && childPosition==1)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,ForgetPasswordActivity.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==2 && childPosition==0)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this, TodaysDetailsForCollectionActivity.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==2 && childPosition==1)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,TodaysCollectionDetails.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==2 && childPosition==2)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,TodaysCollectionActivity.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==2 && childPosition==3)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,PendingCollection.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==2 && childPosition==4)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,CollectionDetailsActivity.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==3 && childPosition==0)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,SendMsg.class);
                    startActivity(i);
                    finish();
                }
                if(groupPosition==3 && childPosition==1)
                {
                    Intent i=new Intent(NavigationDrawerActivity.this,BirthDayMsg.class);
                    startActivity(i);
                    finish();
                }
                return false;
            }
        });

    }


}
