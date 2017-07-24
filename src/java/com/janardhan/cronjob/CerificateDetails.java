package com.janardhan.cronjob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janardhan randhi
 */
public class CerificateDetails {

    String resultString = "";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    public void getAdminMailId() {

        String adminEamil = "";
        String lname = "";
        String fname = "";
        
        try {
            List<String> m1=  MetricsData();
            connection = SqlConnection.getConnection();
            preparedStatement = connection.prepareStatement("Select EMAILID, lastname, firstname from BEF_EMAILALERTS");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
        
                adminEamil = resultSet.getString("EMAILID");
                lname = resultSet.getString("lastname");
                fname = resultSet.getString("firstname");
                System.out.println("fname  is ==>" + fname + "   &&   " + "lname is ==> " + lname + "   &&   " + "adminEamil  is ==>" + adminEamil);

                  
            }
MailManager1.sendReportEmail(adminEamil, lname, fname,m1);
//MailManager1.sendReportEmail(MetricsData());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }

            } catch (SQLException se) {
                throw new SecurityException(se);
            }
        }

    }

    public List<String> MetricsData() {
        String appname = "";
        int infoCount;
        int errorCount;
        String MetricData = "";
        List <String> list=new ArrayList<String>();

        try {
            connection = SqlConnection.getConnection();
            String Query = ("SELECT DISTINCT(t1.APP_NAME) AS appName,(SELECT COUNT(*)  FROM BEF_EVENT_DETAILS t2 WHERE SEVERITY='INFO' AND t1.APP_NAME = t2.APP_NAME AND EVENT_CODE =1 AND EVENT_DESC='Message Transformed Successfully') AS infocount,(SELECT COUNT(*)  FROM BEF_EVENT_DETAILS t3 WHERE SEVERITY='ERROR' AND t1.APP_NAME = t3.APP_NAME  AND EVENT_DESC !='Message Transformed Successfully' AND EVENT_CODE !=1) AS errorcount FROM BEF_EVENT_DETAILS t1;");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                appname = resultSet.getString("appName");
                infoCount = resultSet.getInt("infocount");
                errorCount = resultSet.getInt("errorcount");
//                System.out.println("appname------" + appname);
//                System.out.println("infoCount" + infoCount);
//                System.out.println("errorCount" + errorCount);

                MetricData = appname + "," + infoCount + "," + errorCount;
                System.out.println(MetricData);
                list.add(MetricData);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException se) {
                throw new SecurityException(se);
            }
        }
        System.out.println("list size is ....."+list.size());
return list;
    }

}
