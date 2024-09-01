package com.example.phonenumber;

public class Contact {
    private String name;
    private String phonenumber;
/*
توی اینجا اول یه کلاس با تام مخاطبین برای گرفتن اسم و شماره تلفن درست
میکنم و دو تا استرینگ درست میکنم با نام های نام های نام و شماره تلفن درست میکنم
* */
/////////////////////////////////////////////
/*
ایجا میام و توی کلاس کانتکت دو چیز رو فراخوانی میکم و به هر دو اسم میدم
* */
    public Contact(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }
//ایتجا هر وقت getname رو بنویسم یه اسم برمیگردونه
    public String getName() {
        return name;
    }
    //اینا اسم رو فراخوانی میکنیم
    public void setName(String name) {
        this.name = name;
    }
//اینجا مثل بالا یه استرینگ داربم که با اسم getphonenumber که هروقت فراخوانیش میکنیم یه خودش رو برمیگردونه
    public String getPhonenumber() {
        return phonenumber;
    }
//اینحا دقیق مثل بالا هست
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    //اینجا داریم از تو استریگ برای سیو کردن اسم و شماره تلفن توی حافطه استفاه میکنیم و بین اسم و شماره همراه یه , میزاره و توی یه فایل contact.txt سیو میکنه
    public String toString() {
        return name+","+phonenumber;
    }
    //کلاس مخاطبین رو فراخانی میکنیم و توش یه آرایه تعریف میکنیم و این آرایه میاد توی ایندکس 0 خودش نام رو ذخیره میکنه و توی ایندکس 1 خودش شماره تلفن رو ذخیره میکنه و بین هر کدوم یه ,میزاره
    public Contact(String line){
        String[] array = line.split(",");
        this.name = array[0];
        this.phonenumber = array[1];
    }
}
