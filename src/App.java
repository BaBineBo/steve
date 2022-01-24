import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {



    public static void main(String[] args) throws Exception {
        // Test that program is running
        System.out.println("Good morning world! ");

        // Create NPC

        // Create rooms and interiors, aswell as connecting them
        boolean game = true;
        Room start = new Room("start",null,null,null,false);
        Room secondRoom = new Room("Test chamber", null, null,null, true);
        Room firstRoom = new Room("Steves bedroom", "This is steves bedroom, were he wakes up every day." , null,null, true);
        firstRoom.connectNorth(secondRoom);


        // Make steve the main character
        Steve steve = new Steve(firstRoom);

        // Read input variables
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String input = "";
        List<String> inputParts;


        // Interperate text in three parts at most
        // Action-words
        String[] actions = new String[]{"attack", "take", "look", "inspect", "go", "walk", "run",};

        // differentiate between game states
        enum State {
            FIGHT,
            WALKING,
            TALKING,
            START,
            END
        }
        State gameState = State.START;

        // reference item carried or in room
        // create function dependent on steves location, his inventory and the rooms inventory


        // look out for theese words in any position
        String[] dfgjkl = new String[]{"help", "stuff", "inventory"};

        while(gameState != State.END){
            switch (gameState) {
                case END:
                    System.out.println("The game will now end and Steve will be left alone to reset. See you next time, traitor.");
                    break;
                case START:
                    System.out.println("The game of Steve has just begun. Welcome");
                    gameState = State.WALKING;
                    break;
                case WALKING:
                    // Read user input
                    System.out.println("\nWhat will " + steve.getName() + " do?");
                    input = reader.readLine().trim().toLowerCase();
                    System.out.print("\n");
                    // Split first three words, remove spaces, store in list
                    inputParts = Arrays.stream(input.split(" +")).collect(Collectors.toList());

                    //if the first word is quit, then end the process
                    //if(inputParts.get(0).equals("quit")) gameState= State.END;

                    // interperate input word by word
                    switch (inputParts.get(0)){
                        case "quit": 
                            gameState = State.END;
                            break;
                        case "go": case "walk": case "run":
                            // Want steve to move, try to move steve
                            steve.move(inputParts.get(1));
                            break;
                        case "look" : 
                            steve.lookAround();

                    }
                    break;
            }

            



            // lastly, empty input var and array
            // as to not save "ghosts" in next loop iteration
            input = null;
            inputParts = null;

        }
        
        System.out.println("Goodbye. Steve will miss you.");
    }
}
