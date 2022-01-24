import java.util.List;

public class Steve {

    private String name = "Steve";
    private Room currentLocation;
    private List<Item> inventory;

    private int nmbTriedMoves = 0;

    // constructor /////////////////////////////////////////////////
    public Steve(Room startLocation){
        this.currentLocation = startLocation;
    }


    // Helper functions
    private void wereToGo() throws Exception{
        int count = 0;
        System.out.println("Steve turns around clockwise.");
        if(currentLocation.lookWest()){
            System.out.print("Theres a path to the west. ");
            if (currentLocation.goWest().getName() != null){
                System.out.print("It's " + currentLocation.goWest().getName() + ".\n" );
            } else { System.out.print("Steve has not been in that room. \n");}
        } else {
            System.out.println("Steve can't go west.");
            count++;
        }
        if(currentLocation.lookSouth()){
            System.out.print("Theres a path to the south. ");
            if (currentLocation.goSouth().getName() != null){
                System.out.print("It's " + currentLocation.goSouth().getName() + ".\n" );
            }else { System.out.print("Steve has not been in that room. \n");}
        } else {
            System.out.println("Steve can't go south.");
            count++;
        }
        if(currentLocation.lookEast()){
            System.out.print("Theres a path to the east. ");
            if (currentLocation.goEast().getName() != null){
                System.out.print("It's " + currentLocation.goEast().getName() + ".\n" );
            }else { System.out.print("Steve has not been in that room. \n");}
        } else {
            System.out.println("Steve can't go east.");
            count++;
        }
        if(currentLocation.lookNorth()){
            System.out.print("Theres a path to the north. ");
            if (currentLocation.goNorth().getName() != null){
                System.out.print("It's " + currentLocation.goNorth().getName() + ".\n" );
            }else { System.out.print("Steve has not been in that room. \n");}
        } else {
            System.out.println("Steve can't go north.");
            count++;
        }

        if(count == 4) System.out.println("\nSteve is stuck and has nowere to go.");
        if(count == 3) System.out.println("\nSteve knows were to go.");
    }

    private void cantGo(String direction){
        this.nmbTriedMoves++;
        if (nmbTriedMoves > 9) System.out.print("Steve is panicing, he wants to get away.");
        if (nmbTriedMoves == 6) System.out.print("Steve is getting worried he's stuck here. Steve wants to go home.");
        if (nmbTriedMoves == 4) System.out.print("Steve looks at you, wondering if you know what you're doing.");
        if (nmbTriedMoves == 2) System.out.print("Steve must have gotten something in his eye, he keeps walking into walls.");
        
        System.out.println("\nThere is no way that Steve can go " + direction + ".");
    }

    // Functions

    public String getName(){
        return this.name;
    }

    public void lookAround() throws Exception{
        // Descripte the room that steve is in
        this.currentLocation.getDescription();
        System.out.println();

        // list cretures in the room
        this.currentLocation.listCreatures();
        // list items in the room
        this.currentLocation.listItems();
        System.out.println();
        
        // list were steve can go 
        wereToGo();
    }

    // FUnction for moving Steve accross rooms
    public void move(String direction){
        // check if a room exists in the direction
        switch (direction) {
            case null : System.out.println("There is no way that Steve can go " + direction + ". Please reconsider."); break;
            case "west": try {
                            this.currentLocation = this.currentLocation.goWest();
                            nmbTriedMoves=0;
                            System.out.println("Steve went "+direction);
                            this.currentLocation.discoverRoom();
                        } catch (Exception e){ 
                            cantGo(direction);
                        }; 
                        break;
            case "east": try {
                            this.currentLocation = this.currentLocation.goEast();
                            nmbTriedMoves=0;
                            System.out.println("Steve went "+direction);
                            this.currentLocation.discoverRoom();
                        } catch (Exception e){ 
                            cantGo(direction);
                        }; 
                        break;
            case "north":try {
                            this.currentLocation = this.currentLocation.goNorth();
                            nmbTriedMoves=0;
                            System.out.println("Steve went "+direction);
                            this.currentLocation.discoverRoom();
                        } catch (Exception e){ 
                            cantGo(direction);
                        }; 
                        break;
            case "south":try {
                            this.currentLocation = this.currentLocation.goSouth();
                            nmbTriedMoves=0;
                            System.out.println("Steve went "+direction);
                            this.currentLocation.discoverRoom();
                        } catch (Exception e){ 
                            cantGo(direction);
                        }; 
                        break;
            default    :System.out.println("There is no way that Steve can go " + direction + " because is not a direction on his compass."); 
                        break;
        }
    }

}