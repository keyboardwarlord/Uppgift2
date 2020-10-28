import java.io.*;
import java.time.LocalDate;

public class GymMethods {

    static String isMember(String personId){
        String lastPaid;
        String personalInfo;

        try{
            BufferedReader bufIn = new BufferedReader(new FileReader("customers.txt"));
            while (true){
                personalInfo = bufIn.readLine().trim();
                if (personalInfo.length() == 0){
                    break;
                }
                lastPaid = bufIn.readLine().trim();

                if (personId.equals(personalInfo.substring(0,10)) ||
                        personId.equals(personalInfo.substring((personalInfo.length()-personId.length())))){

                    LocalDate currentDate = LocalDate.now();
                    LocalDate lastPaidDate = LocalDate.parse(lastPaid);
                    if (currentDate.isBefore(lastPaidDate.plusYears(1))){
                        return("c" + personalInfo);
                    }else{
                        return("p");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to check if person is a member of the gym");
        }
        return ("n");
    }



    public static void sessionLogger(String persNumName){

        try{
            BufferedWriter customerFileWriter = new BufferedWriter(new FileWriter(persNumName + ".txt", true));
            customerFileWriter.append(LocalDate.now().toString() + "\n");
            customerFileWriter.close();
        } catch (Exception e) {
            System.out.println("Session logging failed");
        }
    }

}

