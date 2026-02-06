import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Hasher {
    /**
     * Hashes any string to a fixed 8-bit value (0-255).
     */
    public static int get8BitHash(String input) {
        int hashSum = 0;
        
        for (int i = 0; i < input.length(); i++) {
            hashSum += input.charAt(i);
        }
        
        // Ensures the result stays within 0-255
        return hashSum % 256;
    }

    /**
     * Hashes any string to a fixed 8-bit value (0-255).
     * Improvement: Multiplies each ASCII value by a prime number (31) before
     * adding it to the sum.
     */
    public static int get8BitHashImproved(String input) {
        int hashSum = 0;
        
        for (int i = 0; i < input.length(); i++) {
            hashSum = (hashSum * 31) + input.charAt(i);
        }
        
        return hashSum % 256 & 0xFF;
    }

    /**
     * Read a file and performs the hashing of the normal 8bit hash function.
     */
    public static void processFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineCount = 1;
            
            while ((line = br.readLine()) != null) {
                int hash = get8BitHash(line);
                System.out.println("Line " + lineCount + ": [" + line + "] -> Hash: " + hash);
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Read a file and performs the hashing using the improved 8bit hash function.
     */
    public static void processFileImproved(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineCount = 1;
            
            while ((line = br.readLine()) != null) {
                int hash = get8BitHashImproved(line);
                System.out.println("Line " + lineCount + ": [" + line + "] -> Hash: " + hash);
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * List the uniformity distribution of the 8bit hash.
     */
    public static void testUniformity(String fileName) {
        int[] buckets = new int[256];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int hash = get8BitHash(line);
                buckets[hash]++;
            }
        } catch (IOException e) { e.printStackTrace(); }

        System.out.println("--- Uniformity Test Results ---");

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > 0) {
                System.out.println("Bucket " + i + ": " + buckets[i] + " hits");
            }
        }
    }

    /**
     * List the uniformity distribution of the improved 8bit hash.
     */
    public static void testUniformityImproved(String fileName) {
        int[] buckets = new int[256];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int hash = get8BitHashImproved(line);
                buckets[hash]++;
            }
        } catch (IOException e) { e.printStackTrace(); }

        System.out.println("--- Uniformity Test Results ---");

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > 0) {
                System.out.println("Bucket " + i + ": " + buckets[i] + " hits");
            }
        }
    }

    /**
     * Lists the average bits flipped and lists the percentage for the 8bit hash.
     */
    public static void testAvalanche(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        double totalBitFlips = 0;
        int pairCount = 0;

        while ((line = br.readLine()) != null) {
            String nextLine = br.readLine(); 
            if (nextLine == null) break;

            int hash1 = get8BitHash(line);
            int hash2 = get8BitHash(nextLine);

            // XOR finds the difference, then counts the flips
            int flips = Integer.bitCount((hash1 ^ hash2) & 0xFF);
            totalBitFlips += flips;
            pairCount++;
        }

        double avgFlips = totalBitFlips / pairCount;
        double probability = (avgFlips / 8) * 100;

        System.out.println("--- Avalanche Test Results ---");
        System.out.println("Average bits flipped: " + avgFlips + " out of 8");
        System.out.println("Probability: " + probability + "%");
        
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Lists the average bits flipped and lists the percentage for the improved 8bit hash.
     */
    public static void testAvalancheImproved(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        double totalBitFlips = 0;
        int pairCount = 0;

        while ((line = br.readLine()) != null) {
            String nextLine = br.readLine(); 
            if (nextLine == null) break;

            int hash1 = get8BitHashImproved(line);
            int hash2 = get8BitHashImproved(nextLine);

            // XOR finds the difference, then counts the flips
            int flips = Integer.bitCount((hash1 ^ hash2) & 0xFF);
            totalBitFlips += flips;
            pairCount++;
        }

        double avgFlips = totalBitFlips / pairCount;
        double probability = (avgFlips / 8) * 100;

        System.out.println("--- Avalanche Test Results ---");
        System.out.println("Average bits flipped: " + avgFlips + " out of 8");
        System.out.println("Probability: " + probability + "%");
        
        } catch (IOException e) { e.printStackTrace(); }
    }
}
