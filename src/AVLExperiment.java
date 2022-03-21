/*



*/
import java.util.*;
import java.io.*;
public class AVLExperiment {
    private Vaccine[] vaccinations_array;
    private int vaccinations_count;
    private static AVLTree<Vaccine> avlTree = new AVLTree<Vaccine>();
    //Set true to test using randomly generated data from python script
    //Set false to use standard code
    private Boolean TESTING = true;

    public static void main(String[] args) {
        new AVLExperiment(args);
    }

    public AVLExperiment(String[] args){
        vaccinations_array = new Vaccine[9919];
        vaccinations_count = 0;

        try {
            //Scanner Function 
            Scanner sc = new Scanner(new File("data/vaccinations.csv"));

            while (sc.hasNextLine()) {
                String[] variables = sc.nextLine().split(",");
                String country = variables[0];
                String date = variables[1];
                String vaccincations = "0";
                if (variables.length == 3)
                    vaccincations = variables[2];
                vaccinations_array[vaccinations_count] = new Vaccine(country, date, vaccincations);
                vaccinations_count++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        if(TESTING == true){

            int[] random = new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
            
            for(int i = 0; i <random.length; i++){
                Vaccine[] randomize_array = randomize(vaccinations_array, random[i]);
            
                //showResults(vaccinations_array);

                for(int j = 0; j <randomize_array.length; j++){
                    avlTree.insert(randomize_array[j]);
                }

                System.out.println("("+random[i]+") Insert Operation Count for: "+avlTree.getInsertOpCount());
            }


        }else{
            int degree_randomization = Integer.parseInt(args[0]);
            Vaccine[] randomize_array = randomize(vaccinations_array, degree_randomization);
            
            //showResults(vaccinations_array);

            for(int i = 0; i <randomize_array.length; i++){
                avlTree.insert(randomize_array[i]);
            }

            System.out.println("Insert Operation Count: "+avlTree.getInsertOpCount());

            // for(int i = 0; i <vaccinations_array.length; i++){
            //     avlTree.search(vaccinations_array[i]);
            // }
        }

    }  

    public Vaccine[] randomize(Vaccine[] array, int degree_randomization){
        for(int i = 0; i < degree_randomization; i++){
            for(int j = 0; j < array.length; j++){
                for(int k = 0; k < array.length -1; k++){
                    Vaccine temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                }
            }
        }
        return array;
    }

    public void showResults(Vaccine[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i].toString());
        }
    }

}
