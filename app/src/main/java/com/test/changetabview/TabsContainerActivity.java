package com.test.changetabview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;

public class TabsContainerActivity extends FragmentActivity
{
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabs_container);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId)
            {
                android.support.v4.app.FragmentManager fragmentManager =   getSupportFragmentManager();
                TabOneFragment tabOneFragment = (TabOneFragment) fragmentManager.findFragmentByTag("Tab 1");
                TabTwoFragment tabTwoFragment = (TabTwoFragment) fragmentManager.findFragmentByTag("Tab 2");
                ReplaceFragmentOne tabReplacedFragment =  (ReplaceFragmentOne) fragmentManager.findFragmentByTag("replaced");
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(tabOneFragment != null)
                    fragmentTransaction.detach(tabOneFragment);

                if(tabTwoFragment != null)
                    fragmentTransaction.detach(tabTwoFragment);

                if(tabReplacedFragment != null)
                    fragmentTransaction.detach(tabReplacedFragment);

                if(tabId.equalsIgnoreCase("Tab 1"))
                {
                    if(tabOneFragment ==null)
                    {
                        fragmentTransaction.add(R.id.realtabcontent,new TabOneFragment(), "Tab 1");
                    }
                    else
                    {
                        fragmentTransaction.attach(tabOneFragment);
                    }
                }
                else
                {
                    if(tabTwoFragment == null)
                    {
                        fragmentTransaction.add(R.id.realtabcontent,new TabTwoFragment(), "Tab 2");
                    }
                    else
                    {
                        if(tabReplacedFragment != null){
                            //fragmentTransaction.remove(tabReplacedFragment);
                            fragmentTransaction.replace(tabReplacedFragment.getId(), new TabTwoFragment(), "Tab 2");
                        }
                        else
                            fragmentTransaction.attach(tabTwoFragment);
                    }
                }
                fragmentTransaction.commit();
            }
        };
        tabHost.setOnTabChangedListener(tabChangeListener);

        TabHost.TabSpec tSpecTabOne = tabHost.newTabSpec("Tab 1");
        tSpecTabOne.setIndicator("Tab 1");
        tSpecTabOne.setContent(new TabFactory(getBaseContext()));
        tabHost.addTab(tSpecTabOne);

        TabHost.TabSpec tSpecTabTwo = tabHost.newTabSpec("Tab 2");
        tSpecTabTwo.setIndicator("Tab 2");
        tSpecTabTwo.setContent(new TabFactory(getBaseContext()));
        tabHost.addTab(tSpecTabTwo);
    }
}
