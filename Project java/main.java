import java.util.*;
import java.io.*;
import javax.swing.*;
public class main{
	public static void main (String[] args) {
		
		
		Scanner in=new Scanner(System.in);
	ListIterator li1 = null;
	ListIterator li = null;
String subjName;
String subjCode;
int startHours;
 int startMinutes;
 int endHours;
 int endMinutes;
 String room;
 String nameDay="";
int noDay;


		Scanner in1=new Scanner(System.in);
		
		File f=new File(("roomscheduler11.txt"));
				File f1=new File(("comparator3.txt"));
		ArrayList<Person> mylist=new ArrayList<>();
				ArrayList<Person> compare = new ArrayList<>();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
			FileOutputStream fos=null;
				FileInputStream fis=null;
				
		
		try{
				if(f.isFile()){
			ois = new ObjectInputStream(new FileInputStream(f));
			
			mylist = (ArrayList<Person>)ois.readObject();
	
		
			ois.close();
		}
		}
		catch(IOException e){
			System.out.println(e);
			
		}
		catch(ClassNotFoundException ex){
			System.out.println(ex);
			
		}
		String choice;
		
		do{
		{ try{
		fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
		for(Person person:mylist){
			
			startHours=person.getStartHours();
			startMinutes= person.getStartHours();
			nameDay= person.getNameDay();
			noDay= person.getNoDay();
			endHours= person.getEndHours();
			endMinutes= person.getEndMinutes();
			room=person.getRoom();
			compare.add(new Person(startHours,startMinutes,nameDay,noDay,endHours,endMinutes,room));
		}	
			 fos= new FileOutputStream(f1);
	 oos=new ObjectOutputStream(fos);
		oos.writeObject(compare);

		oos.close();
		fos.close();
		}catch(IOException e){
		JOptionPane.showMessageDialog(null,e);
	}catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null,ex);
	}
			}
		choice=JOptionPane.showInputDialog(null,"1. Create/Add Room Schedule. \n"+
												"2. SORTED DISPLAY.\n"+
												"3. SEARCH. \n" +
												"4. UPDATE SUBJECT.\n"+
												"5. DELETE.\n"+
												"0. Exit Program.");
		
		
		switch (choice){
	
	case "1":
		try{
		
		if(!f.exists()){
			f.createNewFile();
		
		}
		if(!f1.exists()){
			f1.createNewFile();
		
		}
		
		else{ 
			
			boolean found=false;
			boolean theSame=false;
		do{do{
		
		
			
		noDay=Integer.parseInt(JOptionPane.showInputDialog(null,"day "));
			switch(noDay){
					case 1:
					nameDay="Sunday";
					found=true;
					break;
				case 2:
					nameDay="Monday";
						found=true;
					break;
				
							case 3:
					nameDay="Tuesday";
						found=true;
					break;
							case 4:
					nameDay="Wednesday";
						found=true;
					break;
							case 5:
					nameDay="Thursday";
						found=true;
					break;
						case 6:
					nameDay="Friday";
						found=true;
					break;
							case 7:
					nameDay="Saturday";
						found=true;
					break;
					default: JOptionPane.showMessageDialog(null,"Invalid input");
					
			}} while(!found);
		
			subjName=	JOptionPane.showInputDialog(null,"Enter Subject Name");
			subjCode=	JOptionPane.showInputDialog(null,"Enter Subject Code");	
			room=JOptionPane.showInputDialog(null,"Assign room");
			startHours=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Start Time Hour(24 Hours format) "));
			startMinutes=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Start Time Minutes(24 Hours format) "));
			endHours=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter End Time Hour(24 Hours format) "));
			endMinutes=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter End Time Minutes(24 Hours format) "));
			
			String toLower=	room.toUpperCase();
			
			try{
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
			ois.close();
			
					 li=p.listIterator();
			while(li.hasNext()){
				Person person=(Person)li.next();
			if(  person.getRoom().equals(toLower) && person.getNameDay().equals(nameDay) && person.getStartHours() == startHours && person.getEndHours() == endHours && person.getStartMinutes() == startMinutes && person.getEndMinutes() == endMinutes)
			{
				JOptionPane.showMessageDialog(null,"Conflict");
				theSame= true;
				break;
			}
			else {
					
					theSame=false;
					
			}
		} }catch(IOException e){
			System.out.println(e);
			
		}
		catch(ClassNotFoundException ex){
			System.out.println(ex);
			
		}
		}while(theSame);
			
					mylist.add(new Person(startHours,startMinutes,nameDay,noDay,endHours,endMinutes,room,subjName,subjCode));
				
	 fos= new FileOutputStream(f);
	 oos=new ObjectOutputStream(fos);
		oos.writeObject(mylist);

		oos.close();
		fos.close();
		JOptionPane.showMessageDialog(null,"Done");
		
	}} catch(IOException e){
		JOptionPane.showMessageDialog(null,e);
	}
	

	break;
	
		/*case "2":
		try{
	
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
	
		
			for (Person person:p){
			
			JOptionPane.showMessageDialog(null, "Room: " + person.getRoom() + "\n" +
												"Time Sched: " + person.getStartHours() + ":" + person.getStartMinutes() + " - " + person.getEndHours() + ":" + person.getEndMinutes() +"\n" +
												"Subject Name: " + person.getSubjName()+ "\n"+
												"Subject Code: " + person.getSubjCode()+"\n" +
												"Day: " + person.getNameDay());}break;
			
			
			
			
			
		}catch(IOException e){
		JOptionPane.showMessageDialog(null,e);
	}catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null,ex);
	}
	
	break;*/
		
	
	case "3":

		try{
			if(f.isFile()){
			
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
			
			ois.close();
					boolean found = false;
			String	searchName=JOptionPane.showInputDialog(null,"Enter Name to Search");
			
			String searchNameLower=searchName.toLowerCase();
	
			
			for(Person person:p){
			String toLower=	person.getRoom().toLowerCase();
			String toLower1=person.getSubjName().toLowerCase();
		
				if(searchNameLower.equals(toLower)||searchNameLower.equals(toLower1)||searchName.equals(person.getSubjCode())){
					JOptionPane.showMessageDialog(null, "Room: " + person.getRoom() + "\n" +
												"Time Sched: " + person.getStartHours() + ":" + person.getStartMinutes() + " - " + person.getEndHours() + ":" + person.getEndMinutes() +"\n" +
												"Subject Name: " + person.getSubjName()+ "\n"+
												"Subject Code: " + person.getSubjCode()+"\n" +
												"Day: " + person.getNameDay());
												found=true;
				}
				
				
				
				
				
			}if(!found){
				
						JOptionPane.showMessageDialog(null,"Record not found");
					}
			}else{
					JOptionPane.showMessageDialog(null,"File Not Exist");
			}
			}	catch(IOException e){
		JOptionPane.showMessageDialog(null,e);
	}catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null,ex);
	}
	break;
	
		case "4":
					
		try{
			if(f.isFile()){
			
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
				 
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
			
					
			ois.close();
					boolean found = false;
			String updateCode=JOptionPane.showInputDialog(null,"Enter Subject Code to Update");
			li=p.listIterator();
		
			
			while(li.hasNext()){
				Person person=(Person)li.next();
		
		
		if(updateCode.equals(person.getSubjCode())){
					boolean fa= false;
					boolean theSame=false;
					do{ do{
		
		
			
		noDay=Integer.parseInt(JOptionPane.showInputDialog(null,"day "));
			switch(noDay){
					case 1:
					nameDay="Sunday";
					fa=true;
					break;
				case 2:
					nameDay="Monday";
						fa=true;
					break;
				
							case 3:
					nameDay="Tuesday";
						fa=true;
					break;
							case 4:
					nameDay="Wednesday";
						fa=true;
					break;
							case 5:
					nameDay="Thursday";
						fa=true;
					break;
						case 6:
					nameDay="Friday";
						fa=true;
					break;
							case 7:
					nameDay="Saturday";
						fa=true;
					break;
					default: JOptionPane.showMessageDialog(null,"Invalid input");
					
			}} while(!fa);
					
			subjName=	JOptionPane.showInputDialog(null,"Enter Subject Name");
				subjCode=	JOptionPane.showInputDialog(null,"Enter Subject Code");	
					room=JOptionPane.showInputDialog(null,"Assign room");
			startHours=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Start Time Hour(24 Hours format) "));
			startMinutes=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Start Time Minutes(24 Hours format) "));
					endHours=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter End Time Hour(24 Hours format) "));
				endMinutes=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter End Time Minutes(24 Hours format) "));
		
				found=true;
			
			
				try{//The start of the code that will catch the conflict schedules
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ois.close();
			
					 li=p.listIterator();
			while(li.hasNext()){
			person=(Person)li.next();
			if(  person.getRoom().equals(room) && person.getNameDay().equals(nameDay) && person.getStartHours() == startHours && person.getEndHours() == endHours && person.getStartMinutes() == startMinutes && person.getEndMinutes() == endMinutes)
			{
				JOptionPane.showMessageDialog(null,"Conflict");
				theSame= true;
				break;
			}
			else {
					
					theSame=false;
					continue;
			}
		} }catch(IOException e){
			System.out.println(e);
			
		}
		
		}while(theSame);//end of the code.
				li.set(new Person(startHours,startMinutes,nameDay,noDay,endHours,endMinutes,room,subjName,subjCode));
				}
			
			
				
			}if(!found){
					JOptionPane.showMessageDialog(null,"Record not found");
						
					}else{
							oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(p);
			
				oos.close();
				JOptionPane.showMessageDialog(null,"Record Updated Succesfully ");
					
					}
			}else{
					JOptionPane.showMessageDialog(null,"File Not Exist");
			}
			}	catch(IOException e){
		JOptionPane.showMessageDialog(null,e);
	}catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null,ex);
	}
	break;
			
			
		case "5":
					try{
			if(f.isFile()){
			
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
			ois.close();
					boolean found = false;
					
				String studID=	JOptionPane.showInputDialog(null,"Enter Subject Code to Delete ");
					 li=p.listIterator();
			while(li.hasNext()){
				Person person=(Person)li.next();
				if(person.getSubjCode().equals(studID)){
					
				li.remove();
					
						
					found=true;
		}
		
			}	if(!found){
				
					JOptionPane.showMessageDialog(null,"Record Not Found.");
						
			}
				else{
						oos = new ObjectOutputStream(new FileOutputStream(f));
							oos.writeObject(p);
							oos.close();
							JOptionPane.showMessageDialog(null,"Record Deleted Successfully.!");
			}
		}else{
					System.out.println("File not Exists....!");
			}
		}catch(IOException e){
		System.out.println(e);
	}catch(ClassNotFoundException ex){
	System.out.println(ex);
	}
	break;
	
case "2":
	try{
			if(f.isFile()){
			
				 fis=new FileInputStream(f);
				 ois=new ObjectInputStream(fis);
			ArrayList<Person> p =(ArrayList<Person>)ois.readObject();
		
			ois.close();
			
				
				
						Collections.sort(p, new Comparator<Person>(){
							public int compare(Person p1, Person p2){
								return p1.getRoom().compareTo(p2.getRoom());
							}
							
						});
					
							for(Person person:p ){
		
			
			JOptionPane.showMessageDialog(null, "Room: " + person.getRoom() + "\n" +
												"Time Sched: " + person.getStartHours() + ":" + person.getStartMinutes() + " - " + person.getEndHours() + ":" + person.getEndMinutes() +"\n" +
												"Subject Name: " + person.getSubjName()+ "\n"+
												"Subject Code: " + person.getSubjCode()+"\n" +
												"Day: " + person.getNameDay());}continue;
			
			
			}}
			catch(IOException e){
		JOptionPane.showMessageDialog(null,e);
	}catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null,ex);
	}
		break;
	
		
}
}while(!choice.equals("0"));}
}