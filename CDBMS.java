import java.lang.*;
import java.util.*;

// Database table / Schema
class Student
{
    public int RID;
    public String Name;
    public int Salary;
	public String Address;

    private static int Generator = 0;

    /*static 
        {
            Generaotr = 0
        }
     */

    public Student(String str,int value,String Add)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
		this.Address = Add;
    }

    public void DisplayData()
    {
        System.out.println("|" + this.RID + "|" + this.Name + "|" + this.Salary + "|" + this.Address + "|");
		System.out.println("-------------------------------------------------------------------------------");
	}
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    //Inser into student piyush 1000;
    //select * from student;
    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Marvellous Custamise DBMS Started succesfully.....");
        String QueryX = "";

        while(true)
        {
            System.out.print("Marvellous DBMS Console --> ");
            QueryX = scanobj.nextLine();

            String Query = QueryX.toLowerCase();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("help".equals(tokens[0]))
                {
					System.out.println("This application is used to Demonstrates the costamise DBMS ");
					
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Insert New Record");
					System.out.println("-------------------------------------------------------------");
					System.out.println("Query             	       :    insert into student name salary City");
                    System.out.println("-------------------------------------------------------------");


					System.out.println("Discreption  		   :	Terminate the DBMS");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Terminate DBMS");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display the All Data From Table");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    select * from student");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Delete data from RID");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    delete from student RID");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Delete data from Name");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    delete from student Name");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display data from RID");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    select * from student RID");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Specific data from table");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    select * from student where Name = Name");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Conditional data from table");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    select * from student where Salary > Amount");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Conditional data from table");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    select * from student where Salary < Amount");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Maximum Salary");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Display Max Salary from student");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Minimum Salary");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Display Min Salary from student");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Sumation of Salary");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Display Sum Salary from student");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display Sumation of Salary");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Display Average Salary from student");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Counting the size of linkedlist");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Count student");
                    System.out.println("-------------------------------------------------------------");
					
					System.out.println("Discreption  		   :	Display data from Name");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Query                      :    Display * from student NAME");
					
                    System.out.println("-------------------------------------------------------------");
                }
                else if("exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using marvellous DBMS");
                    break;
                }
            }
            else if(QuerySize == 2)
            {
				if("Count".equals(tokens[0]))
				{
					AggregateCount();
				}
            }
				else if(QuerySize == 4)
				{
					if("select".equals(tokens[0]))
					{
						if("*".equals(tokens[1]))
						{
							DisplayAll();
						}
					}
					else if("delete".equals(tokens[0]))
					{
						if("rid".equals(tokens[3]))
						{
							DeleteSpecificR(Integer.parseInt(tokens[3]));    
						}
							else if("Name".equals(tokens[3]))
							{
									DeleteSpecificN(tokens[3]);
							}
					}
				}
				else if(QuerySize == 5)
				{
					if("select".equals(tokens[0]))
					{
						if("RID".equals(tokens[4]))
						{
							DisplaySpecificR(Integer.parseInt(tokens[4])); 
						}						
					}
					else if("display".equals(tokens[0]))
					{
						if("Name".equals(tokens[4]))
						{
							DisplaySpecificN(tokens[4]);
						}
							if("Sum".equals(tokens[1]))
							{
								AggregateSum();
							}
								if("Max".equals(tokens[1]))
								{
									AggregateMax();
								}
									if("Min".equals(tokens[1]))
									{
										AggregateMin();
									}
										if("Average".equals(tokens[1]))
										{
											AggregateAvg();
										}
					}
			}
            else if(QuerySize == 6)
            {
                if("insert".equals(tokens[0]))
                {
                        InsertData(tokens[3],Integer.parseInt(tokens[4]),tokens[5]);
                }
            }
				else if(QuerySize == 8)
				{
					if("Select".equals(tokens[0]))
					{
						 if("*".equals(tokens[1]))
						{
							 if("from".equals(tokens[2]))
							{
								 if("Student".equals(tokens[3]))
								{
									 if("Where".equals(tokens[4]))
									{
										 if("Name".equals(tokens[5]))
										{
											 if("=".equals(tokens[6]))
											{
												DisplaySpecificN(tokens[7]);
											}
											else
											{
												System.out.println("Query is Wrong");
											}
										}
									}
								}
							}
						}
					}
					else if("Select".equals(tokens[0]))
					{
						if("*".equals(tokens[1]))
						{
							 if("from".equals(tokens[2]))
							{
								 if("Student".equals(tokens[3]))
								{
									 if("Where".equals(tokens[4]))
									{
										 if("Salary".equals(tokens[5]))
										{
											 if(">".equals(tokens[6]))
											{
												Greater(Integer.parseInt(tokens[7]));
											}
												if("<".equals(tokens[6]))
												{
													Smaller(Integer.parseInt(tokens[7]));
												}
												else 
												{
													System.out.println("Query Wrong Check the Query");
												}
										}
									}
								}
							}
						}
					}
				}
        }
    }

    //Insert Data
    public void InsertData(String str,int value,String Address)
    {
        Student sobj = new Student(str,value,Address);
        lobj.add(sobj);
		System.out.println("Query Inserted Sucsesful");
    }

    //Display ALL
    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
    }

    //Display By RID
    public void DisplaySpecificR(int rid)
    {
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
            }
        }
    }

    //Display By Name
    public void DisplaySpecificN(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
                break;
            }
        }
    }

    //Delete by RID
    public void DeleteSpecificR(int rid)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }
    //Delete by name
    public void DeleteSpecificN(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }
	
	//Display Greater salary
    public void Greater(int Con)
    {
        for(Student sref : lobj)
        {
            if(sref.Salary > Con)
            {
                System.out.println(sref.Salary);
            }
        }
    }
	
	//Display Smaller salary
    public void Smaller(int Condi)
    {
        for(Student sref : lobj)
        {
            if(sref.Salary < Condi)
            {
                System.out.println(sref.Salary);
            }
        }
    }

    //Display Max salary
    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having maximum salary : ");
        temp.DisplayData();
    }

    //Display Min salary
    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having minimum salary : ");
        temp.DisplayData();
    }

    //Display Sumation salary
    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaris is :"+iSum);
    }

    //Display Avarage salary
    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaris is :"+iSum/(lobj.size()));
    }

    //Count LinkedList
    public void AggregateCount()
    {
        System.out.println("Count is :"+lobj.size());
    }
	
	
}

class DBMSP
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();  

        
    }
}