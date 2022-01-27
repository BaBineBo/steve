import java.util.Collections;
import java.util.List;

public class Room {

    // each room has roomas in each other direction
    // --------------------------------------------------------------------
    private Room west;
    private Room east;
    private Room north;
    private Room south;

    // name and description of room
    // --------------------------------------------------------------------
    private String name;
    private String description;
    private boolean unlocked;
    private boolean visited = false;

    // a room must have items in it
    private List<Item> items;

    // a room might have creatures in it
    private List<Alive> creatures;

    // A way to unlock rooms
    
    // a room will maybe have people in it
    
    // constructor 
    // --------------------------------------------------------------------
    public Room(String name, String description, List<Item> items, List<Alive> creatures, boolean key){

        this.name   = name;

        this.description = description;

        this.items = items;

        this.creatures = creatures;

        this.unlocked = key;
    }

    // Chek if rooms has Items in it
    // --------------------------------------------------------------------

    // Function to add items to room, append to current list
    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    // Check if room has any items
    public boolean hasItems (){
        if( this.items == null || this.items.isEmpty()) {
            return false;
        } else if (this.items.size()>0) {
            return true;
        } else {
            return false;
        }
    }

    // Return all Items in room
    public void listItems(){
        if (this.hasItems()) {
            for(int i = 0; i < items.size(); i++){
                Item item = items.get(i);
                System.out.println("There is a/an" + item.getDescription() + " " + item.getName() + "." ); // TODO /////////////////////////////////////////////////////////////////////////////////////////////////
            }
        } else {
            System.out.println("Steve can't see any items in the room.");
        }
    }

    // Chek if rooms has living creatures in it
    // --------------------------------------------------------------------

    // function to adds creatures to a room. Append to the end of current list.
    public void addCreatures (List<Creature> creatures){
        this.creatures.addAll(creatures);
    }

    // Quick check if there are any creature in room
    public boolean isPopulated(){
        if( this.creatures == null || this.creatures.isEmpty()) {
            return false;
        } else if (this.creatures.size()>0) {
            return true;
        } else {
            return false;
        }
    }

    // List all creatures in the room
    public void listCreatures(){
        if (this.isPopulated()) {
            for(int i = 0; i < creatures.size(); i++){
                System.out.println(creatures.get(i).getName() + " is in the room.");
            }
        } else {
            System.out.println("There are no creatures in the room.");
        }
    }

    public List<Alive> getCreatures(){
        return this.creatures;
    }

    // connecting rooms 
    // --------------------------------------------------------------------

    // When connecting a room to this room from any direction, 
    // we want to establish the same connection for the other room.

    public void connectNorth(Room room){
        this.north = room;
        if (room.lookSouth()) return;
        room.connectSouth(this);
    }

    public void connectSouth(Room room){
        this.south = room;
        if (room.lookNorth()) return;
        room.connectNorth(this);
    }

    public void connectEast(Room room){
        this.east = room;
        if(room.lookWest()) return;
        room.connectWest(this);
    }

    public void connectWest(Room room){
        this.west = room;
        if (room.lookSouth()) return;
        room.connectEast(this);
    }

    // get functions 
    // --------------------------------------------------------------------

    public String getName(){
        if (this.visited) {
            return this.name;
        } else {
            return "";
        }
    }

    public String getDescription(){
        if (this.visited) {
            return this.description;
        } else {
            return "";
        }
    }

    // moving and changing rooms
    // --------------------------------------------------------------------
    public void discoverRoom() {
        this.visited = true;
    }

    public Room goNorth() throws Exception{
        if (this.north==null) {throw new Exception("Theres nothing to the north.");}
        return this.north;
    }

    public Room goSouth() throws Exception{
        if (this.south==null) {throw new Exception("Theres nothing to the south.");}
        return this.south;
    }
    public Room goWest() throws Exception{
        if (this.west==null) {throw new Exception("Theres nothing to the west.");}
        return this.west;
    }
    public Room goEast() throws Exception {
        if (this.east==null) {throw new Exception("Theres nothing to the east.");}
        return this.east;
    }

    // looking at other rooms. Return if a room exists in a direction
    // --------------------------------------------------------------------
    public boolean lookNorth(){
        return this.north != null;
    }
    public boolean lookSouth(){
        return this.south != null;
    }
    public boolean lookWest(){
        return this.west != null;
    }
    public boolean lookEast(){
        return this.east != null;
    }
}
