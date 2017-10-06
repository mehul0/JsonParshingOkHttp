package com.mehul.jsonparshing.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mehul.jsonparshing.R;
import com.mehul.jsonparshing.fragment.FragmentMain;
import com.mehul.jsonparshing.task.TaskService;

public class MainActivity extends AppCompatActivity implements FragmentMain.FragmentMainEvent {

    FragmentMain mFragmentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loadMainFragment();
        new TaskService(this).execute("https://jsonplaceholder.typicode.com/posts/1");
    }

    public void loadMainFragment(){

        mFragmentMain = (FragmentMain) getSupportFragmentManager().findFragmentByTag(FragmentMain.TAG);

        if (mFragmentMain == null){
            mFragmentMain = new FragmentMain();

            showFragment(mFragmentMain,FragmentMain.TAG);
            /*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, mFragmentMain, FragmentMain.TAG)
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();*/
        }

        /*mFragmentMain = new FragmentMain();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, mFragmentMain, FragmentMain.TAG)
                .addToBackStack(FragmentMain.TAG)
                .commit();*/

    }

    @Override
    public void FragmentMainEventClick() {

    }

    public void showFragment(Fragment fragment, String fragmentTag) {

        //fragmentManager.beginTransaction()
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, fragmentTag)
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
