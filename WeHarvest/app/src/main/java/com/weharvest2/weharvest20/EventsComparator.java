package com.weharvest2.weharvest20;

import com.weharvest2.weharvest20.beans.Event;

import java.util.Comparator;

/**
 * Created by fernando on 1/12/17.
 */

public class EventsComparator implements Comparator<Event>
{
    public int compare(Event left, Event right) {
        return left.getDate().compareTo(right.getDate());
    }
}

