
public class App {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Tanjim", "", "Abubokor",
         "15/11/2001", "Mymenshing", "BANGLADESH", "male");

        Person p2 = new Person("Md", "Makbul", "Hossaing",
         "15/11/2001", "Mymenshing", "BANGLADESH", "male");

        Person p3 = new Person("Nargis", "", "Akter",
         "15/11/2001", "Mymenshing", "BANGLADESH", "male");
        
        String id = p1.issueBirthCertificate(p2, p3,"A+");
        System.out.println(id);
    }
}
