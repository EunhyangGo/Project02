package com.biz.name.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.name.contact.NameContact;
import com.biz.name.vo.NameVO;

public class NameService {
	List<NameVO> nameList;
	List<NameVO> surnameList;
	
	String strName;
	String strSurName;
	String strFullName;

	public NameService(String[] names) {
		nameList = new ArrayList();
		surnameList = new ArrayList();
		
		strName = names[NameContact.FILES_NAME];
		strSurName = names[NameContact.FILES_SURNAME];
		strFullName = names[NameContact.FILES_FULLNAME];
	}
	public void stdFileRead1() {
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(strSurName);
			buffer = new BufferedReader(fr);
			
			while(true){
				String reader = buffer.readLine();
				if(reader == null) break;
				
				String[] stds = reader.split(":");
				
				NameVO vo = new NameVO();
				
				vo.setStrSurName(stds[1]);
				surnameList.add(vo);
				
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stdFileRead2() {
			FileReader fr;
			BufferedReader buffer;
			
			try {
				fr = new FileReader(strName);
				buffer = new BufferedReader(fr);
				
				while(true){
					String reader = buffer.readLine();
					if(reader == null) break;
					
					
					NameVO vo = new NameVO();
					
					vo.setStrName(reader);
					nameList.add(vo);
					
				}
				buffer.close();
				fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}
    	
	public void writeName() {
    	PrintWriter pw;
    	
    	try {
			pw = new PrintWriter(strFullName);
			
			for(int i = 0 ; i < 100 ; i ++) {
	    		int j = (int)(Math.random()*(surnameList.size()-1));
	        	int k = (int)(Math.random()*(nameList.size()-1));
	        	
	    		pw.println(surnameList.get(j).getStrSurName()+nameList.get(k).getStrName());
	    	}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void viewName() {
    	System.out.println("========");
    	System.out.println("이름들");
    	System.out.println("========");
    	
    	
    	
    	for(int i = 0 ; i < 100 ; i ++) {
    		int j = (int)(Math.random()*(surnameList.size()-1));
        	int k = (int)(Math.random()*(nameList.size()-1));
        	
    		System.out.println(surnameList.get(j).getStrSurName()+nameList.get(k).getStrName());
    	
    	}
    	
    }
}
