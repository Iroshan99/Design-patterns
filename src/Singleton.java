public class Singleton {

    private static Singleton singleton;

    public static Singleton printObject() {
        return singleton;

    }
    private Singleton(){}

    public static Singleton createInstance(){
        if(singleton == null){
            singleton=new Singleton();
        }
        return singleton;
    }


        public static void main (String[]args){
            System.out.println(printObject());
            System.out.println(createInstance());
            System.out.println(createInstance());


        }

}
