package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //Create a list of museums

        final ArrayList<Museum> museums = new ArrayList<Museum>();

        //museum.add("one");

        museums.add(new Museum(getString(R.string.event_title), getString(R.string.event_address),
                getString(R.string.event_hours),getString(R.string.event_price),
                getString(R.string.event_description),R.drawable.swab));

        museums.add(new Museum(getString(R.string.event_title2), getString(R.string.event_address2),
                getString(R.string.event_hours2),getString(R.string.event_price2),
                getString(R.string.event_description2),R.drawable.bgweekend));

        museums.add(new Museum(getString(R.string.event_title3), getString(R.string.event_address3),
                getString(R.string.event_hours3),getString(R.string.event_price3),
                getString(R.string.event_description3),R.drawable.artphoto));

        museums.add(new Museum(getString(R.string.event_title4), getString(R.string.event_address4),
                getString(R.string.event_hours4),getString(R.string.event_price4),
                getString(R.string.event_description4),R.drawable.artlibris));

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



        return rootView;
    }
}
