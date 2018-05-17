package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //Create a list of museums

        final ArrayList<Museum> museums = new ArrayList<Museum>();

        //museum.add("one);

        museums.add(new Museum(getString(R.string.museum_title), getString(R.string.museum_address),
                getString(R.string.museum_hours), getString(R.string.museum_price),
                getString(R.string.museum_description), R.drawable.caixaforum));

        museums.add(new Museum(getString(R.string.museum_title2), getString(R.string.museum_address2),
                getString(R.string.museum_hours2), getString(R.string.museum_price2),
                getString(R.string.museum_description2), R.drawable.macba2));

        museums.add(new Museum(getString(R.string.museum_title3), getString(R.string.museum_address3),
                getString(R.string.museum_hours3), getString(R.string.museum_price3),
                getString(R.string.museum_description3), R.drawable.mnac2));

        museums.add(new Museum(getString(R.string.museum_title3), getString(R.string.museum_address3),
                getString(R.string.museum_hours3), getString(R.string.museum_price3),
                getString(R.string.museum_description3), R.drawable.cccb));

        museums.add(new Museum(getString(R.string.museum_title4), getString(R.string.museum_address4),
                getString(R.string.museum_hours4), getString(R.string.museum_price4),
                getString(R.string.museum_description4), R.drawable.museopicasso2));


        // This list item layout contains a layout of location information, that includes
        // title, address, opening hours, description and photo of the location which the adapter will
        // set to display.
        MuseumAdapter adapter = new MuseumAdapter(getActivity(), museums);
        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activity}.
        // A {@Link ListView} with the view ID called list is declared in the places_list.xml.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} created above, so that the
        // {@link ListView} will display list items for each location in the list of places.
        // Call the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to select the museum when the card is clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Send intent to new {@Link LocationDetailActivity} with details for the current selected
                // location. Currently not working.
                Intent intent = new Intent(getActivity(), MuseumDetailActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}