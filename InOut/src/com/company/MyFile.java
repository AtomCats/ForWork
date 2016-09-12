package com.company;

/**
 * Created by Admin on 09.09.2016.
 */
import java.io.*;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyFile {
    public String temp;
    public void writeToFile(File file,Collection<DepartmentRoom> coll){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            if (!file.exists()){
                file.createNewFile();
            }
            for(DepartmentRoom a:coll){
                if(a.getClass().isAssignableFrom(DecansOffice.class)){
                    bw.write("Деканат ");
                }
                else if(a.getClass().isAssignableFrom(EducationalRoom.class)){
                    bw.write("Учебный_класс ");
                }
                else if(a.getClass().isAssignableFrom(LectureRoom.class)){
                    bw.write("Лекционный_класс ");
                }
                bw.write(((EducationalRoom)a).get_roomNumber()+"\n");

            }
        }
        catch (IOException e){

        }
    }

        public void ReadFile(File file, Collection coll){
            char c;
            int val;
            String temp="";
            try(BufferedReader br = new BufferedReader (new FileReader(file)))
            {
                while((val=br.read())!=-1){

                    if ((char)val==' ' || (char)val=='\n'){
                        coll.add(temp);
                        temp="";
                        continue;
                    }
                    temp+=(char)val;

                }
            }
            catch(IOException ex){
            }
            //return coll;
        }

    public void ReadFromZip(String pathToZip,String fileName,Collection coll){
        try{
            int val;
            String temp="";

            String FileName = "out.txt";
            ZipFile zipFile = new ZipFile("C:\\Users\\Admin\\IdeaProjects\\InOut\\out.zip");
            InputStream stream=null;
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            ZipEntry entry=null;
            try {
                if((entry=zipFile.getEntry(fileName))!=null){
                    stream = zipFile.getInputStream(entry);

                 }
                }
            catch (Exception e){

            }
/*            URL zipUrl = new URL("jar: C://Users//Admin//IdeaProjects//InOut//out.zip");
            URL entryUrl = new URL("jar:" + zipUrl + "!/out.txt");
            InputStream is = entryUrl.openStream();*/
           // URL entryUrl = new URL("jar:" + pathToZip + "!/"+fileName);
            //URL entryUrl = Main.class.getResource("\\out.zip");
           // File zipFile = new File(entryUrl.toURI());
           // ZipFile zip = new ZipFile(zipFile);
            //InputStream is = zip.getInputStream(zip.getEntry("out.txt"));

            try (BufferedReader br = new BufferedReader (new InputStreamReader(stream))){
                while ((val=br.read())!=-1){
                    if ((char)val==' ' || (char)val=='\n'){
                        coll.add(temp);
                        temp="";
                        continue;
                    }
                    temp+=(char)val;
                }
            }
            catch (Exception ex){

            }

        }
        catch (Exception e){

        }

    }
    }

