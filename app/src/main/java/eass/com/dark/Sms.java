package eass.com.dark;

/**
 * Created by Eass_September on 2016/10/24.
 */

public class Sms {
    private String adress;
    private String content;
    private String date;
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getAdress() {
        return adress;
    }


}
