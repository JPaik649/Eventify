package com.example.eventproject;

import java.util.ArrayList;
import java.util.List;

/* The point of this is because this needs to be local
 * If I left it in Post.java, it would be on firebase, causing
 * issues for people who haven't signed up not being able to.
 * I put the main thing of this class in MainActivity for easier updates
 */

public class AttendingEvent {

    public List<String> events;

    public AttendingEvent() {
        events = new ArrayList<String>();
    }

    public void addEvent(String name) {
        events.add(name);
    }

    public boolean checkEvent(String name) {
        for(int i = 0; i < events.size(); i++) {
            if(name.equals(events.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void removeEvent(String name) {
        for(int i = 0; i < events.size(); i++) {
            if(name.equals(events.get(i))) {
                events.remove(i);
                break;
            }
        }
    }
}
