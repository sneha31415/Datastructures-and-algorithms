package C8_Hashmaps;

public class mapUse {
    public static void main(String[] args) {
            map <String, Integer> testmap = new map<String, Integer>();
            for(int i=0; i<20; i++){
                testmap.insert("abc"+i, i+1);
                //visualisation of how rehashing is done according with the load factor
                System.out.println("i = " + i + "  if loadfactor = " + testmap.loadFactor());
            }
                testmap.removeKey("abc4");
                testmap.removeKey("abc5");
            for(int i=0; i<20; i++){
                System.out.println("abc" + i + ":" + testmap.get_value("abc"+i));
            }

    }
}
