package hacpee.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect_DB {
	public void SQL_Connect()throws ClassNotFoundException, SQLException, InterruptedException {
		
        // logger.log(LogStatus.INFO, "<span class='label info'>CONNECT WITH DATA BASE </span>");
		String sql1; String A = "lesi"; String B = "smieley";
		
        // Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"                            
         String dbUrl = "jdbc:oracle:thin:@iadd1saxd5-scan.ihgint.global:1521/SVC_IDMEQ_IDENTITYIQ_R_W";          
         
         
                //Database Username        
                String username = "anbarash";     
     
                //Database Password        
                String password = "Idm2019123";    
                
                Thread.sleep(10000);
                
                System.out.println("Connection Successfull");

                //Query to Execute  
                
                
                
                	
                // insert into identityiq.IHG_WORKDAYFEED_IDM_OI (FIRSTNAME,LASTNAME,WORKERID,PRIMARYWORKLOCATION,PRIMARYWORKADDRESSLINE1,PRIMARYWORKADDRESSLINE2,PRIMARYWORKCITY,PRIMARYWORKSTATE,PRIMARYWORKZIPCODE,PRIMARYWORKISOCOUNTRYCODE,WORKERTYPE,BUSINESSTITLE,MANAGERWORKERID,PARENTDIVISION,WORKTELEPHONENUMBER,WORKMOBILENUMBER,WORKFAXNUMBER,WORKEMAILADDRESS,ALT_WORK_EMAILADDRESS,EMPLOYEESTATUS,DOMAIN,NETWORKID,ORGTYPE,ISMANAGER,WORKERSUBTYPE,LOCATIONTYPE,TERMINATIONDATE,ACTION,JOBBAND,WORKDAYUPDATED,CREAT_TS,CREAT_USR_ID,LST_UPDT_TS,LST_UPDT_USR_ID,DEPT_NM,STRT_DT,ISAD_REQD,WRK_DY_JOB_CD,WRK_DY_JOB_TITLE_TXT,WRK_DY_JOB_FAMILY_NM,LGL_FRST_NM,LGL_LST_NM,SUPERVISORY_ORG_CD,SUPERVISORY_ORG_NM,EC_RPT_LN_NM,DEPT_CD,COST_CTR_CD,COST_CTR_NM,COMPANY_NM) values ('Waney','Nam','012463','IHGHQ ','United States Remote Worker','','','Georgia','30022','USA','EE','Global Account Director (701855)','483054','Global Sales & Marketing','9012901278','7978979780','','','wany.nam@mail.com','Active','','','Corporate','FALSE','regular','Corporate','','Hire','H08','N','07-NOV-19 03.28.12.122000000 AM','Delta Load','07-NOV-19 03.28.12.122000000 AM','Delta Load','WW Sales AMER','07-NOV-19','Y','701855','Global Account Director (701855)','Sales','Waney','Nam','SUPERVISORY_ORGANIZA','','','108860','01266','01266 WW Sales AMER  ','Six Continents Hotels, Inc.');
                sql1  = "insert into identityiq.IHG_WORKDAYFEED_IDM_OI where FIRSTNAME = '"+A+"' AND LASTNAME = '"+B+"'"; // AND WORKERID = '"+B+"' AND PRIMARYWORKLOCATION = '"+B+"' AND PRIMARYWORKADDRESSLINE1 = '"+B+"' AND PRIMARYWORKADDRESSLINE2 = '"+B+"' AND PRIMARYWORKCITY = '"+B+"' AND PRIMARYWORKSTATE = '"+B+"' AND PRIMARYWORKZIPCODE = '"+B+"'  AND PRIMARYWORKISOCOUNTRYCODE = '"+B+"' AND WORKERTYPE = '"+B+"'  AND BUSINESSTITLE = '"+B+"' AND MANAGERWORKERID = '"+B+"'  AND PARENTDIVISION = '"+B+"' AND WORKTELEPHONENUMBER = '"+B+"'  AND WORKMOBILENUMBER = '"+B+"' AND WORKFAXNUMBER = '"+B+"'  AND WORKEMAILADDRESS = '"+B+"' AND ALT_WORK_EMAILADDRESS = '"+B+"' AND EMPLOYEESTATUS = '"+B+"' AND DOMAIN = '"+B+"' AND NETWORKID = '"+B+"' AND ORGTYPE = '"+B+"' AND ISMANAGER = '"+B+"' AND WORKERSUBTYPE = '"+B+"' AND LOCATIONTYPE = '"+B+"' AND TERMINATIONDATE = '"+B+"'  AND JOBBAND = '"+B+"' AND ACTION = '"+B+"' AND WORKDAYUPDATED = '"+B+"' AND CREAT_TS = '"+B+"' AND CREAT_USR_ID = '"+B+"' AND LST_UPDT_TS = '"+B+"' AND LST_UPDT_USR_ID = '"+B+"' AND DEPT_NM = '"+B+"' AND STRT_DT = '"+B+"' AND ISAD_REQD = '"+B+"' AND WRK_DY_JOB_CD = '"+B+"' AND WRK_DY_JOB_TITLE_TXT = '"+B+"' AND WRK_DY_JOB_FAMILY_NM = '"+B+"' AND LGL_FRST_NM = '"+B+"' AND LGL_LST_NM = '"+B+"' AND SUPERVISORY_ORG_CD = '"+B+"' AND SUPERVISORY_ORG_NM = '"+B+"' AND EC_RPT_LN_NM = '"+B+"' AND DEPT_CD = '"+B+"' AND COST_CTR_CD = '"+B+"'AND COST_CTR_NM = '"+B+"' AND COMPANY_NM = '"+B+"' ";
                Thread.sleep(5000);
                System.out.println("Insert Query is updated");
                
                
      //Load mysql jdbc driver            
                try{
                       Class.forName("oracle.jdbc.driver.OracleDriver");
                }
      catch(Exception e){
         System.out.println(e.getMessage());
      }

         //Create Connection to DB        
         Connection con = DriverManager.getConnection(dbUrl,username,password);

         //Create Statement Object        
          Statement stmt = con.createStatement();                                  

         // Execute the SQL Query. Store results in ResultSet        
         ResultSet rs= stmt.executeQuery(sql1); 
         
         
          System. out.println(rs); 
          con.close();        
                 
         }          
          
          // closing DB Connection        
                     
   
}
