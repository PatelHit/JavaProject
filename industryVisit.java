import java.util.*;

class details {

    String academicYear;
    int monthOfVisit;
    String nameOfIndustry;
    String locationOfIndustry;
    int maleStudents;
    int femaleStudents;

    Scanner sc = new Scanner(System.in);

    void getInformation() {
        System.out.print("Academic year of visit is :");
        academicYear = sc.nextLine();
        System.out.print("Name of Industy :");
        nameOfIndustry = sc.nextLine();
        System.out.print("Location of Industy :");
        locationOfIndustry = sc.nextLine();
        System.out.print("Number  of male student which came to visit :");
        maleStudents = sc.nextInt();
        System.out.print("Number of female student which came to visit :");
        femaleStudents = sc.nextInt();
    }
}

public class industryVisit {

    public static void main(String args[]) {

        ArrayList<ArrayList<details>> Allsem = new ArrayList<ArrayList<details>>(8);
        for (int i = 0; i < 8; i++) {
            ArrayList<details> allDetails = new ArrayList<details>();
            Allsem.add(allDetails);
        }

        Scanner scn = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.print("Semester of industry visit: ");
            int sem = scn.nextInt();
            // Allsem.add(sem-1, allDetails);
            Allsem.get(sem - 1).add(new details());
            Allsem.get(sem - 1).get((Allsem.get(sem - 1).size() - 1)).getInformation();
            // allDetails.add(new details());
            // allDetails.get(cur).getInformation();
            System.out.print("Do you want to add more(if yes 1 else 0): ");
            int choice = scn.nextInt();
            if (choice == 0) {
                exit = true;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (Allsem.get(i).size() > 0) {

                int totalMale = 0;
                int totalFemale = 0;

                System.out.println("Semester " + (i + 1));
                System.out.println("Total Number of Industry visited : " + Allsem.get(i).size());

                System.out.println("Name of Industries: ");
                for (int j = 0; j < Allsem.get(i).size(); j++) {
                    totalMale += Allsem.get(i).get(j).maleStudents;
                    totalFemale += Allsem.get(i).get(j).femaleStudents;

                    System.out.println(Allsem.get(i).get(j).nameOfIndustry);
                }
                System.out.println("Total no. of male students for semester: " + totalMale);
                System.out.println("Total no. of female students for semester: " + totalFemale);
            }
        }

    }

}