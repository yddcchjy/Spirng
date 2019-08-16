package com.yddcc.beans;

import java.util.List;

public class ClassRoom {
		private  String classRoomName;
	    private  String stuArray[];
	    private  List<String>   school;
		public String getClassRoomName() {
			return classRoomName;
		}
		public void setClassRoomName(String classRoomName) {
			this.classRoomName = classRoomName;
		}
		public String[] getStuArray() {
			return stuArray;
		}
		public void setStuArray(String[] stuArray) {
			this.stuArray = stuArray;
		}
		public List<String> getSchool() {
			return school;
		}
		public void setSchool(List<String> school) {
			this.school = school;
		}
	    
}
