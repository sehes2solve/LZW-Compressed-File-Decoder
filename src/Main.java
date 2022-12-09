import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static String LZW_decomp(String tags)
    {
        ArrayList<String> dic = new ArrayList<>();
        for(int i = 0;i < 128;i++)
            dic.add((char)i + "");
        int dic_idx,prevD_idx = -1;
        String tag = "",msg = "";
        for(int i = 0;i < tags.length(); i++,tag = "")
        {
            while(tags.charAt(i) != ',')
            {
                tag += tags.charAt(i);
                if(i == tags.length() - 1)
                    break;
                i++;
            }
            dic_idx = Integer.parseInt(tag);
            if(dic_idx < dic.size())
            {
                msg += dic.get(dic_idx);
                if(prevD_idx != -1)
                    dic.add(dic.get(prevD_idx) + dic.get(dic_idx).charAt(0));
                prevD_idx = dic_idx;
            }
            else
                msg += dic.get(prevD_idx) + dic.get(prevD_idx).charAt(0);
        }
        return  msg;
    }
    public static void main(String[] args)
    {
        System.out.println(LZW_decomp("65,66,65,128,128,129,131,134,130,129,66,138,139,138"));
    }
}
