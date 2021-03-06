package GameManager;

import java.util.Arrays;
import java.util.Scanner;

import Character.Character;
import Character.CharacterInventory;
import Character.ChestInventory;
import FinalProject.Main;
import Items.Item;
import Items.Potion;
import Items.Weapon;
import Utils.Effect;
import Utils.intDuo;

@SuppressWarnings("unused")
/**
 *
 * @author Christian Pilley, Kallie Mendoza
 *
 */
public class GameManager {

    private static int textSpeed = 1;
    private static final int[] textSpeeds = {50, 40, 30, 20, 10};
    private static boolean alive;
    private static int points;
    private static Character mainCharacter;
    private static Scanner scanner;

    private static Character[] NPCS = new Character[100];
    private static int numNPCS = 0;
    private static Character[] Enemies = new Character[100];
    private static int numEnemies = 0;

    private static Character getCharacter() {
        return mainCharacter;
    }

    /**
     * Adds points to the total game score.
     *
     * @param p
     */
    public static void addPoints(int p) {
        points += p;
    }

    /**
     * Ends the game
     */
    public static void end() {
        alive = false;
        String p = String.valueOf(points);
        String uL = "You Lose!";
        System.out.println(uL);
        System.out.println("Points: " + p);
    }

    /**
     * Sets the player to be a new player, this will be called if the player
     * doesn't go into NG+ with the same character.
     *
     * @param character
     */
    public static void setPlayer(Character character) {
        mainCharacter = character;
    }

    /**
     * Starts the game.
     *
     * @param m - character that will be used to play the game with.
     */
    public static void play(Character m) {
        alive = true;
        mainCharacter = m;
        points = 0;
        int count = 0;
        Arrays.fill(NPCS, null);
        Arrays.fill(Enemies, null);
        scanner = new Scanner(System.in);
        fancyText("You are a poor medieval farmer who recently came upon a quest.");
        fancyText("The King's wife has gone missing and there is a reward.");
        fancyText("This reward is enough to feed your starving family for life.");
        //THIS IS ALSO PART OF NUMBER 2! FIND ME!.
        while (alive) {
            count = runEvent(count);
        }
    }

