package com.amazon.testing;

import java.util.Map;

public class ExcelDemo {
 public static void main(String[] args) {
	 ExcelRead excel = new ExcelRead();
	 excel.prepareData();
	 Map data = excel.getData() ;
	 
	 for(Object key : data.keySet()) {
		 System.out.println(key + " : " + data.get(key));
	 }
	 
 }
}
