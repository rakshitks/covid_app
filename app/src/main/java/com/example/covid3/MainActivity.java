package com.example.covid3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Covid19");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //    .setAction("Action", null).show();
                String subject="Query regarding corono virus";

                Intent intent = new Intent(Intent.ACTION_SENDTO);        //if there is no attachement to it
                intent.setData(Uri.parse("mailto:"));
                Toast.makeText(MainActivity.this, "Send your query through Email", Toast.LENGTH_LONG).show();// only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ncov2019@gov.in"});  //make sure that you use new String[]{"example@gmail.com"}) because only this works
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);  //subject is included
                if (intent.resolveActivity(getPackageManager()) != null) {   //checks if intent is intialised or not so that the app does not crash
                    startActivity(intent);
                }
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                case R.id.nav_home:
                    Toast.makeText(MainActivity.this, "Live counting of covid19 cases", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(MainActivity.this,urlactivity.class);
                    startActivity(myIntent);
                    break;
                    case R.id.nav_gallery:
                        Toast.makeText(MainActivity.this, "Attach a screenshot of the Fake News", Toast.LENGTH_LONG).show();
                        Intent myIntent9 = new Intent(MainActivity.this,upload_image.class);
                        startActivity(myIntent9);
                        break;
                    case R.id.nav_send:
                        Toast.makeText(MainActivity.this, "Helpline numbers for Covid19", Toast.LENGTH_LONG).show();
                        Intent myIntent1 = new Intent(MainActivity.this,helpline.class);
                        startActivity(myIntent1);
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this, "Every small contribution will bring relief for the country to fight against Covid19", Toast.LENGTH_LONG).show();
                        Intent myIntent2 = new Intent(MainActivity.this,upi.class);
                        startActivity(myIntent2);
                        break;
                    case R.id.nav_tools:
                        Toast.makeText(MainActivity.this, "Any questions in your mind FAQs is the right place to understand", Toast.LENGTH_LONG).show();
                        Intent myIntent3 = new Intent(MainActivity.this,faq.class);
                        startActivity(myIntent3);
                        break;
                    case R.id.nav_slideshow:
                        Toast.makeText(MainActivity.this, "Predict whether you are vulnerable to corono virus or not", Toast.LENGTH_LONG).show();
                        Intent myIntent4 = new Intent(MainActivity.this,prediction.class);
                        startActivity(myIntent4);
                        break;

                    case R.id.nav_slideshow1:
                        Toast.makeText(MainActivity.this, "Beware of fake news being circulated", Toast.LENGTH_LONG).show();
                        Intent myIntent6 = new Intent(MainActivity.this,fact_checker.class);
                        startActivity(myIntent6);
                        break;
                    case R.id.nav_slideshow2:
                        Toast.makeText(MainActivity.this, "Covid19 Hospitals near me", Toast.LENGTH_LONG).show();
                        Intent myIntent7 = new Intent(MainActivity.this,hospital_help.class);
                        startActivity(myIntent7);
                        break;

                    case R.id.nav_slideshow3:
                        Toast.makeText(MainActivity.this, "Avoid going out buy Groceries online", Toast.LENGTH_LONG).show();
                        Intent myIntent8 = new Intent(MainActivity.this,shop_order.class);
                        startActivity(myIntent8);
                        break;







                }
                drawer.closeDrawers();

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
