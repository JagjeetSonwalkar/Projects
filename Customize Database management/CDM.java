import java.util.*;

// class Employee
class Employee
{
    // characteristics 
    public int Eno ;
    public String Ename ;
    public int Eage ;
    public String Eaddress ;
    public int Esalary ;

    public static int Counter ;

    static
    {
        Counter = 1 ;
    }

    // Constructor of Employee
    public Employee(String B , int C , String D , int E)
    {
        Eno = Counter++ ;
        Ename = B ;
        Eage = C ;
        Eaddress = D ;
        Esalary = E ;
    }

    // Display Function
    public void DisplayInformation()
    {
        System.out.println(Eno + "\t"+ Ename + "\t"+ Eage + "\t"+ Eaddress + "\t\t"+ Esalary);
    }
}

// class DBMS
class DBMS
{
    // LinkedList of Employee as characteristics 
    public LinkedList <Employee> lobj ;

    // Constructor of DBMS
    public DBMS()
    {
        System.out.println("DBMS started succesfully.");
        lobj = new LinkedList<Employee>() ;
    }

    // finalize(Distructor) of DBMS : To deallocate the resources
    protected void finalize()
    {
        System.out.println("Deallocating all resources of DBMS");
        lobj.clear();
        lobj = null ;
    }

    // insert into  employee values("X",25,"Pune",40000);
    public void InsertIntoTable(String name ,int age , String Address , int Salary)
    {
        Employee eobj = new Employee(name,age,Address,Salary);
        lobj.addLast(eobj);
        System.out.println("Record inserted succesfully into the table.");
    }

    // select * from Emplyee;
    public void selectStarFrom()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("No\t Name \t Age \t Address \t Salary");
        System.out.println("-------------------------------------------------------------------");
        for(Employee eref : lobj)
        {
            eref.DisplayInformation();
        }
        System.out.println("-------------------------------------------------------------------");
    }

    // Select * from employee where Eno = 3
    public void SelectSpecific(int id)
    {
        for(Employee eref : lobj)
        {
            if(eref.Eno == id)
            {
                eref.DisplayInformation();
                break;
            }
        }
    }

    // Select * from employee where Ename = Rohit
    public void SelectSpecific(String name)
    {
        for(Employee eref : lobj)
        {
            if(name.equals(eref.Ename))         // <OR> if(eref.Ename == name)
            {
                eref.DisplayInformation();
                break;
            }
        }
    }

    // delete from Emplyee where Eno = 2
    public void DeleteData(int no)
    {
        int iIndex = 0 ;
        boolean bFlag = false ;

        for(Employee eref : lobj)
        {
            if(eref.Eno == no)
            {
                bFlag = true ;
                break ;
            }
            iIndex++ ;
        }

        if(bFlag == false)
        {
            System.out.println("Unable to remove the element as element is not there in DB !!");
        }
        else
        {
            lobj.remove(iIndex);
        }
    }

    // delete from Employee where Enmae = "XMAN"
    public void DeleteData(String name)
    {
        int iIndex = 0 ;
        boolean bFlag = false ;

        for(Employee eref : lobj)
        {
            if(name.equals(eref.Ename))
            {
                bFlag = true ;
                break ;
            }
            iIndex++ ;
        }

        if(bFlag == false)
        {
            System.out.println("Unable to remove the element as element is not there in DB !!");
        }
        else
        {
            lobj.remove(iIndex);
        }
    }

    // select Count(Eno) from Employee (Total Employee)
    public void AggregateCount()
    {
        System.out.println("Number of records in Employee table :"+lobj.size());
    }

    // select Count(Esalary) from Employee (Total salary)
    public void AggregateSum()
    {
        int iSum = 0 ;

        for(Employee eref : lobj)
        {
            iSum = iSum + eref.Esalary ;
        }
        System.out.println("Summation of records in the Employee table : "+iSum);
    }

    // select Avg(ESalary) from Employee
    public void AggregateAvg()
    {
        int iSum = 0 ;

        for(Employee eref : lobj)
        {
            iSum = iSum + eref.Esalary ;
        }
        System.out.println("Average of records in the Employee table : "+(iSum/lobj.size()));
    }

    // select Max(ESalary) from Employee
    public void AggregateMax()
    {
        int iMax = lobj.get(0).Esalary ;

        for(Employee eref : lobj)
        {
            if(eref.Esalary > iMax)
            {
                iMax = eref.Esalary ;
            }
        }
        System.out.println("Maximum of records in the Employee table : "+iMax);
    }

    // select Min(Esalary) from Empoyee
    public void AggregateMin()
    {
        int iMin = lobj.get(0).Esalary ;

        for(Employee eref : lobj)
        {
            if(eref.Esalary < iMin)
            {
                iMin = eref.Esalary ;
            }
        }
        System.out.println("Minimum of records in the Employee table : "+iMin);
    }

    // Update Employee set Address = "Sangli" where Eno = 3 ;
    public void UpdateRecord(int no , String Address)
    {
        int iIndex = 0 ;

        for(Employee eref : lobj)
        {
            if(eref.Eno == no)
            {
                eref.Eaddress = Address ;
                lobj.set(iIndex,eref);
                break ;
            }
            iIndex++ ;
        }
    }
}

class CDM
{
    // Entry point function : main
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Welcome to DBMS..");

        DBMS dobj = new DBMS(); // object of DBMS

        int iOption = 0 ;
        String name = null;
        int age = 0 ;
        String Address = null;
        int salary = 0 ;
        int id = 0 ;

