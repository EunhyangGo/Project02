package com.biz.name.exec;

import com.biz.name.service.NameService;

public class NameExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strSurName = "src/com/biz/name/한국인성씨.txt";
		String strName = "src/com/biz/name/이름리스트.txt";
		String strFullName ="src/com/biz/name/한국인이름리스트.txt";
		
		String[] names = {strName, strSurName, strFullName};
		
		NameService ns = new NameService(names);
		
		ns.stdFileRead1();
		ns.stdFileRead2();
		
		ns.viewName();
		ns.writeName();

	}

}
