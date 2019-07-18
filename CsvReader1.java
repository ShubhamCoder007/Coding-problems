package com.highradius.file.excel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSV_1 {

	static String path = "C:\\Users\\nEW u\\Desktop\\HighRadius\\SampleForPractice.csv" ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String line = "";
		
		List<String> header = new ArrayList<String>();
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		
		boolean headerFlag = false;
		boolean dataStart = false;
		int count = 0;
		
		while((line = br.readLine()) != null) {
			
			Map<String, String> map = new LinkedHashMap<String, String>();
			
			String[] val = line.split(",");
			
			for(String s : val) {
				
				if(s.equals("Status")||s.equals("Invoice #")||s.equals("Supplier #")||s.equals("Supplier")||s.equals("Company")||s.equals("Invoice Date")||s.equals("Invoice Amount") && !headerFlag) {
					headerFlag = true;
					
					break;
				}
				
				if(dataStart) {
					
					map.put(header.get(count++), s);
					
				}
				
			}
			
			//set header
			if(headerFlag) {
				for(String s : val) {
					header.add(s);
				}
				headerFlag = false;
				dataStart = true;
				
			}
			
			if(dataStart)
				mapList.add(map);
			
			map = null;
			count = 0;
			
			//System.out.println();
		}
		
		mapList.remove(0);
		//displayListMap(mapList);
		
		
		//print the header
		for(String s : header)
			System.out.println(s+" --> "+header.indexOf(s));
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the indexes to display: ");
		int ch = 1;
		String params = "";
		while(true) {
			params += header.get(Integer.parseInt(b.readLine())) +",";
			System.out.println("Want to add another? 0 to exit");
			ch = Integer.parseInt(b.readLine());
			if(ch == 0) {
				params = params.substring(0, params.length() - 1);
				break;
			}
			
			System.out.println("your included parameter: "+params);
		}
		
		String[] p = params.split(",");
		
		getAllDatas(mapList, p);
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void getAllDatas(List<Map<String, String>> mapList, String...cols) {
		int row = 0;
		
		for(String name:cols)
			System.out.print(name+"  ");
		System.out.println();
		
		while(mapList.size() > row) {
		for(int i = 0; i < cols.length; i++) {
			System.out.print(mapList.get(row).get(cols[i])+"  ");
		}
		row++;
		System.out.println();
		}
	}
	
	
	public static String getData(List<Map<String, String>> mapList, String query, String invoice) {
		String res = null;
		for(Map<String, String> m : mapList) {
			if(m.get("Invoice #").equals(invoice)) {
				res = m.get(query);
			}
		}
		return res;
	}
	
	
	public static void displayListMap(List<Map<String, String>> mapList) {
		for(Map<String, String> m : mapList) {
			System.out.println(m);
		}
	}

}