       while(true)
       {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Please select your option based on your requirement");

            System.out.println("1 : Insert new record in the table");
            System.out.println("2 : Display all records from the table");
            System.out.println("3 : Display specific record from the table with ID");
            System.out.println("4 : Display specific record from the table with Name");
            System.out.println("5 : Delete the record from table with Name");
            System.out.println("6 : Count number of records from the table");
            System.out.println("7 : Summation of all records salaray");
            System.out.println("8 : Average of all records salaray");
            System.out.println("9 : Maximum of all records salaray");
            System.out.println("10 : Minimum of all records salaray");                
            System.out.println("11 : Update the existing record");     
            System.out.println("12 : Delete the table");
            System.out.println("13 : Terminate the Marvellous DBMS");

            System.out.println("-------------------------------------------------------------------");

            iOption = sobj.nextInt();

            if(iOption == 1)
            {
                System.out.println("Enter the name of employee.");
                name = sobj.next();

                System.out.println("Enter the age of employee.");
                age = sobj.nextInt();

                System.out.println("Enter the Address of employee.");
                Address = sobj.next();

                System.out.println("Enter the salary of employee.");
                salary = sobj.nextInt();

                dobj.InsertIntoTable(name,age,Address,salary);
            }

            else if(iOption == 2)
            {
                dobj.selectStarFrom();
            }

            else if(iOption == 3)
            {
                System.out.println("Enter the employee ID whose data you want to display");
                id = sobj.nextInt();

                dobj.SelectSpecific(id);
            }

            else if(iOption == 4)
            {
                System.out.println("Enter the name of employee whose data you want to display");
                name = sobj.next();

                dobj.SelectSpecific(name);
            }

            else if(iOption == 5)
            {
                System.out.println("Enter the employee name that you want to delete");
                name = sobj.next();

                dobj.DeleteData(name);
            }

            else if(iOption == 6)
            {
                dobj.AggregateCount();
            }

            else if(iOption == 7)
            {
                dobj.AggregateSum();
            }

            else if(iOption == 8)
            {
                dobj.AggregateAvg();
            }

            else if(iOption == 9)
            {
                dobj.AggregateMax();
            }

            else if(iOption == 10)
            {
                dobj.AggregateMin();
            }

            else if(iOption == 11)
            {
                System.out.println("Enter the ID of emplyee that you want to update");
                id = sobj.nextInt();

                System.out.println("Enter the new address");
                Address = sobj.next();

                dobj.UpdateRecord(id,Address);
            }

            else if(iOption == 12)
            {
                dobj = null ;
                System.gc();
                System.out.println("Database deleted succesfully");
            }

            else if(iOption == 13)
            {
                System.out.println("Thank you for using DBMS");
                break;
            }

            else
            {
                System.out.println("Invalid Option");
            }
       }
    }
}


/*

OUTPUT

Welcome to DBMS..
DBMS started succesfully.
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
1
Enter the name of employee.
virat
Enter the age of employee.
42
Enter the Address of employee.
delhi
Enter the salary of employee.
50000
Record inserted succesfully into the table.
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
1
Enter the name of employee.
virat
Enter the age of employee.
45
Enter the Address of employee.
Mumbai
Enter the salary of employee.
45000
Record inserted succesfully into the table.
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
1
Enter the name of employee.
Sunny
Enter the age of employee.
25
Enter the Address of employee.
goa
Enter the salary of employee.
12000
Record inserted succesfully into the table.
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
12000
Invalid Option
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
1
Enter the name of employee.
jaggi
Enter the age of employee.
22
Enter the Address of employee.
pune
Enter the salary of employee.
0
Record inserted succesfully into the table.
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
2
-------------------------------------------------------------------
No       Name    Age     Address         Salary
-------------------------------------------------------------------
1       virat   42      delhi           50000
2       virat   45      Mumbai          45000
3       Sunny   25      goa             12000
4       jaggi   22      pune            0
-------------------------------------------------------------------
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
3
Enter the employee ID whose data you want to display
3
3       Sunny   25      goa             12000
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
3
Enter the employee ID whose data you want to display
1
1       virat   42      delhi           50000
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
4
Enter the name of employee whose data you want to display
sunny
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
4
Enter the name of employee whose data you want to display
Sunny
3       Sunny   25      goa             12000
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
5
Enter the employee name that you want to delete
jaggi
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
2
-------------------------------------------------------------------
No       Name    Age     Address         Salary
-------------------------------------------------------------------
1       virat   42      delhi           50000
2       virat   45      Mumbai          45000
3       Sunny   25      goa             12000
-------------------------------------------------------------------
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
6
Number of records in Employee table :3
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
7
Summation of records in the Employee table : 107000
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
8
Average of records in the Employee table : 35666
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
9
Maximum of records in the Employee table : 50000
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
10
Minimum of records in the Employee table : 12000
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
11
Enter the ID of emplyee that you want to update
1
Enter the new address
Dubai
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
2
-------------------------------------------------------------------
No       Name    Age     Address         Salary
-------------------------------------------------------------------
1       virat   42      Dubai           50000
2       virat   45      Mumbai          45000
3       Sunny   25      goa             12000
-------------------------------------------------------------------
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
12
Database deleted succesfully
Deallocating all resources of DBMS
-------------------------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
3 : Display specific record from the table with ID
4 : Display specific record from the table with Name
5 : Delete the record from table with Name
6 : Count number of records from the table
7 : Summation of all records salaray
8 : Average of all records salaray
9 : Maximum of all records salaray
10 : Minimum of all records salaray
11 : Update the existing record
12 : Delete the table
13 : Terminate the Marvellous DBMS
-------------------------------------------------------------------
2
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "DBMS.selectStarFrom()" because "<local2>" is null
        at Program570.main(Program570.java:295)

*/ 