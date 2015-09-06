package com.test.changetabview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TabTwoFragment extends Fragment implements View.OnClickListener
{
    Button btnOne, btnTwo, btnThree;
    Fragment fragmentReplacedOne;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_two_layout, container, false);

        btnOne = (Button) rootView.findViewById(R.id.btnOne);
        btnTwo = (Button) rootView.findViewById(R.id.btnTwo);
        btnThree = (Button) rootView.findViewById(R.id.btnThree);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.btnOne) {
            Toast.makeText(getActivity().getBaseContext(), "Button One Clicked", Toast.LENGTH_SHORT).show();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentReplacedOne = new ReplaceFragmentOne();

            fragmentTransaction.replace(fragmentManager.getFragments().get(1).getId(), fragmentReplacedOne, "replaced");
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
        if(v.getId() == R.id.btnTwo) {
            Toast.makeText(getActivity().getBaseContext(), "Button Two Clicked", Toast.LENGTH_SHORT).show();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentReplacedOne = new ReplaceFragmentOne();

            fragmentTransaction.replace(fragmentManager.getFragments().get(1).getId(), fragmentReplacedOne, "replaced");
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
        if(v.getId() == R.id.btnThree) {
            Toast.makeText(getActivity().getBaseContext(), "Button Three Clicked", Toast.LENGTH_SHORT).show();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentReplacedOne = new ReplaceFragmentOne();

            fragmentTransaction.replace(fragmentManager.getFragments().get(1).getId(), fragmentReplacedOne, "replaced");
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }
}
