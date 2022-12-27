package edu.umb.cs680.hw10.fs.util;
public class EncryptedString {
    /*This class technically should return an encrypted string when it's constructor is called, but here for simplicity 
    I have just returned the string as it is, since encryption logic was not required in this assignment*/
    private static String pwd;
    public EncryptedString(String passwordString){
        EncryptedString.pwd=passwordString;
    }
    public String getPwd(){
        return pwd;
    }

     public static void main(String[] args) {
       EncryptedString Estr= new EncryptedString("TestPassword"); 
       String temp= Estr.getPwd(); 
       System.out.println(temp);
    }
}