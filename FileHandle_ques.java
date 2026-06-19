import java.io.*;
class FileHandle_ques{
    public static void main(String[] args){
        BufferedReader br = null;
        try{
            FileReader fr = new FileReader("try.txt");
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
        catch(IOException e){
            System.out.println("Error");
        }
        finally{
            try{
                if (br != null){
                    br.close();
                }
            }
            catch(IOException e){
                System.out.println("Error");
            }
        }
    }
}
//arrayindexoutofbound
//nullpointer
//