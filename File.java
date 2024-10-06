
import java.io.*;


public class filedemo1 {
    public static void main(String[] args) {
        class FileNotFoundException extends Exception {
            public FileNotFoundException(String message) {
                super(message);
            }
        }
        class EmptyFileException extends FileNotFoundException {
            public EmptyFileException(String message) {
                super(message);
            }
        }
        class Error {
            public static void ReadFile()throws FileNotFoundException {
                File file = new File("/Users/duqiu/Desktop/java/javapro/src/test/resources/data.txt");
                if (!file.exists()) {
                    throw new FileNotFoundException("File Not Found");
                }

            }
            public static void ReadFile2()throws EmptyFileException {
                File file = new File("/Users/duqiu/Desktop/java/javapro/src/test/resources/data.txt");
                if(file.length() ==0) {
                    throw new EmptyFileException("File is Empty");
                }
            }

        }
        BufferedReader br = null;
        int average = 0;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
            Error.ReadFile();
            Error.ReadFile2();
            String line;
            while((line = br.readLine())!=null) {
                String[] str = line.split("\\s+");
                int sum = 0;
                for(String s : str) {
                    sum += Integer.parseInt(s);
                }
                average += sum/str.length;
            }
            System.out.println("平均值为：" +average);
        }catch(FileNotFoundException s){
            System.out.println("未找到文件");

        } catch(NumberFormatException | java.io.FileNotFoundException s) {
            System.out.println("包含无法被解析为整数的内容");
        }catch(IOException e) {
            System.out.println("文件为空");

        }finally {
         if(br!=null) {
             try {
                 br.close();
             } catch (IOException e) {
                 System.out.println("关闭异常");
             }
         }

        }
System.out.println("程序结束");


    }
}

