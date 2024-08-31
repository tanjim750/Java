
import java.util.ArrayList;
import java.util.List;

public class Person {
    private static int totalPopulation;
    private static int totalMale;
    private static int totalFemale;
    private static int totalOtherGender;

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
        this.gender = gender;
        
        population(this.gender);
    }

    private static void population(String gender){
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
        return (city == null && state == null && postCode == null 
            && cAddress == null && pAddress == null && nationality == null);
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
    
    public void issueBirthCertificate(){
        if(filledAddresses()){
            
        }
    }

}
