package ru.daliya.lab3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    HashMap<Location, Waypoint> opened = new HashMap<>();
    HashMap<Location, Waypoint> closed = new HashMap<>();
    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // TODO:  Implement.
        return opened.values().stream().min(Comparator.comparing(Waypoint::getTotalCost)).orElse(null);
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
//    Если в наборе «открытых вершин» в настоящее время нет вершины
//    для данного местоположения, то необходимо просто добавить новую вершину.
//    Если в наборе «открытых вершин» уже есть вершина для этой
//    локации, добавьте новую вершину только в том случае, если стоимость пути до
//    новой вершины меньше стоимости пути до текущей. (Убедитесь, что
//    используете не общую стоимость.) Другими словами, если путь через новую
//    вершину короче, чем путь через текущую вершину, замените текущую вершину
//    на новую

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
        Location CurrentLocation = newWP.getLocation();

        if (!opened.containsKey(CurrentLocation))
        {
            opened.put(CurrentLocation, newWP);
            return true;
        }
        else
        {
            if (newWP.getPreviousCost() < opened.get(CurrentLocation).getPreviousCost())
            {
                opened.put(CurrentLocation, newWP);
                return  true;
            }
        }

        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.

        return opened.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
        Waypoint waypoint = opened.remove(loc);
        closed.put(loc, waypoint);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        return closed.containsKey(loc);
    }
}
