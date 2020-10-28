import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //System.out.println(GymMethods.isMember("Diamanda Djedi"));

        Scanner sc = new Scanner(System.in);
        String visitor;
        String visitorMem;
        while (true){
            System.out.println("Type customer name or personal identification number");
             visitor = sc.nextLine();
             if (visitor.equals("exit")){
                 break;
             }
             visitorMem = GymMethods.isMember(visitor);
             if (visitorMem.charAt(0) == 'c'){
                 GymMethods.sessionLogger(visitorMem.substring(1));
                 System.out.println("Session logged");
             }
             else if (visitorMem.charAt(0) == 'p'){
                 System.out.println(visitor + " is a previous member of the gym");
             }
             else{
                 System.out.println(visitor + " has never been a member of the gym");
             }
        }
    }

}
