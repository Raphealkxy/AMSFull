package com.timmy.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetCutFile {

	public void CutPictures(String outPath, String filename) {
		System.out.println("cutting start ....");
		try {

			Process pr = Runtime.getRuntime().exec(
					"d:\\python27\\python.exe E:\\python_workspace\\detectAndsave.py " + filename + " " + outPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 程序暂停一段时间等待文件写入
		 */

		Thread thread = Thread.currentThread();
		try {
			thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 暂停1.5秒后程序继续执行
		System.out.println("end");

	}

	public void printPath(List<String> list) {
		if (list == null) {
			System.out.println("�ļ�����û���ļ�");
		} else {
			for (String filepath : list) {
				System.out.println(filepath);
			}
		}
	}

	/**
	 * 提供路径，提供图片，实现自动化。
	 * 
	 * @param args
	 */

	public void getCutFilesPath(String outPath, String filename) {
		List<String> filelist = null;

		CutPictures(outPath, filename);

		filelist = traverseFolder2(outPath);
		printPath(filelist);
	}

	/**
	 * 
	 * @param path
	 */
	public List<String> traverseFolder2(String path) {

		List<String> filelist = new ArrayList<String>();
		List<String> filelist2 = new ArrayList<String>();

		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return null;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						// System.out.println("�ļ���:" + file2.getAbsolutePath());
						filelist2 = traverseFolder2(file2.getAbsolutePath());
						for (String filepath : filelist2)
							filelist.add(filepath);
					} else {
						// System.out.println(" ----" +
						// file2.getAbsolutePath());
						filelist.add(file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
		return filelist;
	}

}
