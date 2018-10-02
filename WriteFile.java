import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class writes results of tests to a file at the location
 * specified as the first command line argument. 
 * It has one method for writing to a file, which takes two 
 * String args to write the output statement in human readable form 
 * 
 */

public class WriteFile {

    /*
     * This method takes inputs String, String to write the results statement to
     * file.
     * 
     * @input: outFileLocation is the file name for the output file
     * @input: results is the input string to be printed
     * 
     * @returns: none
     * 
     * @end state: a file is written that contains the results for all test matrices
     * in all input files. This method appends to files if the already exist, and
     * creates a new one if it does not
     */
    public void writeFile(String outputSpot, String results)
    {
        BufferedWriter writer = null;
        FileWriter newWriter;

        try {
            String outputRes = results;
            File outFile = new File(outputSpot);

            // create file if doesn't already exist
            if (!outFile.exists()) {
                outFile.createNewFile();
            }

            newWriter = new FileWriter(outFile, true);
            writer = new BufferedWriter(newWriter);
            writer.write(outputRes);
            writer.flush();
            writer.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    
    /*@overload
     * Method writes int data to the output file. 
     * If the output file does not exist, one is created.
     * Data is appended, not overwritten.
     * 
     * @endstate: data added to output file.
     */
    public void writeFile(String outputSpot, int results)
    {
        BufferedWriter writer = null;
        FileWriter newWriter;

        try {
            int outputRes = results;
            File outFile = new File(outputSpot);

            // create file if doesn't already exist
            if (!outFile.exists()) {
                outFile.createNewFile();
            }

            newWriter = new FileWriter(outFile, true);
            writer = new BufferedWriter(newWriter);
            writer.write(outputRes);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    
    /* Utility method for formatting - instert line - in ouptput file*/
    public void writeLine(String outputSpot)
    {
        BufferedWriter writer = null;
        FileWriter newWriter;

        try {
            File outFile = new File(outputSpot);

            // create file if doesn't already exist
            if (!outFile.exists()) {
                outFile.createNewFile();
            }

            newWriter = new FileWriter(outFile, true);
            writer = new BufferedWriter(newWriter);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
