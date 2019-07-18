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
				
				//print the header
				for(String s : header)
					System.out.print(s+"   ");
			}
			
			if(dataStart)
				mapList.add(map);
			
			map = null;
			count = 0;
			
			System.out.println();
		}
		
		mapList.remove(0);
		//displayListMap(mapList);
		
		
		System.out.println("Enter the invoice num : ");
		String num = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Enter the parameter data you want : ");
		String param = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println(getData(mapList, param, num));
		
		
		}catch(IOException e) {
			e.printStackTrace();
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
