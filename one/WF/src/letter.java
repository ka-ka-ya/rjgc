import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class letter {
	
	 private static String formattedDecimalToPercentage(double decimal)
	    {
	    	//获取格式化对象
	    	NumberFormat nt = NumberFormat.getPercentInstance();
	    	//设置百分数精确度2即保留两位小数
	    	nt.setMinimumFractionDigits(2);
	    	return nt.format(decimal);
	    }
public static void main(String []args) {
	String a1;
	char a='A';
	int a2[]=new int[27];
	char b1[]=new char[26];
	char b2[]=new char[26];
	double c1[]=new double[26];
	for(int i=0;i<26;i++)
	{
	b1[i]=a;
	b2[i]=(char)(a+32);
	a++;
	}
	try {
        BufferedReader in = new BufferedReader(new FileReader("D:\\piao.txt"));
        String str;
        while ((str = in.readLine()) != null) {
            char[] d=str.toCharArray();
            for(int i=0;i<d.length-1;i++) {
            	for(int j=0;j<26;j++) {
            		if(b1[j]==d[i]||b2[j]==d[i]) {
            			a2[j]++;
            		}
            	}
            }
        }
        
        a2[26]=0;
        for(int i=0;i<26;i++) {
        	a2[26]=a2[i]+a2[26];
        }
 
        for(int i=0;i<26;i++) {
        	 c1[i]=(double)((double)a2[i]/(double)a2[26]);
        }
        
        
       for(int i=0;i<26;i++) {
        	System.out.print(b1[i]);
        	System.out.print("和");
        	System.out.print(b2[i]);
        	System.out.print("出现的次数为：");
        	System.out.print(a2[i]);
        	double d=(double)((double)a2[i]/(double)a2[26]);
        	String result2=formattedDecimalToPercentage(d);
    	    System.out.println("   百分比为："+result2);
 
        }
       System.out.println("       ");
        System.out.println("出现单词次数较多的前十个为：");
        BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\\\piao.txt"));
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        Pattern expression = Pattern.compile("[a-zA-Z]+");
        String string = buffer.toString();
        Matcher matcher = expression.matcher(string);//
        Map<String, Integer> map = new TreeMap<String, Integer>();
        String word = "";
        int times = 0;
        while (matcher.find()) {
            word = matcher.group();
            if (map.containsKey(word)) {
                times = map.get(word);
                map.put(word, times + 1);
            } else {
                map.put(word, 1);
            }
        }
 
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
                map.entrySet());
 
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> left,
                    Map.Entry<String, Integer> right) {
                return (left.getValue()).compareTo(right.getValue());
            }
        };
        Collections.sort(list, comparator);// 排序
        int last = list.size() - 1;
        int asdad=0;
        for(int i=last;i>0;i--) {
        	String key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
        	asdad=asdad+value;
        	
        }
        
        for (int i = last; i > last - 10; i--) {
            String key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            System.out.print(key + " :" + value);
           double d=(double)((double)value/(double)asdad);
           String result2=formattedDecimalToPercentage(d);
   	    System.out.println("   百分比为："+result2);
        }
        
    } catch (IOException e) {
    }
}
}