package Tek_UI_BDD_FrameWork.DataGenerators;

public class DataGenerator {

    public static String get_Email(){
        int random = (int) (Math.random() * 214);
        return "afzalifarzana" + random + "gmail.com";
    }
}
