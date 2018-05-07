import java.io.File;
import javax.activation.MimetypesFileTypeMap;


public class ReadFilesFromFolder 
{

  private String dirName = "";
  private String fileMimeTyepe = "";

  private File folder = new File("");
  private String temp = "";

  public void getTheDirectory(String dir)
  {
      dirName = dir;
  }

  public void getFileMimeType(String mime)
  {
      fileMimeTyepe = mime;
  }


  static ReadFilesFromFolder rff = new ReadFilesFromFolder();
  

  public static void main(String[] args) 
  {
    // TODO Auto-generated method stub
    rff.listFilesForFolder();
  }

  public  void listFilesForFolder() 
  {

    if(dirName.equals(""))
    {
      folder = new File("D:/Personal/Suravi/Java");
    }
    else
    {
      folder = new File(dirName);
    }

    if(fileMimeTyepe.equals(""))
    {
      fileMimeTyepe = "java";
    }
    
    System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
    

    for (final File fileEntry : folder.listFiles()) 
    {
      if (fileEntry.isDirectory()) 
      {
        // System.out.println("Reading files under the folder "+folder.getAbsolutePath());
        dirName = fileEntry.getAbsolutePath();
        //listFilesForFolder(fileEntry);
        listFilesForFolder();
      } 
      else 
      {
        if (fileEntry.isFile()) 
        {
          temp = fileEntry.getName();
          if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals(fileMimeTyepe))
          {
            // System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
            System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName()); 

            System.out.println("Size: "  + "  " + fileEntry.length());

            System.out.println("Mime Type: " + new MimetypesFileTypeMap().getContentType(fileEntry));

            System.out.println("Extn : " + temp.substring(temp.lastIndexOf('.') + 1, temp.length()));            

          }
        }

      }
    }
  }
}