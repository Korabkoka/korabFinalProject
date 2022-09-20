public class test {

    public static void main(String[] args)
    {
        String word = "Paulina";
        System.out.println("CharAT(0): "+word.charAt(0));
        System.out.println("indexOf ulina :"+ word.indexOf("ulina"));
        System.out.println("index of a from index of 2 : "+ word.indexOf("a",2));
        print(word.substring(1));
        print(word.substring(1,5));
        print(word.substring(3,7));

    }
    public static void print(String print)
    {
        System.out.println(print);
    }
}
