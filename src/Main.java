public class Main {
    public static void main(String[] args) {
      
        String file = "Avalanche_test.txt";

        System.out.println("###### 8bit hash ######");
        System.out.println();

        Hasher.processFile(file);
        System.out.println();
        Hasher.testUniformity(file);
        System.out.println();
        Hasher.testAvalanche(file);

        System.out.println();
        System.out.println("###### Improved 8bit hash ######");
        System.out.println();


        Hasher.processFileImproved(file);
        System.out.println();
        Hasher.testUniformityImproved(file);
        System.out.println();
        Hasher.testAvalancheImproved(file);
    }
}