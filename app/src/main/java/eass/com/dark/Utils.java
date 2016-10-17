package eass.com.dark;

import android.content.Context;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eass September<15522280@qq.com>
 * @date   201610122127
 * @description 工具类
 */

public class Utils {
    /**
     * @param   context
     * @param   userName
     * @param   password
     * @return  boolean
     * @description 保存信息到文件
     *
     */
    public static boolean saveInfos(Context context, String userName, String password){
        try {
            String path = context.getFilesDir().getPath();
            String  info = userName + "##" + password;
            File    file = new File(path, "info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(info.getBytes());
            fos.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    /**
     *
     * @param  context
     * @return Map
     * @description 读取信息文件
     */
    public static Map<String, String> getInfo(Context context) {
        try {
            String path = context.getFilesDir().getPath();
            File file  = new File(path, "info.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String content = br.readLine();
            String[] contentArr = content.split("##");
            Map<String, String> map = new HashMap<String, String>();
            for (int i=0; i<contentArr.length;i++){
                map.put("val"+i, contentArr[i]);
            }

            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
