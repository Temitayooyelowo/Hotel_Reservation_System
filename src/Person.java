public abstract class Person {
    private String emailAddress;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String phoneNumber;

    //Get methods
    public String getTitle() {return title;}
    public String getFirstName(){return firstName;}
    public String getMiddleName() {return middleName;}
    public String getLastName() {return lastName;}
    public int getAge(){return age;}
    public String getEmailAddress() {return emailAddress;}
    public String getPhoneNumber() {return phoneNumber;}

    //Set methods
    public void setTitle(String title) {this.title = title;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setAge(int age) {this.age = age;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public void setPhoneNumber(String p){this.phoneNumber = p;}

    //Zero Parameter Constructor
    public Person(){
        this.title = "";
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.age = -1;
        this.emailAddress = "";
        this.phoneNumber = "";
    }

    //Multiple Argument Constructor
    public Person(String title, String firstName, String middleName, String lastName, int age, String email, String phoneNum){
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = email;
        this.phoneNumber = phoneNum;
    }

    public String toString(){
        return title + " " + firstName + " " + middleName + " " + lastName + " is " + age + " years old";
    }
}