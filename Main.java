
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
abstract class Typeofpizza{
    protected int veg_pizzas = 300;
    protected int Non_veg_pizzas = 400;
    protected boolean cheak_veg=false;
    protected  boolean cheak_topping = false;
    protected  boolean cheak_cheese= false;
    protected  boolean cheak_takeway=false;
    protected int Amount;
    protected int cheese=100;
    protected int Toppings=100;
    protected int Takeaway=20;
    protected int Basepack=0;
    abstract public void cheese();
    abstract public void Topping();
    abstract public void Take_away();
    abstract public void Base_pack();
    abstract public void veg_pizza();
    abstract public void Non_veg_pizza();
    abstract public int get_Toppings();
    abstract public int get_cheese();
    abstract public int get_Amount();
   abstract public int get_veg_pizza_amount();
   abstract public int get_Non_veg_pizza_amount();
   abstract public int get_take_away();
   // cls() is used to clear the the screen
   static public void cls()
{
  System.out.println("\033[2J\033[H");
  System.out.flush();
}
}
// pizza class is  used to select the normal pizza (VEG and Non veg Pizza) and it's exdents the Typesofpizza class
class Pizza extends Typeofpizza{
 

    public Pizza()
    {
    this.Amount=0;
    }
public void veg_pizza()
{
this.Amount+=300;
this.cheak_veg=true;
}
 public void Non_veg_pizza()
{
    this.Amount+=400;
}
public void cheese(){
    this.Amount +=cheese;
    this.cheak_cheese=true;
}
public void Topping(){
    this.Amount +=Toppings;
    this.cheak_topping=true;
}
public void Take_away(){
    this.Amount +=Takeaway;
    this.cheak_takeway=true;
}
public void Base_pack()
{
    this.Amount+=Basepack;
}
public int get_Amount()
{
    return this.Amount;
}
public int get_cheese()
{
    return cheese;

}
public int get_Toppings()
{
    return Toppings;
}
 public int get_veg_pizza_amount(){
    return veg_pizzas;
 }
 public int get_Non_veg_pizza_amount()
 {
    return Non_veg_pizzas;
 }
 public int get_take_away()
 {
    return Takeaway;
 }
}
// dulex_Pizza is class used to select the Dulex pizza(Veg and Non veg) it's also extends the Typsofpizza
class Dulex_Pizza extends Typeofpizza{
    public Dulex_Pizza()
    {
    this.Amount=0;
    }
    public void veg_pizza()
    {
    this.Amount+=400;
    veg_pizzas=400;
    }
     public void Non_veg_pizza()
    {
        this.Amount+=500;
        Non_veg_pizzas=500;
    }
    public void cheese(){
        this.Amount +=cheese;
        this.cheak_cheese=true;
    }
    public void Topping(){
        this.Amount +=Toppings;
        this.cheak_topping=true;
    }
    public void Take_away(){
        this.Amount +=Takeaway;
        this.cheak_takeway=true;
    }
public void Base_pack()
{
    this.Amount+=Basepack;
}
public int get_Amount()
{
    return this.Amount;
}
public int get_cheese()
{
    return cheese;

}
public int get_Toppings()
{
    return Toppings;
}
public int get_veg_pizza_amount()
{
    return veg_pizzas;
}
public int get_Non_veg_pizza_amount()
{
   return Non_veg_pizzas;
}
public int get_take_away()
{
   return Takeaway;
}
}
//Display Bill used to print the bills and Amount and getting the Extra Details
 class Diplay_Bill
 {
    private String Name;
Scanner sc = new Scanner(System.in);
private Typeofpizza type;
private int opt;
private int option;
//get_Details funtion used to get the data form the user(Name and Normal or dulex Pizza)
public void Get_Details()
{
    System.out.println("...............Welcome To Pizza World .................\n");
    System.out.println("Enter Your Name");
    Name= sc.next();
    Typeofpizza.cls();
        while(true)
        {
            
            System.out.println("Enter the Option");
            System.out.println("1.Normal Pizza");
            System.out.println("2.Dulex Pizza");
            System.out.println("3.Exit");
            option = sc.nextInt();
            Typeofpizza.cls();
            if(option ==1)
            {
                type = new Pizza();
                Types(type);
            }
            else if(option ==2)
            {
                type = new Dulex_Pizza();
                Types(type);
            }
            else 
            {
                break;
            }
        }
}
// Types Function used to Select the type of Pizza(Veg or Non veg)
   public void Types(Typeofpizza obj)
   {
    System.out.println("------- You Order pizza------");
    System.out.println(" 1.veg pizza \n 2.Non veg");
    option = sc.nextInt();
    Typeofpizza.cls();
    if(option==1)
    obj.veg_pizza();
    else
    obj.Non_veg_pizza();
    System.out.println("Do you Want To add Extra \n 1.YES \n 2. No");
    opt=sc.nextInt();
    Typeofpizza.cls();
        if(opt==1)
        {
            Extras(type);
            Display_bills(type);
        }
        else if(opt ==2)
        {
            Display_bills(type);
        }
   }
   // Extras method is Used for getting Extras Iteam from the users like (Toopings ,cheese ,Take Away)
    public void Extras(Typeofpizza type)
    {
        do{
                    System.out.println("1.Topping");
                    System.out.println("2.cheese");
                    System.out.println("3.Take Away");
                    System.out.println("4.Noraml Pack");
                    System.out.println("5.Exit");
                     opt = sc.nextInt();
                     switch(opt)
                     {
                        case 1:
                        type.Topping();
                        break;
                        case 2:
                        type.cheese();
                        break;
                        case 3:
                       type.Take_away();
                        break;
                        case 4:
                        type.Base_pack();
                        break;
                     }
                }while(opt!=5);
                Typeofpizza.cls();
    }
//This Display_Bills method for Print the Total amount and Bill
public void Display_bills(Typeofpizza obj2)
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter obj = DateTimeFormatter.ofPattern("hh:mm:a");
        String Time = time.format(obj);
    System.out.println("------------------------------------");
    System.out.println("            Your Bill               " );
    System.out.println("------------------------------------");
    System.out.println("Date : " + date);
    System.out.println("Time : " + Time);
    System.out.println("Name  : "+Name+"\n");
    if(obj2.cheak_veg==true)
    System.out.println("You Ordered Veg Pizza        " + obj2.get_veg_pizza_amount());
    else
    System.out.println("You Ordered Non Veg Pizza    " + obj2.get_Non_veg_pizza_amount());
    if(obj2.cheak_cheese==true)
    {
        System.out.println("Extra Cheese                 " +obj2.get_cheese());
    }
   
    if(obj2.cheak_topping==true)
    {
        System.out.println("Extra Topping                " +obj2.get_Toppings());
    }
    if(obj2.cheak_takeway==true)
    {
    System.out.println("Take Away                    " + obj2.get_take_away());
    }
    System.out.println("------------------------------------");
    System.out.println("Total amount               = " + obj2.get_Amount());
    System.out.println("------------------------------------");
    }
}
class Main{
    public static void main(String[] args) {
     Diplay_Bill obj = new Diplay_Bill(); 
     obj.Get_Details();  
    }
} 