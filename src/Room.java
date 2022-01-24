import java.util.List;

public class Room {

    // each room has roomas in each other direction
    private Room west;
    private Room east;
    private Room north;
    private Room south;

    // name and description of room
    private String name;
    private String description;
    private boolean unlocked;
    private boolean visited = false;

    // a room must have items in it
    private List<Item> items;

    // a room might have creatures in it
    private List<Creature> creatures;

    // A way to unlock rooms
    
    // a room will maybe have people in it
    
    // constructor ////////////////////////////////////////////////////////////////////////////////
    public Room(String name, String description, List<Item> items, boolean key){

        this.name   = name;
        this.description = description;

        this.items = items;

        this.unlocked = key;
    }

    // Chek if rooms has living creatures in it
    public boolean isPopulated(){
        return creatures.size()>0;
    }

    public void listCreatures(){
        if (this.isPopulated()) {
            for(int i =0; i < creatures.size(); i++){
                System.out.println(creatures.get(i).getName() + " is in the room.");
            }
        }
    }

    // connecting rooms /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

    public String getName(){
        if (this.visited) {
            return this.name;
        } else {
            return null;
        }
    }

    // moving and changing rooms
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

    // looking at other rooms
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
