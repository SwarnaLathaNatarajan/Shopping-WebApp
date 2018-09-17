package Bean;
import java.util.*;
public class Menu{
	public String[] name=new String[100];
	public String[] descp=new String[100];
	public String[] img=new String[100];
	public int[] rs=new int[100];
	public int no;
	public void set(String[] n,String[] d,String[] i,int[] r,int num){
		name=Arrays.copyOf(n,n.length);
		descp=Arrays.copyOf(d,d.length);
		img=Arrays.copyOf(i,i.length);
		rs=Arrays.copyOf(r,r.length);
		no=num;
	}
	public String[] getn(){
		return name;
	}
	public String[] getd(){
		return descp;
	}
	public String[] geti(){
		return img;
	}
	public int[] getr(){
		return rs;
	}
	public int getnum()
	{
		return no;
	}
}