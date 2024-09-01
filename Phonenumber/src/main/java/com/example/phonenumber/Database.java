package com.example.phonenumber;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database {
    /*
    اینحا یه ملاس بریا ذخیره اطلاعات درست کردم
    و توش یه آرایه بریا گرفتن مخاظبین درست کردم
    * */
    static ArrayList<Contact> contacts= new ArrayList<>();
    //یه متود بولین برای برسی و گرفتن مخاطبین درست کردم
    public static boolean EContact(Contact contact) {
        /*
        یه حلقه درست کردم که میاد آرایه مخاطبین رو با c اسم میزاره
        و میاد و برسی میکنه مه اول اگر اسم رو گرفت و در نیم جای گذاری کرد بیاد بگه true چون boolean هست
        * */
        for (Contact c:contacts) {
            if(c.getName().equals(contact.getName()) && c.getPhonenumber().equals(contact.getPhonenumber())) {
                return true;
            }
            //return false;
        }
        //در غیر این صورت بیاد بگه false
        return false;
    }
    public static void delete(Contact contact) throws IOException {
        contacts.remove(contact);
        write();
    }
    public static ArrayList<Contact> getContacts(String text){
        if (text==null || text.equals("")){
            return contacts;
        }
        ArrayList<Contact> contactList = new ArrayList<>();
        for (Contact c: contacts){
        if(c.getName().toLowerCase().contains(text.toLowerCase())){
            contactList.add(c);
        }
        }
        return contactList;
    }
    public static Contact editContact = null;

    /*
    یه متو تعریف کردمکه فایل توی خودش ذخیره کنه و توی یه فایل مخاطبین با پسوند ای اکس تی ذخیره کنه
    * */
    public static void write() throws IOException {
        //فایل رایتر رو فراخانی کردم
        FileWriter fileWriter = new FileWriter("Contact.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact c:contacts){

            stringBuilder.append(c.toString()+"\n");
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }
    public static void read() throws IOException {
        // یه متود برای خواندن فایل ها درست کردم و که میاد اطلاعات رو از روی فایل contacts.txt میخونه و نشان میده و توی contacts اضافه میکنه و این همین جوری ادامه پیدا میکند تا وقتی که تموم شود
        FileReader fileReader = new FileReader("Contact.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            contacts.add(new Contact(s));
        }
        fileReader.close();
    }
    //این تابع یک شیء از نوع Contact را گرفته و اطلاعات آن را به یک فایل متنی به نام "Contacts.txt" ذخیره
    public static void savatofile(Contact contact) throws IOException {
        FileWriter fileWriter = new FileWriter("Contact.txt" ,true);
        fileWriter.append(contact.toString()+"\n");
        fileWriter.close();
    }
    public static void edit(Contact contact1,Contact contact2){
        for (int i = 0 ; i <contacts.size();i++){
            if(contacts.get(i).equals(contact1)){
                contacts.set(i,contact2);
            }
        }
    }


}

