package webadv.s99201105.p02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) throws IOException {
    	BufferedWriter fw = new BufferedWriter(new FileWriter("account.txt")); //向密码文件中写入需要存储的账号和sha-256保护的密码
    	fw.write("17205118");
    	fw.newLine();
    	fw.write(DigestUtils.sha256Hex("123456"));
    	fw.close();
    	Scanner input = new Scanner(System.in);
    	System.out.println("输入账号：");
    	String account = input.next();
    	System.out.println("输入密码：");
    	String password = input.next();
    	BufferedReader fr = new BufferedReader(new FileReader("account.txt")); //读取密码文件中的数据与用户输入的进行比对
		String account2 = fr.readLine();
        String password2 = fr.readLine();
        fr.close();
        
        if(account.equals(account2)&&DigestUtils.sha256Hex(password).equals(password2)) {
        	System.out.println("登录成功！");
        }else {
        	System.out.println("账号或者密码错误！");
        }

    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

