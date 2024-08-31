
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
    private static int totalPopulation;
    private static int totalMale;
    private static int totalFemale;
    private static int totalOtherGender;
    private static Random random = new Random();

    private String fName;
    private String mName;
    private String lName;
    private String dof;
    private String birthPlace;
    private String birthCfNumber;
    private String birthCountry;
    private int age;
    private String gender;
    private String city;
    private String state;
    private String postCode;
    private String cAddress;
    private String pAddress;
    private String nationality;
    private String bloodGroup;
    private List<String> phoneNumbers = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    private Person father;
    private Person mother;

    public Person(String fastName, String midName,String lastName, String dateOfBirth, 
                String birthPlace, String birthCountry, String gender){
            
        this.fName = fastName;
        this.mName = midName;
        this.lName = lastName;
        this.dof = dateOfBirth;
        this.birthPlace = birthPlace;
        this.birthCountry = birthCountry;

        if(isValidGender(gender)){
            this.gender = gender;
        }else{
            throw new CustomException.InvalidGenderException();
        }
        
        population();
    }

    private static boolean isValidGender(String gender) {
        if (gender.equals("male") || gender.equals("female") || gender.equals("other"))
            return true;

        else return false;
    }

    private static boolean isValidBloodGroup(String type) {
        if (type.equals("A+") || type.equals("A-") || type.equals("B+") || type.equals("B-") || 
            type.equals("O+") || type.equals("O-") || type.equals("AB+") || type.equals("AB-")){

                return true;
            }

        else return false;
    }

    private void population(){
        totalPopulation++;

        if(gender.equals("male")){
            totalMale++;
        }else if(gender.equals("female")){
            totalFemale++;
        }else{
            totalOtherGender++;
        }
    }

    private boolean filledAddresses(){
        if(city == null || state == null || postCode == null 
            || cAddress == null || pAddress == null || nationality == null){
                return false;
            }

        return true;
    }

    public void setPersonalInfo(String city,String state,String postCode, String currentAddress, 
                String parmanentAddress, String nationality, String phoneNumber, String email){
        
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.cAddress = currentAddress;
        this.pAddress = parmanentAddress;
        this.nationality = nationality;

        this.phoneNumbers.add(phoneNumber);
        this.emails.add(email);
    }

    public void setAddress(String city,String state,String postCode,
                String currentAddress, String parmanentAddress, String nationality){
        
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.cAddress = currentAddress;
        this.pAddress = parmanentAddress;
        this.nationality = nationality;
    }

    private static String genUniqueBirthCfNumber(){
        String uniqueNumber = Integer.toString(random.nextInt(100000000, 999999999));
        return uniqueNumber;
    }
    
    public String issueBirthCertificate(Person father, Person mother,String bloodGroup){
        if(!isValidBloodGroup(bloodGroup)){
            throw new CustomException.InvalidBloodException();
        }
        if(!filledAddresses()){
            throw new CustomException.AddressException();
            
        }

        this.father = father;
        this.mother = mother;
        this.bloodGroup = bloodGroup;
        birthCfNumber = genUniqueBirthCfNumber();
        return birthCfNumber;
    }

}
