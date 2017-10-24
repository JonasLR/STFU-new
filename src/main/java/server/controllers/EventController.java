package server.controllers;

import com.google.gson.Gson;
import com.sun.java.accessibility.util.EventID;
import server.exceptions.ResponseException;
import server.models.Event;
import server.models.Student;
import server.providers.DBmanager;
import server.endpoints.EventEndpoint;


import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import server.providers.EventTable;
import server.utility.CurrentStudentContext;

/**
 * Created by STFU on 19/10/2017
 */


public class EventController {

    /**
     * EventController klassen forbinder vores endpoints med vores providers,
     * som sender SQL statements til databasen
     */

    //Controller klasse for event. Laver kald til databasen.
    //API forbindes med database.

    EventTable eventTable = new EventTable();

    public ArrayList getAttendingStudents(String idEvent) throws IllegalAccessException {
        ArrayList attendingStudents = eventTable.getAttendingStudents(idEvent);
        return attendingStudents;
    }

    public boolean createEvent(Event eventData, Student student) throws SQLException {
        EventTable eventTable = new EventTable();
        boolean createEvent = eventTable.createEvent(eventData, student);
        return createEvent;
    }


    public ArrayList<Event> getAllEvents() {
        EventTable allEvents = new EventTable();
        return allEvents.getAllEvents();

    }

    public boolean deleteEvent(Event event) throws Exception {
        EventTable db = new EventTable();
        boolean deleteEvent = db.deleteEvent(event);
        return deleteEvent;
    }

    public boolean joinEvent(int eventId, int studentId) throws ResponseException {
        EventTable joinEvent = new EventTable();
        return joinEvent.joinEvent(eventId, studentId);
    }

    public boolean updateEvent(Event event, Student student) throws Exception {
        EventTable db = new EventTable();
        boolean updateEvent = db.updateEvent(event, student);
        return updateEvent;

    }
}

