/*
The Vaccine Class creates a single Vaccination data entry to store 
the country, date and number of vaccinations values for each data entry.

The class includes the parameterised constructor, the default constructor, 
the setters and getters of the 3 variables, a toString output and a compareTo method.

*/
public class Vaccine implements Comparable<Vaccine>{
    // String variables for country, date and number of vaccinations
    private String country, date, vaccinations;

    //Parameterised Constructors
    public Vaccine(String country, String date, String vaccinations){
        this.country = country;
        this.date = date;
        this.vaccinations = vaccinations;
    }

    public Vaccine(String country, String date){
        this.country = country;
        this.date = date;
        this.vaccinations = "0";
    }

    //Default Constructor
    public Vaccine(){

    }

    //Setters & Getters
    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public String getVaccincations() {
        return vaccinations;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }

    //toString Method
    public String toString(){
        String output = "Date: "+date+", Country: "+country+", Vaccinations: "+vaccinations;
        return output;
    }

    //compareTo Method
    public int compareTo(Vaccine v){
        return (country+date).compareTo(v.country+v.date);
    }

}