    private static void fancyText(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(textSpeeds[textSpeed - 1]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

    }

    public static void OptionsMenu() {
        int temp = textSpeed;
        textSpeed = 5;
        fancyText("If you would like to change an option, input the letter, followed by a space, then the option.");
        System.out.println("T] Change text speed [1-5]   Currently: " + temp);
        System.out.println("D] Change Difficulty [1-3]   Currently: 1");
        System.out.println("Q] Exit Options Menu");
        do {
            String in = scanner.nextLine();
            char command = in.toLowerCase().charAt(0);
            int data = 0;
            if (in.length() > 1) {
                data = Integer.parseInt(in.substring(1).trim());
            }
            if (command != 't' && command != 'd' && command != 'q') {
                System.out.println("Please input a correct option!");
            } else if (command == 't') {
                if (data > 5 || data < 1) {
                    System.out.println("Please input a speed value between 1 and 5");
                } else {
                    textSpeed = data;
                    System.out.println("You have changed the text speed to " + data + " from " + temp);
                    return;
                }
            } else if (command == 'd') {
                if (data > 3 || data < 1) {
                    System.out.println("Please input a difficulty value between 1 and 3");
                } else {
                    textSpeed = temp;
                    System.out.println("You have changed the difficulty to " + data);
                    return;
                }
            } else {
                textSpeed = temp;
                fancyText("Returning to game.");
                return;
            }
        } while (true);
    }

    private static void ShopMenu(String shop) {

        int amountOfGold = mainCharacter.getInventory().itemAt(mainCharacter.getInventory().searchForItem(new Item("Gold"))).getCount();

        switch (shop) {
            case "Armory": {
                CharacterInventory arms = new CharacterInventory(
                        new Weapon[]{
                            new Weapon("Gold Sword", 20),
                            new Weapon("Steel Rapier", 15),
                            new Weapon("Wood Sword", 4)
                        });
                System.out.println(arms.numItemStacks);
                arms.displayInventory();

                do {
                    fancyText("Dax: What would you like to buy?");
                    System.out.println("1, 2 or 3?");
                    System.out.print(">>> ");
                    char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                    if (in != '1' && in != '2' && in != '3') {
                        System.out.println("Enter a correct choice.");
                    } else if (in == '1') {
                        if (amountOfGold >= arms.itemAt(new intDuo(0, 0)).getValue()) {
                            mainCharacter.getInventory().addToInventory(arms.itemAt(new intDuo(0, 0)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else if (in == '2') {
                        if (amountOfGold >= arms.itemAt(new intDuo(0, 1)).getValue()) {
                            mainCharacter.getInventory().addToInventory(arms.itemAt(new intDuo(0, 1)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else if (in == '3') {
                        if (amountOfGold >= arms.itemAt(new intDuo(0, 2)).getValue()) {
                            mainCharacter.getInventory().addToInventory(arms.itemAt(new intDuo(0, 2)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else {
                        return;
                    }
                } while (!false);
            }
            case "Butchery": {
                ChestInventory butch = new ChestInventory(
                        new Item("Apple", 50),
                        new Item("Corn", 4),
                        new Weapon("Hoe of Growth", 4).setValue(3f));
                butch.displayInventory();
                do {
                    fancyText("Crom: What would you like to buy?");
                    System.out.println("1, 2 or 3?");
                    System.out.print(">>> ");
                    char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                    if (in != '1' && in != '2' && in != '3') {
                        System.out.println("Enter a correct choice.");
                    } else if (in == '1') {
                        if (amountOfGold >= butch.itemAt(new intDuo(0, 0)).getValue()) {
                            mainCharacter.getInventory().addToInventory(butch.itemAt(new intDuo(0, 0)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else if (in == '2') {
                        if (amountOfGold >= butch.itemAt(new intDuo(0, 1)).getValue()) {
                            mainCharacter.getInventory().addToInventory(butch.itemAt(new intDuo(0, 1)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else if (in == '3') {
                        if (amountOfGold >= butch.itemAt(new intDuo(0, 2)).getValue()) {
                            mainCharacter.getInventory().addToInventory(butch.itemAt(new intDuo(0, 2)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else {
                        return;
                    }
                } while (!false);
            }
            case "Apothecary":
                ChestInventory apoc = new ChestInventory(
                        new Potion(Effect.health),
                        new Potion(Effect.speed),
                        new Item("Herbs"));
                apoc.displayInventory();
                do {
                    fancyText("Valerii: What would you like to buy?");
                    System.out.println("1, 2 or 3?");
                    System.out.print(">>> ");
                    char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                    if (in != '1' && in != '2' && in != '3') {
                        System.out.println("Enter a correct choice.");
                    } else if (in == '1') {
                        if (amountOfGold >= apoc.itemAt(new intDuo(0, 0)).getValue()) {
                            mainCharacter.getInventory().addToInventory(apoc.itemAt(new intDuo(0, 0)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else if (in == '2') {
                        if (amountOfGold >= apoc.itemAt(new intDuo(0, 1)).getValue()) {
                            mainCharacter.getInventory().addToInventory(apoc.itemAt(new intDuo(0, 1)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else if (in == '3') {
                        if (amountOfGold >= apoc.itemAt(new intDuo(0, 2)).getValue()) {
                            mainCharacter.getInventory().addToInventory(apoc.itemAt(new intDuo(0, 2)));
                        } else {
                            fancyText("You dont have enough gold to buy this item!");
                        }
                    } else {
                        return;
                    }
                } while (!false);
        }

    }

    private static void win() {

    }

    private static int runEvent(int count) {
        boolean correctInput = false;
        int amountOfGold = mainCharacter.getInventory().itemAt(mainCharacter.getInventory().searchForItem(new Item("Gold"))).getCount();
        switch (count) {//REQ 7!!!!!!!! PART 1!!!!!!!! 
            case 0: {
                fancyText("You are in the town center, where do you wish to go " + mainCharacter.getName() + "?");
                do {
                    System.out.println("A] Home\n"
                            + "B] Market\n"
                            + "C] Black Forest\n\n"
                            + "I] Open Inventory\n"
                            + "O] Options");
                    char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                    if (in != 'a' && in != 'b' && in != 'c' && in != 'i' && in != 'o') { //REQ 7 PART 2!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        System.out.println("Enter a correct choice.");
                    } else if (in == 'a') {
                        return 1;
                    } else if (in == 'b') {
                        return 2;
                    } else if (in == 'c') {
                        return 3;
                    } else if (in == 'i') {
                        OpenInventory();
                    } else {
                        OptionsMenu();
                    }
                } while (!false);
            }
            case 1: {
                if (EventManager.canGoHome) {
                    fancyText("You have decided to walk home.");
                    fancyText("When you arrive your wife is hanging up laundry to dry,\nyour 4 kids are playing, and the baby is asleep.");
                    fancyText("The crops are dead and the dirt is dry. what do you wish to do " + mainCharacter.getName() + "?");
                    do {
                        System.out.println("A] Help with Chores\n"
                                + "B] Play with kids\n"
                                + "C] Take care of the baby\n"
                                + "D] Check the crops\n"
                                + "E] Head back towards the town center\n\n"
                                + "I] Open Inventory\n"
                                + "O] Options");
                        char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                        if (in != 'a' && in != 'b' && in != 'c' && in != 'd' && in != 'e' && in != 'i' && in != 'o') {
                            System.out.println("Enter a correct choice.");
                        } else if (in == 'a') {
                            fancyText("You help out with chores, though your wife could have done them alone."
                                    + "\nYou spend all day doing chores and are now ready to rest");
                            fancyText("Your wife believes you are not competant enough to take care of the family and kicks you out");
                            fancyText("You return to the town square...");
                            EventManager.canGoHome = false;
                            return 0;
                        } else if (in == 'b') {
                            fancyText("You decided to play with the kids until noon, and you are now very tired. Fatigue will cause you to move slower\n"
                                    + "and you will eventually take damage. The fatigue will go away if you rest until night."
                                    + "Your kids still want to play and have finished their chores.");
                            fancyText("The shops in the town center will close at night. What do you wish to do " + mainCharacter.getName() + "?");
                            do {
                                System.out.println(
                                        "A] Rest\n"
                                        + "B] Play With Kids\n\n"
                                        + "I] Open Inventory\n"
                                        + "O] Options");
                                if (in != 'a' && in != 'b' && in != 'i' && in != 'o') {
                                    System.out.println("Enter a correct choice.");
                                } else if (in == 'a') {
                                    fancyText("You rest and are no longer fatigued. It�s now night and the town center is closed.\n"
                                            + "Your family heads off yet your wife decides to sit next to you.\n"
                                            + "She begins to tell you, in a very hushed voice, that you�re lazy\n"
                                            + "and cannot provide for this family, she wants you gone by morning.\n");
                                    fancyText("Morning comes and you walk back to town, a vagabond.");
                                    EventManager.canGoHome = false;
                                    return 0;
                                } else if (in == 'b') {
                                    fancyText("You decide to help out with the kids. It�s now night and you are extremely fatigued.\n"
                                            + "You have eaten with your family using 1 ration and now it�s time to rest.\n"
                                            + "Before you get in bed your wife thanks you for helping with the children,\n"
                                            + "however you decided to take care of the children rather than try to find a way to feed your family.\n"
                                            + "She kicks you out in the morning. You head back to town, a vagabond.");
                                    EventManager.canGoHome = false;
                                    Item rations = mainCharacter.getInventory().itemAt(mainCharacter.getInventory().searchForItem(new Item("Rations")));
                                    rations.setCount(rations.getCount() - 1);
                                    return 0;
                                } else if (in == 'i') {
                                    OpenInventory();
                                } else if (in == 'o') {
                                    OptionsMenu();
                                }
                            } while (!false);
                            //return 4;
                        } else if (in == 'c') {
                            fancyText("You decide to help out with the kids. It is now night and you are extremely fatigued.\n"
                                    + "You have eaten with your family using 1 ration and now it is time to rest.\n"
                                    + "Before you get in bed your wife thanks you for helping with the children,\n"
                                    + "however you decided to take care of the children rather than try to find a way to feed your family.\n"
                                    + "She kicks you out in the morning. You head back to town, a vagabond.");
                            EventManager.canGoHome = false;
                            Item rations = mainCharacter.getInventory().itemAt(mainCharacter.getInventory().searchForItem(new Item("Rations")));
                            rations.setCount(rations.getCount() - 1);
                            return 0;
                        } else if (in == 'd') {
                            fancyText("You check the crops. Most are dead except the apple tree which has a patch of green \n"
                                    + "grass around it. What do you do? ");
                            do {
                                System.out.println("A] Inspect Apple Tree \n"
                                        + "B] Inspect Dirt \n"
                                        + "C] Head Towards family \n"
                                        + "D] Head Towards Town Center \n"
                                        + "\nI] Inventory \n"
                                        + "O} Options");
                                char in2 = scanner.nextLine().toLowerCase().toCharArray()[0];
                                if (in2 != 'a' && in2 != 'b' && in2 != 'c' && in2 != 'd' && in2 != 'i' && in2 != 'o') {
                                    System.out.println("Enter a correct choice.");
                                } else if (in2 == 'a') {
                                    fancyText("The apple tree is very healthy but not fully grown.\n"
                                            + "It's leaves are a pleasant green color, and bugs seem to enjoy its fruit.\n"
                                            + "The tree and grass surrounding it are the only plants alive on your farm.\n");
                                    do {
                                        System.out.println("A] Inspect Dirt \n"
                                                + "B] Head to Family \n"
                                                + "C] Head Towards Town Center \n"
                                                + "\n I] Inventory \n"
                                                + "O] Options");
                                        char in3 = scanner.nextLine().toLowerCase().toCharArray()[0];
                                        if (in3 != 'a' && in3 != 'b' && in3 != 'c' && in3 != 'i' && in3 != 'o') {
                                            System.out.println("Enter a correct choice.");
                                        } else if (in3 == 'a') {
                                            //inspect dirt
                                        } else if (in3 == 'b') {
                                            return 1;
                                        } else if (in3 == 'c') {
                                            return 0;
                                        } else if (in3 == 'i') {
                                            OpenInventory();
                                        } else if (in3 == 'o') {
                                            OptionsMenu();
                                        }
                                    } while (!alive);
                                } else if (in2 == 'b') {
                                    return 1;
                                } else if (in2 == 'c') {
                                    return 0;
                                } else if (in2 == 'i') {
                                    OpenInventory();
                                } else if (in2 == 'o') {
                                    OptionsMenu();
                                }
                            } while (!false);
                        } else if (in == 'i') {
                            OpenInventory();
                        } else if (in == 'o') {
                            OptionsMenu();
                        } else {
                            return 0;
                        }

                    } while (!false);
                } else {
                    fancyText("Ties to your family have been severed, you are not allowed home.");
                    return 0;
                }
            }

            case 2: {
                if (contains(NPCS, "Dax") && contains(NPCS, "Crom") && contains(NPCS, "Valerii")) {
                    EventManager.canStartQuest = true;
                    System.out.println("A voice in your head has made it clear you are ready to venture onwards.");
                }
                fancyText("You decide to head to the Market");
                fancyText("You have " + amountOfGold + " gold pieces on you, and see 3 stands infront of you.");
                fancyText("The Armory sells armor and weapons."
                        + "\nThe Butchery sells food, animals, seeds, and farming equipment."
                        + "\nThe Apothecary sells potions and herbs");
                fancyText("where would you like to go " + mainCharacter.getName() + "?");
                do {
                    System.out.println("A] Armory\n"
                            + "B] Butchery\n"
                            + "C] Apothecary\n"
                            + "D] Return to the town center\n\n"
                            + "I] Open Inventory\n"
                            + "O] Options");
                    char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                    if (in != 'a' && in != 'b' && in != 'c' && in != 'd' && in != 'i' && in != 'o') {
                        System.out.println("Enter a correct choice.");
                    } else if (in == 'a') {
                        if (!contains(NPCS, "Dax") && !EventManager.daxIsDead) {
                            NPCS[numNPCS] = new Character(
                                    new CharacterInventory(
                                            new Item("Gold", 100),
                                            new Weapon("Excallibur", 15)),
                                    10, "Dax", null, true);
                        } else {
                            if (EventManager.daxIsDead) {
                                fancyText("The shop owner is dead, the store is closed.");
                                runEvent(count);
                            }
                        }
                        fancyText("Dax: Well hello there! Welcome to my shop! Care to look at some new blades?");
                        do {
                            System.out.println("S] Shop\n"
                                    + "Q] Leave\n\n"
                                    + "I] Inventory\n"
                                    + "O] Options");
                            char in2 = scanner.nextLine().toLowerCase().toCharArray()[0];
                            if (in2 != 's' && in2 != 'q' && in2 != 'i' && in2 != 'o') {
                                System.out.println("Enter a correct choice.");
                            } else if (in2 == 's') {
                                ShopMenu("Armory");
                            } else if (in2 == 'q') {
                                return 2;
                            } else if (in2 == 'i') {
                                OpenInventory();
                            } else if (in2 == 'o') {
                                OptionsMenu();
                            }
                        } while (!false);
                    } else if (in == 'b') {
                        if (!contains(NPCS, "Crom") && !EventManager.cromIsDead) {
                            NPCS[numNPCS] = new Character(
                                    new CharacterInventory(
                                            new Item("Gold", 75),
                                            new Weapon("Iron Hoe", 5)),
                                    10, "Crom", null, true);
                        } else {
                            if (EventManager.cromIsDead) {
                                fancyText("The shop owner is dead, the store is closed.");
                                runEvent(count);
                            }
                        }
                        fancyText("Crom: 'ello there! We'Come to me shop! What ja like?");
                        do {
                            System.out.println("S] Shop\n"
                                    + "Q] Leave\n\n"
                                    + "I] Inventory\n"
                                    + "O] Options");
                            char in2 = scanner.nextLine().toLowerCase().toCharArray()[0];
                            if (in2 != 's' && in2 != 'q' && in2 != 'i' && in2 != 'o') {
                                System.out.println("Enter a correct choice.");
                            } else if (in2 == 's') {
                                ShopMenu("Butchery");
                            } else if (in2 == 'q') {
                                return 2;
                            } else if (in2 == 'i') {
                                OpenInventory();
                            } else if (in2 == 'o') {
                                OptionsMenu();
                            }
                        } while (!false);
                    } else if (in == 'c') {
                        if (!contains(NPCS, "Valerii") && !EventManager.valeriiIsDead) {
                            NPCS[numNPCS] = new Character(
                                    new CharacterInventory(
                                            new Item("Gold", 100),
                                            new Weapon("Excallibur", 15)),
                                    10, "Valerii", null, true);
                        } else {
                            if (EventManager.valeriiIsDead) {
                                fancyText("The shop owner is dead, the store is closed.");
                                runEvent(count);
                            }
                        }
                        fancyText("Valerii: Hello there darling, Welcome to my Apothecary! I've Potions and Herbs a plenty!");
                        do {
                            System.out.println("S] Shop\n"
                                    + "Q] Leave\n\n"
                                    + "I] Inventory\n"
                                    + "O] Options");
                            char in2 = scanner.nextLine().toLowerCase().toCharArray()[0];
                            if (in2 != 's' && in2 != 'q' && in2 != 'i' && in2 != 'o') {
                                System.out.println("Enter a correct choice.");
                            } else if (in2 == 's') {
                                ShopMenu("Apothecary");
                            } else if (in2 == 'q') {
                                return 2;
                            } else if (in2 == 'i') {
                                OpenInventory();
                            } else if (in2 == 'o') {
                                OptionsMenu();
                            }
                        } while (!false);
                    } else if(in == 'i'){
                        OpenInventory();
                    } else if(in == 'o'){
                        OptionsMenu();
                    } else {
                        return 0;
                    }
                } while (!false);
            }
            case 3: {
                if (!EventManager.canStartQuest) {
                    fancyText("This path is not available yet. you need to discover more things about your surroundings first.");
                    return 0;
                } else {
                    fancyText("You have decided to enter the black forest.");

                    do {
                        Character wolf = new Character(
                                new CharacterInventory(
                                        new Weapon("Claws", 10)),
                                5, "The Wolf", null, true);
                        wolf.setSpeed(20);
                        fancyText("A Wolf comes to the path and growls at you, ready to attack.");
                        fancyText("It has an attack stat of 10, speed of 20, and 5 health");
                        System.out.println("A] Fight\n"
                                + "B] Run\n\n"
                                + "I] Inventory\n"
                                + "O] Options");
                        char in = scanner.nextLine().toLowerCase().toCharArray()[0];
                        if (in != 'a' && in != 'b' && in != 'i' && in != 'o') {
                            System.out.println("Enter a correct choice.");
                        } else if (in == 'a') {
                            fight(mainCharacter, wolf);
                            fancyText("After the fight you get disoriented, and head back to town.");
                            return 0;
                        } else if (in == 'b') {
                            fancyText("You attempt to run from the wolf");
                            if (mainCharacter.getSpeed() > wolf.getSpeed()) {
                                fancyText("You escape the wolf and end up back in the town center");
                                addPoints(25);
                                return 0;
                            } else if (mainCharacter.getSpeed() == wolf.getSpeed()) {
                                fancyText("The wolf chases you back to town, barely behind you. but the sight of the city scares it off");
                                addPoints(25);
                                return 0;
                            } else if (mainCharacter.getSpeed() < wolf.getSpeed()) {
                                fancyText("The wolf catches up to you and bites your leg");
                                Weapon wolfClaws = (Weapon) wolf.getInventory().itemAt(wolf.getInventory().searchForItem(new Weapon("Claws")));

                                mainCharacter.takeDamage(wolfClaws.getDamage(), wolf);

                                fancyText("You can either fight the wolf or curl up and get eaten.");
                                System.out.println("A] Fight\n"
                                        + "B] Die\n\n"
                                        + "I] Inventory\n"
                                        + "O] Options");
                                do {
                                    char in2 = scanner.nextLine().toLowerCase().toCharArray()[0];
                                    if (in2 != 'a' && in2 != 'b' && in2 != 'i' && in2 != 'o') {
                                        System.out.println("Enter a correct choice.");
                                    } else if (in2 == 'a') {
                                        fight(mainCharacter, wolf);
                                    } else if (in2 == 'b') {
                                        fancyText("The wolf starts biting you and you black out from the pain.");
                                        mainCharacter.takeDamage(1000, wolf);
                                    } else if (in2 == 'i') {
                                        OpenInventory();
                                    } else if (in2 == 'o') {
                                        OptionsMenu();
                                    }
                                } while (alive);

                            }
                        } else if (in == 'i') {
                            OpenInventory();
                        } else if (in == 'o') {
                            OptionsMenu();
                        }
                    } while (alive);
                }
            }
            case 4: {

            }
        }
        return count;
    }

    private static void fight(Character mainCharacter2, Character fighter2) {
        int mainCharacterDamage = mainCharacter.getInventory().HasAWeapon() ? mainCharacter.getBestWeapon().getDamage() : 1;
        //System.out.println("MCD");
        int fighterDamage = fighter2.getInventory().HasAWeapon() ? fighter2.getBestWeapon().getDamage() : 1;
        //System.out.println("FD");
        boolean fighterAlive = true;
        do {
            fancyText("What would you like to do?");
            System.out.println("A] Fight\n"
                    + "B] Use Item\n"
                    + "C] Forfeit\n"
                    + "O] Options");
            char in = scanner.nextLine().toLowerCase().toCharArray()[0];

            if (in != 'a' && in != 'b' && in != 'i' && in != 'o') {
                System.out.println("Enter a correct choice.");
            } else if (in == 'a') {

                if (mainCharacter2.getSpeed() >= fighter2.getSpeed()) {

                    if (fighter2.getHealth() - mainCharacterDamage <= 0) {
                        fancyText("You have killed " + fighter2.getName());
                    }
                    fighter2.takeDamage(mainCharacterDamage, fighter2);
                    if (fighter2.getHealth() <= 0) {
                        return;
                    }
                    if (mainCharacter2.getHealth() - fighterDamage / 5 <= 0) {
                        fancyText("You have been slain by " + fighter2.getName());
                    }
                    mainCharacter2.takeDamage(fighterDamage / 5, fighter2);
                    if (mainCharacter2.getHealth() <= 0) {
                        return;
                    }
                } else {
                    if (mainCharacter2.getHealth() - fighterDamage / 2 <= 0) {
                        fancyText("You have been slain by " + fighter2.getName());
                    }
                    mainCharacter2.takeDamage(fighterDamage / 2, fighter2);
                    if (mainCharacter2.getHealth() <= 0) {
                        return;
                    }
                    if (fighter2.getHealth() - mainCharacterDamage <= 0) {
                        fancyText("You have killed " + fighter2.getName());
                    }
                    fighter2.takeDamage(mainCharacterDamage, fighter2);
                    if (fighter2.getHealth() <= 0) {
                        return;
                    }
                }
            } else if (in == 'b') {
                OpenInventory();
                fancyText("Which item would you like to use?\n"
                        + "(type in U <row> <col> ?<num> {please use array notation}");
                boolean correct = false;
                do {
                    String com = scanner.nextLine();
                    if (com.toLowerCase().charAt(0) == 'u') {
                        System.out.println(com.substring(2, 4).trim() + "\n" + com.substring(5, 7).trim());
                        int row = Integer.parseInt(com.substring(2, 4).trim());
                        int col = Integer.parseInt(com.substring(5, 7).trim());
                        int num = 1;
                        if (in > 7) {
                            num = Integer.parseInt(com.substring(8));
                        }
                    }
                } while (!correct);
            } else if (in == 'c') {
                fancyText("You have conceeded to your opponent, in doing so they strike you down.");
                mainCharacter2.takeDamage(mainCharacter2.getHealth(), fighter2);
            } else if (in == 'o') {
                OptionsMenu();
            }
        } while (alive && fighterAlive);
    }

    private static void OpenInventory() {
        mainCharacter.getInventory().displayInventory();

    }

    private static boolean contains(Character[] nPCS2, String string) {
        if (numNPCS == 0) {
            return false;
        }
        for (Character n : nPCS2) {
            if (n != null) {
                if (n.getName().equals(string)) {
                    return true;
                }
            }
        }
        return false;
    }

}
