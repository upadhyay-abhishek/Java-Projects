package emailapp;

import java.util.Scanner;

public class Email {
   private String firstName;
   private String lastName;
   private  String email;
   private String password;
   private  String department;
   private  int mailboxCapacity = 500;
   private  String companySuffix="remember.com";
   private String alternateEmail;

   //constructor to receive firstname and last name
    public Email(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;


        //call a method asking for department  --- return the department
        this.department=setDepartment();

        // call a method that returns random password
        this.password=randomPassword(8);
        System.out.println("Password is "+password);


        // combine together to get email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;

    }

    //Ask for department
    private String setDepartment(){
        System.out.print("Department Codes\n1 for sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department code ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice==1){return "sales"; }
        else if (depChoice==2){return "dev";}
        else if(depChoice==3){return "acct";}
        else {return "";}
    }

    //Generate a Random Password
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789abcdefghijklmnopqrstuvwxyz";
        char[] password= new char[length];
        for (int i=0; i<length;i++){
          int rand=  (int)(Math.random()*passwordSet.length());
          password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set mail box capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }
    //set alternate email
    public  void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    public void changePassword(String password){
        this.password=password;
    }

    public int getMailboxCapacity(){ return  mailboxCapacity;}
    public String getAlternateEmail(){ return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "DISPLAY NAME: "+ firstName+" "+lastName+
                "\nCompany Email: "+email+
                "\nMailbox Capacity: "+mailboxCapacity +"mb";
    }
}
