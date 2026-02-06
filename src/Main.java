public class Main {
    public static void main(String[] args) {
        ConsoleIO input = new ConsoleIO();

        String filename = input.getFilename();
        String function = input.chooseHashFunction();

        if (function.equals("F")) {
            Hasher.processFile(filename);
        } else {
            Hasher.processFileImproved(filename);
        }
    
        // ### FOR TESTING ###
        
        // System.out.println("###### 8bit hash ######");
        // System.out.println();

        // Hasher.processFile(filename);
        // System.out.println();
        // Hasher.testUniformity(filename);
        // System.out.println();
        // Hasher.testAvalanche(filename);

        // System.out.println();
        // System.out.println("###### Improved 8bit hash ######");
        // System.out.println();


        // Hasher.processFileImproved(filename);
        // System.out.println();
        // Hasher.testUniformityImproved(filename);
        // System.out.println();
        // Hasher.testAvalancheImproved(filename);
    }
}