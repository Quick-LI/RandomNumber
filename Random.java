import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Random {
   private String path;
   private Integer num;
   private String filename;
   private String filetype;
   private String pathstr;
   private boolean value;
   private ArrayList<Integer> randomNumList;

//   创建文本文档存储随机数
    public boolean createfile(){
//      文件路径
        pathstr=path+filename+filetype;
       File file = new File(pathstr);
       try {
//        判断文件是否存在，如果没有新建文件
          if (!file.exists()){
          value=file.createNewFile();}
          else {
              System.out.println("文件已创建");
          }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return value;
   }
//   通过Random函数获取随机数并存入数组当中
   public ArrayList Randomnum (int interval,int randomNumber){
       java.util.Random random = new java.util.Random();
       num=random.nextInt(interval);
       System.out.println("随机数范围："+interval);
       System.out.println("选取随机数数量："+randomNumber);
       randomNumList =new ArrayList<Integer>();
       for(int i=0;i<randomNumber;i++){
           num=random.nextInt(interval);
           randomNumList.add(num);
       }
       return randomNumList;
   }
//   读取随机数数组数据整理成段落，写入文本文档中
   public boolean fileInputRandom(ArrayList randomNumList){
       pathstr=path+filename+filetype;
       try {
           FileWriter fileWriter =new FileWriter(pathstr,true);
           for(int i=0;i<randomNumList.size();i++){
//             整理随机数
               String randomstr="随机数"+(i+1)+"："+randomNumList.get(i);
//             写入到文本文档中
               fileWriter.write(randomstr+"\r\n");
           }
           fileWriter.close();
           System.out.println("随机数以写入");
       } catch (IOException e) {
           e.printStackTrace();
       }
       return true;
   }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
}
