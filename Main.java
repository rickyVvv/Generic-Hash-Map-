import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

    GenericHashMap<String,Integer> info = new GenericHashMap<String,Integer>();
    GenericHashMap<String,GenericHashMap> home = new GenericHashMap<String,GenericHashMap>();
    GenericHashMap<String,GenericHashMap> away = new GenericHashMap<String,GenericHashMap>();
    GenericHashMap<String, GenericHashMap> All = new GenericHashMap<String,GenericHashMap>();
        Scanner Userinput = new Scanner(System.in); //creating a new scanner
        String in; //temp string
        in = Userinput.next(); //user input
        File file = new File (in); //creating file
        if(!file.exists()){
            System.out.print("No such file");
        }
        Scanner scan = new Scanner(file); //searching file
        String Name = "";
        int Lines = 0;
        while(scan.hasNextLine()) //counting how many line there are in the text file
        {


            Lines++;
            scan.nextLine();
        }
        int j = 0;
        scan = new Scanner(file);
        ArrayList<String> homename = new ArrayList<String>();
        ArrayList<String> awayname = new ArrayList<String>();
        ArrayList<String> allnames = new ArrayList<String>();
        while (j < Lines){
            //TODO USE AN ARRAYLIST FOR NAMES SO U CAN USE .sort() AND THEN WE CAN GET INFO OF A CERTAIN INSTANCE SO 
            // USE .GET() FOR THE FIRST INSTANCE OF THE ARRAY LIST 
            info = new GenericHashMap<String,Integer>();
            Player one = new Player();
            String homeoraway = scan.next();
            if(homeoraway.compareTo("H") == 0) //this function is here to determine if it is a home team or away 
            {

                String name = scan.next();
                homename.add(name);
                String bat = scan.next();
                if(home.get(name) == null) {
                    if (bat.charAt(0) == 'K') { //if there is a K in the input file well we know its a strikeout
                        info.put("Strikeout", one.getstrikeout() + 1);
                    }else if (bat.charAt(1) == '-') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'P') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'D') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'F') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == '3' && bat.charAt(1) == 'u') {
                        info.put("Out", one.getout() + 1);
                    } else if (Character.isDigit(bat.charAt(0)) && bat.charAt(1) == 'B') {
                        info.put("Hits", one.getHit() + 1);
                    }else if(bat.charAt(0) == 'H' && bat.charAt(1) == 'R'){
                        info.put("Hits", one.getHit() + 1);
                    } else if (bat.charAt(0) == 'B') {
                        info.put("Walk", one.getWalk() + 1);
                    } else if (bat.charAt(0) == 'S') {
                        info.put("Sac", one.getSacrafice() + 1);
                    } else if (bat.charAt(0) == 'H') {
                        info.put("Hit by Pitch", one.getHitbyPitch() + 1);
                    } else if (bat.charAt(0) == 'E') {
                        info.put("Errors", one.getErrors() + 1);
                    }
                    All.put(name,info);
                    home.put(name, info);
                }
                else if(home.get(name) != null){ //this function is simple it tells us if there is a repeating name 
                    // for home
                    GenericHashMap<String,Integer> temp = home.get(name);
                    if(temp.get("Out") != null) {
                        one.setout(temp.get("Out"));
                        info.put("Out", one.getout());
                    }
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                        info.put("Strikeout", one.getstrikeout());
                    }
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                        info.put("Hits", one.getHit());
                    }
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                        info.put("Walk", one.getWalk());
                    }
                    if(temp.get("Sac") != null) {
                        one.setSacrafice(temp.get("Sac"));
                        info.put("Sac", one.getSacrafice());
                    }
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));
                        info.put("Hit by Pitch", one.getHitbyPitch());
                    }
                    if(temp.get("Errors")!= null) {
                        one.setErrors(temp.get("Errors"));
                        info.put("Errors", one.getErrors());
                    }
                    
                    
                     if (bat.charAt(0) == 'K') {
                        info.put("Strikeout", one.getstrikeout() + 1);
                    }else if (bat.charAt(1) == '-') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'P') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'D') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'F') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == '3' && bat.charAt(1) == 'u') {
                        info.put("Out", one.getout() + 1);
                    }else if (Character.isDigit(bat.charAt(0)) && bat.charAt(1) == 'B') {
                         info.put("Hits", one.getHit() + 1); 
                     }else if(bat.charAt(0) == 'H' && bat.charAt(1) == 'R'){
                         info.put("Hits", one.getHit() + 1);
                     } else if (bat.charAt(0) == 'B') {
                         info.put("Walk", one.getWalk() + 1);
                     } else if (bat.charAt(0) == 'S') {
                        info.put("Sac", one.getSacrafice() + 1);
                    } else if (bat.charAt(0) == 'H') {
                        info.put("Hit by Pitch", one.getHitbyPitch() + 1);
                    } else if (bat.charAt(0) == 'E') {
                        info.put("Errors", one.getErrors() + 1);
                    }
                     
                    home.put(name, info);
                     All.put(name,info);

                }


            }
            else if (homeoraway.compareTo("A") == 0) { //now we focus on away team
                String name = scan.next();
                awayname.add(name);
                String bat = scan.next();
                if(away.get(name) == null) {
                    if (bat.charAt(0) == 'K') {
                        info.put("Strikeout", one.getstrikeout() + 1);
                    } else if (bat.charAt(1) == '-') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'P') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'D') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'F') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == '3' && bat.charAt(1) == 'u') {
                        info.put("Out", one.getout() + 1);
                    } else if (Character.isDigit(bat.charAt(0)) && bat.charAt(1) == 'B') {
                        info.put("Hits", one.getHit() + 1);
                    }else if(bat.charAt(0) == 'H' && bat.charAt(1) == 'R'){
                        info.put("Hits", one.getHit() + 1);
                    } else if (bat.charAt(0) == 'B') {
                        info.put("Walk", one.getWalk() + 1);
                    } else if (bat.charAt(0) == 'S') {
                        info.put("Sac", one.getSacrafice() + 1);
                    } else if (bat.charAt(0) == 'H') {
                        info.put("Hit by Pitch", one.getHitbyPitch() + 1);
                    } else if (bat.charAt(0) == 'E') {
                        info.put("Errors", one.getErrors() + 1);
                    }
                    away.put(name, info);
                    All.put(name,info);
                }
                else if(away.get(name) != null){ //if there is a repeating name for away
                    GenericHashMap<String,Integer> temp = away.get(name);
                    if(temp.get("Out") != null) {
                        one.setout(temp.get("Out"));
                        info.put("Out", one.getout());
                    }
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                        info.put("Strikeout", one.getstrikeout());
                    }
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                        info.put("Hits", one.getHit());
                    }
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                        info.put("Walk", one.getWalk());
                    }
                    if(temp.get("Sac") != null) {
                        one.setSacrafice(temp.get("Sac"));
                        info.put("Sac", one.getSacrafice());
                    }
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));
                        info.put("Hit by Pitch", one.getHitbyPitch());
                    }
                    if(temp.get("Errors")!= null) {
                        one.setErrors(temp.get("Errors"));
                        info.put("Errors", one.getErrors());
                    }
                    
                    
                    if (bat.charAt(0) == 'K') {
                        info.put("Strikeout", one.getstrikeout() + 1);
                    }else if (bat.charAt(1) == '-') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'P') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'D') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == 'F') {
                        info.put("Out", one.getout() + 1);
                    } else if (bat.charAt(0) == '3' && bat.charAt(1) == 'u') {
                        info.put("Out", one.getout() + 1);
                    }  else if (Character.isDigit(bat.charAt(0)) && bat.charAt(1) == 'B') {
                        info.put("Hits", one.getHit() + 1);
                    }else if(bat.charAt(0) == 'H' && bat.charAt(1) == 'R'){
                        info.put("Hits", one.getHit() + 1);
                    } else if (bat.charAt(0) == 'B') {
                        info.put("Walk", one.getWalk() + 1);
                    } else if (bat.charAt(0) == 'S') {
                        info.put("Sac", one.getSacrafice() + 1);
                    } else if (bat.charAt(0) == 'H') {
                        info.put("Hit by Pitch", one.getHitbyPitch() + 1);
                    } else if (bat.charAt(0) == 'E') {
                        info.put("Errors", one.getErrors() + 1);
                    }
                    away.put(name, info);
                    All.put(name,info);

                }
            }
            j++;
        }
        Set<String> set = new HashSet<>(homename); //adding a Hashset to remove repeating values
        homename.clear();
        homename.addAll(set);
        Collections.sort(homename); //sorting it in alphabetical order
        Set<String> set1 = new HashSet<>(awayname); //another hashset for away team
        awayname.clear();
        awayname.addAll(set1);
        Collections.sort(awayname); //sorting away
        allnames.addAll(awayname); //adding away first
        allnames.addAll(homename); //then home
        System.out.println("AWAY");
        for(int i = 0; i < awayname.size(); i++ ){ //print the away team first

            Player one = new Player();
            one.setName(awayname.get(i));

            System.out.print(one.getName());
            GenericHashMap<String,Integer> temp = away.get(one.getName());
            if(temp.get("Out") != null) {
                one.setout(temp.get("Out"));
            }
            if(temp.get("Strikeout") != null) {
                one.setstrikeout(temp.get("Strikeout"));
            }
            if(temp.get("Hits") != null) {
                one.setHit(temp.get("Hits"));
            }
            if(temp.get("Walk") != null) {
                one.setWalk(temp.get("Walk"));
            }
            if(temp.get("Sac") != null) {
                one.setSacrafice(temp.get("Sac"));

            }
            if (temp.get("Hit by Pitch") != null) {
                one.setHitbyPitch(temp.get("Hit by Pitch"));

            }
            if(temp.get("Errors")!= null) {
                one.setErrors(temp.get("Errors"));
            }
            one.setAtbat(one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
            one.setOnBase(((float)one.getHit() + one.getWalk() + one.getHitbyPitch())/(one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
            int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
            if (denom == 0){
                one.setBattingAverage(0);
            }
            else {
                one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
            }
            System.out.print("\t" + one.getAtbat());
            System.out.print("\t" + one.getHit());
            System.out.print("\t" + one.getWalk());
            System.out.print("\t" + one.getstrikeout()); //Walks
            System.out.print("\t" + one.getHitbyPitch()); // Strikes
            System.out.print("\t" + one.getSacrafice()); //Hit by Pitch
            System.out.print("\t" + String.format("%.3f", one.getBattingAverage())); //batting average
            System.out.println("\t" + String.format("%.3f", one.getOnBase() ));

        }
        System.out.print("\n");
        System.out.println("HOME");
        for(int i = 0; i < homename.size(); i++ ){ //then print the home team 
            
            Player one = new Player();
            one.setName(homename.get(i));
            
            System.out.print(one.getName());
            GenericHashMap<String,Integer> temp = home.get(one.getName());
            if(temp.get("Out") != null) {
                one.setout(temp.get("Out"));
            }
            if(temp.get("Strikeout") != null) {
                one.setstrikeout(temp.get("Strikeout"));
            }
            if(temp.get("Hits") != null) {
                one.setHit(temp.get("Hits"));
            }
            if(temp.get("Walk") != null) {
                one.setWalk(temp.get("Walk"));
            }
            if(temp.get("Sac") != null) {
                one.setSacrafice(temp.get("Sac"));
                
            }
            if (temp.get("Hit by Pitch") != null) {
                one.setHitbyPitch(temp.get("Hit by Pitch"));
              
            }
            if(temp.get("Errors")!= null) {
                one.setErrors(temp.get("Errors"));
            }
            one.setAtbat(one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
            one.setOnBase(((float)one.getHit() + one.getWalk() + one.getHitbyPitch())/(one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
            int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
            if (denom == 0){
                one.setBattingAverage(0);
            }
            else {
                one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
            }
            System.out.print("\t" + one.getAtbat());
            System.out.print("\t" + one.getHit());
            System.out.print("\t" + one.getWalk());
            System.out.print("\t" + one.getstrikeout()); //Walks
            System.out.print("\t" + one.getHitbyPitch()); // Strikes
            System.out.print("\t" + one.getSacrafice()); //Hit by Pitch
            System.out.print("\t" + String.format("%.3f", one.getBattingAverage())); //batting average
            System.out.println("\t" + String.format("%.3f", one.getOnBase() ));
            
        }
        
        Boolean LeagueLeader = true;
        while(LeagueLeader == true) // FOR BATTING AVERAGE
        {
            float max = -1;//my lowest values will always be below 0 so -1 will work
            int counter = 0;
            float max1 = -1;
            float max2 = -1;
            String Name1 = "";

                
                int j1 = 0;
                while(j1 != allnames.size()) { //im using a integer j to traverse through my whole array list so j 
                    // increments while this happens
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if (temp.get("Out") != null) { //going through my hashmap to find out and store value of out into
                        // player object
                        one.setout(temp.get("Out"));
                    }
                    if (temp.get("Strikeout") != null) { //same with strikeout 
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if (temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if (temp.get("Errors") != null) {
                        one.setErrors(temp.get("Errors"));
                    }
                    int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
                    if (denom == 0){
                        one.setBattingAverage(0);
                    }
                    else {
                        one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
                    }
                    if (max < one.getBattingAverage()) {
                        max = one.getBattingAverage();
                        Name1 = one.getName();
                    }
                    j1++;
                }
                    System.out.println("LEAGUE LEADERS"); //print league leaders
                    System.out.println("BATTING AVERAGE"); //and batting average
                    System.out.print(String.format("%.3f", max));
                    System.out.print("\t" + Name1);
                    String temp1 = Name1;
                    j1 = 0;
                    while(j1 != allnames.size()) { //now we find the second league leader or leaders 
                        Player one = new Player();
                        one.setName(allnames.get(j1));
                        GenericHashMap<String, Integer> temp = All.get(one.getName());
                        if (temp.get("Out") != null) {
                            one.setout(temp.get("Out"));
                        }
                        if (temp.get("Strikeout") != null) {
                            one.setstrikeout(temp.get("Strikeout"));
                        }
                        if (temp.get("Hits") != null) {
                            one.setHit(temp.get("Hits"));
                        }
                        if (temp.get("Errors") != null) {
                            one.setErrors(temp.get("Errors"));
                        }
                        int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
                        if (denom == 0){
                            one.setBattingAverage(0);
                        }
                        else {
                            one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
                        }
                        if (max == one.getBattingAverage() && temp1 != one.getName()) { //we are also checking right 
                            // here to see if anyone else has the same stats as the first league leader
                            Name1 = one.getName();
                            System.out.print(", " + Name1);
                            counter++;
                        }
                        j1++;
                    }
                        System.out.println();
                        if(counter >= 2){ //if the counter is greater than 2 than we know that we printed 3 people 
                            // and we will get out of this while loop 
                            LeagueLeader = false;
                            continue;
                        }
                        j1=0;
                        while(j1 != allnames.size()){ //now we look for second person
                            Player one = new Player();
                            one.setName(allnames.get(j1));
                            GenericHashMap<String, Integer> temp = All.get(one.getName());
                            if (temp.get("Out") != null) {
                                one.setout(temp.get("Out"));
                            }
                            if (temp.get("Strikeout") != null) {
                                one.setstrikeout(temp.get("Strikeout"));
                            }
                            if (temp.get("Hits") != null) {
                                one.setHit(temp.get("Hits"));
                            }
                            if (temp.get("Errors") != null) {
                                one.setErrors(temp.get("Errors"));
                            }
                            int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
                            if (denom == 0){
                                one.setBattingAverage(0);
                            }
                            else {
                                one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
                            }
                            if (max1 < one.getBattingAverage() && one.getBattingAverage() != max) { 
                                max1 = one.getBattingAverage();
                                Name1 = one.getName();
                            }
                            j1++;
                        }
                        if(max1 != -1){ //we need to make sure that something was caught on to 
                            System.out.print(String.format("%.3f", max1));
                            System.out.print("\t" + Name1);
                            temp1 = Name1;
                            j1 = 0;
                            while(j1 != allnames.size()){
                                Player one = new Player();
                                one.setName(allnames.get(j1));
                                GenericHashMap<String, Integer> temp = All.get(one.getName());
                                if (temp.get("Out") != null) {
                                    one.setout(temp.get("Out"));
                                }
                                if (temp.get("Strikeout") != null) {
                                    one.setstrikeout(temp.get("Strikeout"));
                                }
                                if (temp.get("Hits") != null) {
                                    one.setHit(temp.get("Hits"));
                                }
                                if (temp.get("Errors") != null) {
                                    one.setErrors(temp.get("Errors"));
                                }
                                int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
                                if (denom == 0){
                                    one.setBattingAverage(0);
                                }
                                else {
                                    one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
                                }
                                if (max1 == one.getBattingAverage() && temp1 != one.getName()) { //is anyone else a 
                                    // second league leader?
                                    Name1 = one.getName();
                                    System.out.print(", " + Name1);
                                    counter++;
                                }
                                j1++;
                            }
                            System.out.println();
                            if (counter >= 1) {
                                LeagueLeader = false;
                                continue;
                            }
                            j1 =0;
                            while(j1 != allnames.size()) {
                                Player one = new Player();
                                one.setName(allnames.get(j1));
                                GenericHashMap<String, Integer> temp = All.get(one.getName());
                                if (temp.get("Out") != null) {
                                    one.setout(temp.get("Out"));
                                }
                                if (temp.get("Strikeout") != null) {
                                    one.setstrikeout(temp.get("Strikeout"));
                                }
                                if (temp.get("Hits") != null) {
                                    one.setHit(temp.get("Hits"));
                                }
                                if (temp.get("Errors") != null) {
                                    one.setErrors(temp.get("Errors"));
                                }
                                int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
                                if (denom == 0){
                                    one.setBattingAverage(0);
                                }
                                else {
                                    one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
                                }
                                if (max2 < one.getBattingAverage() && max != one.getBattingAverage() && max1 != one.getBattingAverage() && temp1 != one.getName()) { //this is for the last league leader
                                    max2 = one.getBattingAverage();
                                    Name1 = one.getName();
                                }
                                j1++;
                            }
                            System.out.print(String.format("%.3f", max2));
                            System.out.print("\t" + Name1);
                            temp1 = Name1;
                            j1 = 0;
                            while(j1 != allnames.size()){
                                Player one = new Player();
                                one.setName(allnames.get(j1));
                                GenericHashMap<String, Integer> temp = All.get(one.getName());
                                if (temp.get("Out") != null) {
                                    one.setout(temp.get("Out"));
                                }
                                if (temp.get("Strikeout") != null) {
                                    one.setstrikeout(temp.get("Strikeout"));
                                }
                                if (temp.get("Hits") != null) {
                                    one.setHit(temp.get("Hits"));
                                }
                                if (temp.get("Errors") != null) {
                                    one.setErrors(temp.get("Errors"));
                                }
                                int denom = (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors());
                                if (denom == 0){
                                    one.setBattingAverage(0);
                                }
                                else {
                                    one.setBattingAverage(((float) one.getHit()) / (one.getHit() + one.getout() + one.getstrikeout() + one.getErrors()));
                                }
                                if (max2 == one.getBattingAverage() && temp1 != one.getName()) { //is anyone else a 
                                    // last league leader?
                                    Name1 = one.getName();
                                    System.out.print(", " + Name1);
                                    counter++;
                                }
                                j1++;
                            }
                        }
                        System.out.println();
                        LeagueLeader = false;
                    }
        LeagueLeader = true;
        //EVERYSINGLE OTHER FUNCTION FROM HERE ON OUT IS IDENTICAL TO THE ONE ABOVE ONLY DIFFERENCE IS I USE one
        // .getonbase() instead of one.getbattingaverage
        while(LeagueLeader == true){ //ONBASE PERCENTAGE
            float max = -1;
            int counter = 0;
            float max1 = -1;
            float max2 = -1;
            String Name1 = "";


            int j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Out") != null) {
                    one.setout(temp.get("Out"));
                }
                if(temp.get("Strikeout") != null) {
                    one.setstrikeout(temp.get("Strikeout"));
                }
                if(temp.get("Hits") != null) {
                    one.setHit(temp.get("Hits"));
                }
                if(temp.get("Walk") != null) {
                    one.setWalk(temp.get("Walk"));
                }
                if(temp.get("Sac") != null) {
                    one.setSacrafice(temp.get("Sac"));

                }
                if (temp.get("Hit by Pitch") != null) {
                    one.setHitbyPitch(temp.get("Hit by Pitch"));

                }
                if(temp.get("Errors")!= null) {
                    one.setErrors(temp.get("Errors"));
                }
                int denom = (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout());
                if(denom == 0){
                    one.setBattingAverage(0);
                }
                else {
                    one.setOnBase(((float) one.getHit() + one.getWalk() + one.getHitbyPitch()) / (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
                }
                
                if (max < one.getOnBase()) {
                    max = one.getOnBase();
                    Name1 = one.getName();
                }
                j1++;
            }
            System.out.print("\n");
            System.out.println("ON-BASE PERCENTAGE");
            System.out.print(String.format("%.3f", max));
            System.out.print("\t" + Name1);
            String temp1 = Name1;
            j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Out") != null) {
                    one.setout(temp.get("Out"));
                }
                if(temp.get("Strikeout") != null) {
                    one.setstrikeout(temp.get("Strikeout"));
                }
                if(temp.get("Hits") != null) {
                    one.setHit(temp.get("Hits"));
                }
                if(temp.get("Walk") != null) {
                    one.setWalk(temp.get("Walk"));
                }
                if(temp.get("Sac") != null) {
                    one.setSacrafice(temp.get("Sac"));

                }
                if (temp.get("Hit by Pitch") != null) {
                    one.setHitbyPitch(temp.get("Hit by Pitch"));

                }
                if(temp.get("Errors")!= null) {
                    one.setErrors(temp.get("Errors"));
                }
                int denom = (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout());
                if(denom == 0){
                    one.setBattingAverage(0);
                }
                else {
                    one.setOnBase(((float) one.getHit() + one.getWalk() + one.getHitbyPitch()) / (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
                }

                if (max == one.getOnBase() && temp1 != one.getName()) {
                    Name1 = one.getName();
                    System.out.print(", " + Name1);
                    counter++;
                }
                j1++;
            }
            System.out.println();
            if(counter >= 2){
                LeagueLeader = false;
                continue;
            }
            j1=0;
            while(j1 != allnames.size()){
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Out") != null) {
                    one.setout(temp.get("Out"));
                }
                if(temp.get("Strikeout") != null) {
                    one.setstrikeout(temp.get("Strikeout"));
                }
                if(temp.get("Hits") != null) {
                    one.setHit(temp.get("Hits"));
                }
                if(temp.get("Walk") != null) {
                    one.setWalk(temp.get("Walk"));
                }
                if(temp.get("Sac") != null) {
                    one.setSacrafice(temp.get("Sac"));

                }
                if (temp.get("Hit by Pitch") != null) {
                    one.setHitbyPitch(temp.get("Hit by Pitch"));

                }
                if(temp.get("Errors")!= null) {
                    one.setErrors(temp.get("Errors"));
                }
                int denom = (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout());
                if(denom == 0){
                    one.setBattingAverage(0);
                }
                else {
                    one.setOnBase(((float) one.getHit() + one.getWalk() + one.getHitbyPitch()) / (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
                }

                if (max1 < one.getOnBase() && one.getOnBase() != max) {
                    max1 = one.getOnBase();
                    Name1 = one.getName();
                }
                j1++;
            }
            if(max1 != -1){
                System.out.print(String.format("%.3f", max1));
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Out") != null) {
                        one.setout(temp.get("Out"));
                    }
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                    }
                    if(temp.get("Sac") != null) {
                        one.setSacrafice(temp.get("Sac"));

                    }
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));

                    }
                    if(temp.get("Errors")!= null) {
                        one.setErrors(temp.get("Errors"));
                    }
                    int denom = (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout());
                    if(denom == 0){
                        one.setBattingAverage(0);
                    }
                    else {
                        one.setOnBase(((float) one.getHit() + one.getWalk() + one.getHitbyPitch()) / (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
                    }

                    if (max1 == one.getOnBase() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
                System.out.println();
                if (counter >= 1) {
                    LeagueLeader = false;
                    continue;
                }
                j1 =0;
                while(j1 != allnames.size()) {
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Out") != null) {
                        one.setout(temp.get("Out"));
                    }
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                    }
                    if(temp.get("Sac") != null) {
                        one.setSacrafice(temp.get("Sac"));

                    }
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));

                    }
                    if(temp.get("Errors")!= null) {
                        one.setErrors(temp.get("Errors"));
                    }
                    int denom = (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout());
                    if(denom == 0){
                        one.setBattingAverage(0);
                    }
                    else {
                        one.setOnBase(((float) one.getHit() + one.getWalk() + one.getHitbyPitch()) / (one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));
                    }
                    if (max2 < one.getOnBase() && max != one.getOnBase() && max1 != one.getOnBase() && temp1 != one.getName()) {
                        max2 = one.getOnBase();
                        Name1 = one.getName();
                    }
                    j1++;
                }
                System.out.print(String.format("%.3f", max2));
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Out") != null) {
                        one.setout(temp.get("Out"));
                    }
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                    }
                    if(temp.get("Sac") != null) {
                        one.setSacrafice(temp.get("Sac"));

                    }
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));

                    }
                    if(temp.get("Errors")!= null) {
                        one.setErrors(temp.get("Errors"));
                    }
                    one.setOnBase(((float)one.getHit() + one.getWalk() + one.getHitbyPitch())/(one.getHit() + one.getWalk() + one.getHitbyPitch() + one.getstrikeout() + one.getSacrafice() + one.getout()));

                    if (max2 == one.getOnBase() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
            }
            System.out.println();
            LeagueLeader = false;
        }
        //TODO FOCUS ON HITS 
        LeagueLeader = true;
        while(LeagueLeader == true){ //this is for Hits
            int max = -1;
            int counter = 0;
            int max1 = -1;
            int max2 = -1;
            String Name1 = "";
                    

            int j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Hits") != null) {
                    one.setHit(temp.get("Hits"));
                }
                if (max < one.getHit()) {
                    max = one.getHit();
                    Name1 = one.getName();
                }
                j1++;
            }
            System.out.print("\n");
            System.out.println("HITS");
            System.out.print (max);
            System.out.print("\t" + Name1);
            String temp1 = Name1;
            j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Hits") != null) {
                    one.setHit(temp.get("Hits"));
                }
                if (max == one.getHit() && temp1 != one.getName()) {
                    Name1 = one.getName();
                    System.out.print(", " + Name1);
                    counter++;
                }
                j1++;
            }
            System.out.println();
            if(counter >= 2){
                LeagueLeader = false;
                continue;
            }
            j1=0;
            while(j1 != allnames.size()){
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Hits") != null) {
                    one.setHit(temp.get("Hits"));
                }
                if (max1 < one.getHit() && one.getHit() != max) {
                    max1 = one.getHit();
                    Name1 = one.getName();
                }
                j1++;
            }
            if(max1 != -1){
                System.out.print(max1);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if (max1 == one.getHit() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
                System.out.println();
                if (counter >= 1) {
                    LeagueLeader = false;
                   continue;
                }
                j1 =0;
                while(j1 != allnames.size()) {
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if (max2 < one.getHit() && max != one.getHit() && max1 != one.getHit() && temp1 != one.getName()) {
                        max2 = one.getHit();
                        Name1 = one.getName();
                    }
                    j1++;
                }
                System.out.print(max2);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Hits") != null) {
                        one.setHit(temp.get("Hits"));
                    }
                    if (max2 == one.getHit() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
            }
            System.out.println();
            LeagueLeader = false;
        }
        LeagueLeader = true;
        while(LeagueLeader == true){ //this is for Walk
            int max = -1;
            int counter = 0;
            int max1 = -1;
            int max2 = -1;
            String Name1 = "";


            int j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Walk") != null) {
                    one.setWalk(temp.get("Walk"));
                }
                if (max < one.getWalk()) {
                    max = one.getWalk();
                    Name1 = one.getName();
                }
                j1++;
            }
            System.out.print("\n");
            System.out.println("WALKS");
            System.out.print (max);
            System.out.print("\t" + Name1);
            String temp1 = Name1;
            j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Walk") != null) {
                    one.setWalk(temp.get("Walk"));
                }
                if (max == one.getWalk() && temp1 != one.getName()) {
                    Name1 = one.getName();
                    System.out.print(", " + Name1);
                    counter++;
                }
                j1++;
            }
            System.out.println();
            if(counter >= 2){
                LeagueLeader = false;
                continue;
            }
            j1=0;
            while(j1 != allnames.size()){
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Walk") != null) {
                    one.setWalk(temp.get("Walk"));
                }
                if (max1 < one.getWalk() && one.getWalk() != max) {
                    max1 = one.getWalk();
                    Name1 = one.getName();
                }
                j1++;
            }
            if(max1 != -1){
                System.out.print(max1);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                    }
                    if (max1 == one.getWalk() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
                System.out.println();
                if (counter >= 1) {
                    LeagueLeader = false;
                    continue;
                }
                j1 =0;
                while(j1 != allnames.size()) {
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                    }
                    if (max2 < one.getWalk() && max != one.getWalk() && max1 != one.getWalk() && temp1 != one.getName()) {
                        max2 = one.getWalk();
                        Name1 = one.getName();
                    }
                    j1++;
                }
                System.out.print(max2);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Walk") != null) {
                        one.setWalk(temp.get("Walk"));
                    }
                    if (max2 == one.getWalk() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
            }
            System.out.println();
            LeagueLeader = false;
        }
        LeagueLeader = true;
        while(LeagueLeader == true){ //this is for strikeout
            int max = 100;
            int counter = 0;
            int max1 = 100;
            int max2 = 100;
            String Name1 = "";


            int j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Strikeout") != null) {
                    one.setstrikeout(temp.get("Strikeout"));
                }
                if (max > one.getstrikeout()) {
                    max = one.getstrikeout();
                    Name1 = one.getName();
                }
                j1++;
            }
            System.out.print("\n");
            System.out.println("STRIKEOUTS");
            System.out.print (max);
            System.out.print("\t" + Name1);
            String temp1 = Name1;
            j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Strikeout") != null) {
                    one.setstrikeout(temp.get("Strikeout"));
                }
                if (max == one.getstrikeout() && temp1 != one.getName()) {
                    Name1 = one.getName();
                    System.out.print(", " + Name1);
                    counter++;
                }
                j1++;
            }
            System.out.println();
            if(counter >= 2){
                LeagueLeader = false;
                continue;
            }
            j1=0;
            while(j1 != allnames.size()){
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if(temp.get("Strikeout") != null) {
                    one.setstrikeout(temp.get("Strikeout"));
                }
                if (max1 > one.getstrikeout() && one.getstrikeout() != max) {
                    max1 = one.getstrikeout();
                    Name1 = one.getName();
                }
                j1++;
            }
            if(max1 != -1){
                System.out.print(max1);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if (max1 == one.getstrikeout() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
                System.out.println();
                if (counter >= 1) {
                    LeagueLeader = false;
                    continue;
                }
                j1 =0;
                while(j1 != allnames.size()) {
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if (max2 > one.getstrikeout() && max != one.getstrikeout() && max1 != one.getstrikeout() && temp1 != one.getName()) {
                        max2 = one.getstrikeout();
                        Name1 = one.getName();
                    }
                    j1++;
                }
                System.out.print(max2);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if(temp.get("Strikeout") != null) {
                        one.setstrikeout(temp.get("Strikeout"));
                    }
                    if (max2 == one.getstrikeout() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
            }
            System.out.println();
            LeagueLeader = false;
        }
        LeagueLeader = true;
        while(LeagueLeader == true){ //this is for hit by pitch
            int max = -1;
            int counter = 0;
            int max1 = -1;
            int max2 = -1;
            String Name1 = "";


            int j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if (temp.get("Hit by Pitch") != null) {
                    one.setHitbyPitch(temp.get("Hit by Pitch"));

                }
                if (max < one.getHitbyPitch()) {
                    max = one.getHitbyPitch();
                    Name1 = one.getName();
                }
                j1++;
            }
            System.out.println();
            System.out.println("HIT BY PITCH");
            System.out.print (max);
            System.out.print("\t" + Name1);
            String temp1 = Name1;
            j1 = 0;
            while(j1 != allnames.size()) {
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if (temp.get("Hit by Pitch") != null) {
                    one.setHitbyPitch(temp.get("Hit by Pitch"));

                }
                if (max == one.getHitbyPitch() && temp1 != one.getName()) {
                    Name1 = one.getName();
                    System.out.print(", " + Name1);
                    counter++;
                }
                j1++;
            }
            System.out.println();
            if(counter >= 2){
                LeagueLeader = false;
                continue;
            }
            j1=0;
            while(j1 != allnames.size()){
                Player one = new Player();
                one.setName(allnames.get(j1));
                GenericHashMap<String, Integer> temp = All.get(one.getName());
                if (temp.get("Hit by Pitch") != null) {
                    one.setHitbyPitch(temp.get("Hit by Pitch"));

                }
                if (max1 < one.getHitbyPitch() && one.getHitbyPitch() != max) {
                    max1 = one.getHitbyPitch();
                    Name1 = one.getName();
                }
                j1++;
            }
            if(max1 != -1){
                System.out.print(max1);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));

                    }
                    if (max1 == one.getHitbyPitch() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
                System.out.println();
                if (counter >= 1) {
                    LeagueLeader = false;
                    continue;
                }
                j1 =0;
                while(j1 != allnames.size()) {
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));

                    }
                    if (max2 < one.getHitbyPitch() && max != one.getHitbyPitch() && max1 != one.getHitbyPitch() && temp1 != one.getName()) {
                        max2 = one.getHitbyPitch();
                        Name1 = one.getName();
                    }
                    j1++;
                }
                System.out.print(max2);
                System.out.print("\t" + Name1);
                temp1 = Name1;
                j1 = 0;
                while(j1 != allnames.size()){
                    Player one = new Player();
                    one.setName(allnames.get(j1));
                    GenericHashMap<String, Integer> temp = All.get(one.getName());
                    if (temp.get("Hit by Pitch") != null) {
                        one.setHitbyPitch(temp.get("Hit by Pitch"));

                    }
                    if (max2 == one.getHitbyPitch() && temp1 != one.getName()) {
                        Name1 = one.getName();
                        System.out.print(", " + Name1);
                        counter++;
                    }
                    j1++;
                }
            }
            System.out.println();
            LeagueLeader = false;
        }
       Userinput.close(); //Closing my file
   }

}
