import java.io.*;

public class main {
    public static void main(String args[]) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("output.txt");

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;

        try {
            br1 = new BufferedReader(new FileReader(file1));
            br2 = new BufferedReader(new FileReader(file2));
            bw = new BufferedWriter(new FileWriter(file3));

            String line1;
            String line2;

            while ((line1 = br1.readLine()) != null) {
                String[] words1 = line1.split(" ");
                String id1 = words1[0].trim();
                String name = words1[1].trim();

                System.out.println("Processing line from file1: " + id1 + " " + name);

                boolean found = false;
                while ((line2 = br2.readLine()) != null) {
                    String[] words2 = line2.split(" ");
                    String id2 = words2[0].trim();
                    String age = words2[1].trim();

                    System.out.println("Comparing with line from file2: " + id2 + " " + age);

                    if (id1.equals(id2)) {
                        bw.write(id1 + ", " + name + ", " + age);
                        bw.newLine();
                        found = true;
                        System.out.println("Match found: Writing to output file");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No match found for ID: " + id1);
                }

                // Reset br2 pointer to the beginning of file2 for next iteration
                br2.reset();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        } finally {
            try {
                if (br1 != null) br1.close();
                if (br2 != null) br2.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.err.println("Error closing files: " + e.getMessage());
            }
        }
    }
}