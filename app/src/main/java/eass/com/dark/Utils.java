package eass.com.dark;

import java.io.*;

/**
 * @author Eass September<15522280@qq.com>
 * @date   201610122127
 * @description 工具类
 */

public class Utils {
    /**
     *
     * @param   userName
     * @param   password
     * @return  boolean
     */
    public static boolean saveInfos(String userName, String password){
        try {
            String  info = userName + "##" + password;
            File    file = new File("data/data/eass.com.dark/info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(info.getBytes());
            fos.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
    public String getInfo(){
        return "";
    }


}
