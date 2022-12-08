import java.util.*;
import java.io.*;
import javax.swing.*;
public class Person implements Serializable{


private String subjName;
private String subjCode;
private int startHours;
private int startMinutes;
private int endHours;
private int endMinutes;
private String room;
private String nameDay;
private int noDay;


public Person(int startHours, int startMinutes, String nameDay, int noDay, int endHours, int endMinutes,String room){
	this.startHours=startHours;
	this.startMinutes=startMinutes;
	this.room=room;
	this.endHours=endHours;
	this.endMinutes=endMinutes;
	this.nameDay=nameDay;
	this.noDay=noDay;
}
public Person(int startHours, int startMinutes, String nameDay, int noDay, int endHours, int endMinutes,String room, String subjName, String subjCode){
	this.startHours=startHours;
	this.startMinutes=startMinutes;
	this.room=room;
	this.endHours=endHours;
	this.endMinutes=endMinutes;
	this.nameDay=nameDay;
	this.noDay=noDay;
	this.subjName=subjName;
this.subjCode=subjCode;
}
public String getSubjName(){
	return subjName;
}

public String getSubjCode(){
	return subjCode;
}
public String getRoom(){
	return room;
}
public int getStartHours(){
	return startHours;
}
public int getStartMinutes(){
	return startMinutes;
}
public String getNameDay(){
	return nameDay;
}
public int getNoDay(){
	return noDay;
}

public int getEndHours(){
	return endHours;
}

public int getEndMinutes(){
	return endMinutes;
}



} 
