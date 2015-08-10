package com.hand.Exam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Exam1 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is,200);
			
			FileOutputStream fos = new FileOutputStream(new File("SampleChapter.pdf"));
			BufferedOutputStream bos = new BufferedOutputStream(fos,200);
			System.out.println("正在下载……");
			String line;
			byte[] input = new byte[200];
			int l;
			while ((l = bis.read(input)) != -1) {
				bos.write(input, 0, l);
			}
			System.out.println("下载完成。");
			bos.close();
			fos.close();
			bis.close();
			is.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
