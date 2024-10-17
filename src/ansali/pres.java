
package ansali;

import java.util.Scanner;

public class pres {
            config con = new config();

    Scanner sc = new Scanner (System.in);
        String choice;
        
        
     public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Prescription date: ");
        String date = sc.next();
        System.out.print("Medication name: ");
        String med = sc.next();
        System.out.print("Dosage: ");
        String dos = sc.next();
      

        String sql = "INSERT INTO tbl_ansali (p_date, p_name, p_dos) VALUES (?, ?, ? )";
        con.addRecord(sql, date, med, dos);
    }
     
     private void view(){
         String Query = "SELECT * FROM tbl_ansali";
        String[] Headers = {"ID","Medication name", "Date", "Dosage"};
        String[] Columns = {"p_id","p_name", "p_date", "p_dos"};
        con.viewRecords(Query, Headers, Columns);
        
     }
      private void update(){
       System.out.println("Enter ID to edit: ");
       int id = sc.nextInt();
       System.out.println("Enter new Medication name: ");
       String name = sc.next();
       System.out.println("Enter new Date: ");
       String date = sc.next();
       System.out.println("Dosage: ");
       String dos = sc.next();
        String sqlUpdate = "UPDATE tbl_ansali SET p_name = ?, p_date = ?, p_dos = ? WHERE p_id = ?";
        con.updateRecord(sqlUpdate, name, date, dos, id);
     }
      private void delete(){
          System.out.println("Select ID to delete: ");
          int id = sc.nextInt();
        String sqlDelete = "DELETE FROM tbl_ansali WHERE p_id = ?";
        con.deleteRecord(sqlDelete, id);
      }

        public void menu(){
        int choice;
             do{
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Choice: ");
        choice = sc.nextInt(); 
        
        switch(choice){
            case 1:
                add();
            break;
            case 2:
                view();
            break;
            case 3:
                view();
                update();
             break;
            case 4:
                view();
                delete();
                view();
                break;
            case 5:
                System.out.println("Thank you for using!!!");
        }
        
        } while (choice !=5);      
}                   
}
