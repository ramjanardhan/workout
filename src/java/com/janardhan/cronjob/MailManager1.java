package com.janardhan.CronJob;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.BodyPart; 
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author janardhan randhi
 */
public class MailManager1 {

    public MailManager1() {
    }

    static {

    }
    private static final String SMTP_AUTH_USER = "mscvp_alerts@miraclesoft.com";
    private static final String SMTP_AUTH_PWD = "Plokam@001";
    private static final String SMTP_HOST = "smtp.miraclesoft.com";
    private static final String PORT = "587";

    public static String sendReportEmail(String email, String lname, String fname, List<String> m1) {
        String[] ToAddressArray;
        System.out.println("data ......" + m1.size());
        System.out.println("SMTP_AUTH_USER " + SMTP_AUTH_USER);
        System.out.println("SMTP_AUTH_PWD " + SMTP_AUTH_PWD);
        System.out.println("SMTP_HOST " + SMTP_HOST);
        System.out.println("PORT " + PORT);

        String mailResponse = null;
        String from = "mscvp_alerts@miraclesoft.com";
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", PORT);

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);

        mailSession.setDebug(true);
        Transport transport;

        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("MEMF E-Mail Alerts Notification");
            message.setFrom(new InternetAddress(from));
            if (email != null && !"".equals(email)) {
                ToAddressArray = email.split("\\,");
                for (int i = 0; i < ToAddressArray.length; i++) {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToAddressArray[i]));
                }
                //message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress("rrandhi@miraclesoft.com"));
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();

            htmlText.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
            htmlText.append("<html xmlns='http://www.w3.org/1999/xhtml'>");
            htmlText.append("<head>");
            htmlText.append("  <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
            htmlText.append("  <title>MSCVP Schedular Email&#33;&#33;</title>");
            htmlText.append("  <style type='text/css'>");

            htmlText.append(" body {");
            htmlText.append("  padding-top: 0 !important;");
            htmlText.append("  padding-bottom: 0 !important;");
            htmlText.append("   padding-top: 0 !important;");
            htmlText.append("  padding-bottom: 0 !important;");
            htmlText.append("   margin:0 !important;");
            htmlText.append("  width: 100% !important;");
            htmlText.append("  -webkit-text-size-adjust: 100% !important;");
            htmlText.append(" -ms-text-size-adjust: 100% !important;;");
            htmlText.append(" -webkit-font-smoothing: antialiased !important;");
            htmlText.append(" }");
            htmlText.append(" .tableContent img {");
            htmlText.append("   border: 0 !important;");
            htmlText.append("  display: block !important;");
            htmlText.append("   outline: none !important;");
            htmlText.append(" }");

            htmlText.append("a{");
            htmlText.append("color:#382F2E;");
            htmlText.append("}");

            htmlText.append("p, h1,h2,ul,ol,li,div{");
            htmlText.append("margin:0;");
            htmlText.append("padding:0;");
            htmlText.append("}");

            htmlText.append("h1,h2{");
            htmlText.append("font-weight: normal;");
            htmlText.append("  background:transparent !important;");
            htmlText.append("border:none !important;");
            htmlText.append("}");

            htmlText.append(".contentEditable h2.big,.contentEditable h1.big{");
            htmlText.append("  font-size: 26px !important;");
            htmlText.append("}");

            htmlText.append(".contentEditable h2.bigger,.contentEditable h1.bigger{");
            htmlText.append("font-size: 37px !important;");
            htmlText.append("}");

            htmlText.append("td,table{");
            htmlText.append("vertical-align: top;");
            htmlText.append("}");

            htmlText.append("td.middle{");
            htmlText.append("vertical-align: middle;");
            htmlText.append("}");

            htmlText.append(" a.link1{");
            htmlText.append("font-size:13px;");
            htmlText.append("color:#27A1E5;");
            htmlText.append("line-height: 24px;");
            htmlText.append("text-decoration:none;");
            htmlText.append("}");

            htmlText.append("a{");
            htmlText.append("text-decoration: none;");
            htmlText.append("}");

            htmlText.append(".link2{");
            htmlText.append("color:#fc3f3f;");
            htmlText.append("border-top:0px solid #fc3f3f;");
            htmlText.append("border-bottom:0px solid #fc3f3f;");
            htmlText.append("border-left:10px solid #fc3f3f;");
            htmlText.append("border-right:10px solid #fc3f3f;");
            htmlText.append("border-radius:1px;");
            htmlText.append("-moz-border-radius:5px;");
            htmlText.append("-webkit-border-radius:5px;");
            htmlText.append("background:#fc3f3f;");
            htmlText.append("}");

            htmlText.append(".link3{");
            htmlText.append("color:#555555;");
            htmlText.append("border:1px solid #cccccc;");
            htmlText.append("padding:10px 18px;");
            htmlText.append("border-radius:3px;");
            htmlText.append("-moz-border-radius:3px;");
            htmlText.append("-webkit-border-radius:3px;");
            htmlText.append("background:#ffffff;");
            htmlText.append("}");

            htmlText.append(".link4{");
            htmlText.append("color:#27A1E5;");
            htmlText.append("line-height: 24px;");
            htmlText.append("}");

            htmlText.append("h2,h1{");
            htmlText.append("line-height: 20px;");
            htmlText.append("}");

            htmlText.append("p{");
            htmlText.append("font-size: 14px;");
            htmlText.append("line-height: 21px;");
            htmlText.append(" color:#AAAAAA;");
            htmlText.append("}");

            htmlText.append(".contentEditable li{");
            htmlText.append("}");

            htmlText.append(".appart p{");
            htmlText.append("}");

            htmlText.append(".bgItem{");
            htmlText.append("background:#ffffff;");
            htmlText.append("}");

            htmlText.append(".bgBody{");
            htmlText.append("background: #0d416b;");
            htmlText.append("}");

            htmlText.append("img {");
            htmlText.append("outline:none;");
            htmlText.append("text-decoration:none;");
            htmlText.append("-ms-interpolation-mode: bicubic;");
            htmlText.append("width: auto;");
            htmlText.append("max-width: 100%;");
            htmlText.append("clear: both;");
            htmlText.append("display: block;");
            htmlText.append("float: none;");
            htmlText.append("}");
            htmlText.append("</style>");

            htmlText.append("<script type='colorScheme' class='swatch active'>");
            htmlText.append("{");
            htmlText.append("'name':'Default',");
            htmlText.append("'bgBody':'ffffff',");
            htmlText.append("'link':'27A1E5',");
            htmlText.append("'color':'AAAAAA',");
            htmlText.append("'bgItem':'ffffff',");
            htmlText.append("'title':'444444'");
            htmlText.append("}");

            htmlText.append("</script>");

            htmlText.append("</head>");
            htmlText.append("<body paddingwidth='0' paddingheight='0' bgcolor='#d1d3d4' style='padding-top: 0; padding-bottom: 0; padding-top: 0; padding-bottom: 0; background-repeat: repeat; width: 100% !important; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased;' offset='0' toppadding='0' leftpadding='0' data-gr-c-s-loaded='true'>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' class='tableContent bgBody' align='center' style='font-family:Helvetica, sans-serif;'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td align='center'>");
            htmlText.append("<table width='600' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td class='bgItem' align='center'>");
            htmlText.append("<table width='600' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td class='movableContentContainer' align='center'>");
            htmlText.append("<div class='movableContent'>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td style='background:#0d416b; border-radius:0px;-moz-border-radius:0px;-webkit-border-radius:0px' height='20'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td style='background:#0d416b; border-radius:0px;-moz-border-radius:0px;-webkit-border-radius:0px'>");
            htmlText.append("<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<div class='contentEditableContainer contentImageEditable'>");
            htmlText.append("<div class='contentEditable'>");
            htmlText.append("<a href='http://www.miraclesoft.com/index.php' target='_blank'>");
            htmlText.append("<img src='http://www.miraclesoft.com/newsletters/others/invite_interconnect_2015/images/logo.png' alt='Logo' height='45' data-default='placeholder' data-max-width='200'>");
            htmlText.append("</a>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("<td valign='middle' style='vertical-align: middle;'>");
            htmlText.append("</td>");
            htmlText.append("<td valign='middle' style='vertical-align: middle;' width='150'>");
            htmlText.append("<br>");
            htmlText.append("<table width='300' border='0' cellpadding='0' cellspacing='0' align='right' style='text-align: right; font-size: 13px; border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;' class='fullCenter'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td height='55' valign='middle' width='100%' style='font-family: Open Sans; color:#232527;'>");
            htmlText.append("<span style='font-family: 'proxima_nova_rgregular', Open Sans; font-weight: normal;'>");
            htmlText.append("<a href='http://www.miraclesoft.com/company/about-us.php' target='_blank' style='text-decoration: none; color:#ffffff;' class='underline'>");
            htmlText.append("Company");
            htmlText.append("</a>");
            htmlText.append("</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;");

            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</div>");
            htmlText.append("<div class='movableContent'>");
            htmlText.append("<table width='580' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td style='border: 0px solid #ffffff; border-radius:0px;-moz-border-radius:0px;-webkit-border-radius:0px'>");
            htmlText.append("<div class='movableContent'>");
            htmlText.append("<table width='660' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td style='background:#00aae7; border-radius:0px;-moz-border-radius:0px;-webkit-border-radius:px'>");
            htmlText.append("<table width='630' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td height='15'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<div class='contentEditableContainer contentTextEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;'>");
            htmlText.append("<h2 style='font-size: 25px;'>");
            htmlText.append("<font color='#ffffff' face='Open Sans'>");
            htmlText.append("<b>Metrics Information</b>");
            htmlText.append("</font>");
            htmlText.append("</h2>");
            htmlText.append("<br>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</div>");
            htmlText.append("<p>");
            htmlText.append("</p>");
            htmlText.append("<p>");
            htmlText.append("</p>");
            htmlText.append("<table width='600' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td height='5'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<div class='contentEditableContainer contentTextEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: left;'>");
            htmlText.append("<br>");
            htmlText.append("<p style='line-height:180%; text-align: justify; font-size: 14px;'>");
            htmlText.append("<font color='##FF0000' face='Open Sans'>");
            htmlText.append("<b><p style='text-align:center'>Hello " + fname + " " + lname + "</p></b>");
            htmlText.append("</font>");
            htmlText.append("</p>");
            htmlText.append("<font color='#232527' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</div>");
            htmlText.append("<font color='#232527' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</div>");
            htmlText.append("<font color='#232527' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td height='0'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<div class='contentEditableContainer contentTextEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;'>");
            htmlText.append("<br>");
            htmlText.append("<font color='#232527' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</div>");
            htmlText.append("<font color='#232527' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</div>");
            htmlText.append("<font color='#232527' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td align='justify' style='padding: 5px 0 5px 0; border-top: 1px #2368a0; border-bottom: 1px #2368a0; font-size: 14px; line-height: 25px; font-family: Open Sans; color: #232527;' class='padding-copy'>");
            htmlText.append("<b style='font-size: 14px; color: #232527;'>");
            htmlText.append("E-Mail Alerts Notification for Metrics Data");
            htmlText.append("<br>");
            htmlText.append("<br>");

            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<table border=2  border-collapse: collapse>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<th>Region</th>");
            htmlText.append("<th>Domain</th>");
            htmlText.append("<th>Success Count</th>");
            htmlText.append("<th>Failure Count</th>");
            htmlText.append("<th>Pending Count</th>");
            htmlText.append("</tr>");
            for (int i = 0; i < m1.size(); i++) {

                System.out.println("in iffff SYSTEM" + m1.get(i));
                String m2 = m1.get(i);
                System.out.println("m2=====" + m2);
                String[] parts = m2.split(",");
                String part1 = parts[0]; 
                System.out.println("part1-----" + part1);
                String part2 = parts[1];
                System.out.println("part2-----" + part2);
                String part3 = parts[2];
                System.out.println("part3-----" + part3);

                htmlText.append("<tr>");
                htmlText.append("<td>AWS</TD>");
                htmlText.append("<td>" + part1 + "</TD>");
                htmlText.append("<td>" + part2 + "</TD>");

                htmlText.append("<td>" + part3 + "</TD>");
                htmlText.append("<td>0</TD>");
                htmlText.append("</tr>");
            }
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");

            htmlText.append("<tr>");
            htmlText.append("<td style='padding-top: 0px;' align='left' valign='top'>");

            htmlText.append("<br>");
            htmlText.append("<br>");
            htmlText.append("<br>");

            htmlText.append("<table class='textbutton' style='margin: 0;' align='left' border='0' cellpadding='0' cellspacing='0'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td align='justify' valign='top' style='margin: 0; padding-top: 5px; font-size:14px ; font-weight: normal; color:#000000; font-family: 'Open Sans'; line-height: 180%;  mso-line-height-rule: exactly;'>");

            htmlText.append("<p style='text-align: justify; font-size: 14px;'><font color='#000000' face='trebuchet ms'>");
            htmlText.append("<b>Thanks&Regards,</b><br/>");
            htmlText.append("<b>Miracle MEMF Team,</b><br/>");
            htmlText.append("Miracle Software Systems, Inc.<br/>");
            htmlText.append("<b> Email: </b>");
            htmlText.append("<a href='mailto:mscvp_alerts@miraclesoft.com '>");
            htmlText.append("mscvp_alerts@miraclesoft.com </a>");
            htmlText.append("<br/>");
            htmlText.append("<b>Phone: </b>");
            htmlText.append("(+1)248-232-0208");
            htmlText.append("</p>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td align='left' style='padding: 5px 0 5px 0; font-size: 14px; line-height: 22px; font-family: Open Sans; color: #ef4048; font-style: italic;' class='padding-copy'>");
            htmlText.append("* Note: Please do not reply to this email as this is an automated notification");
            htmlText.append("</td>");
            htmlText.append("</tr>");

            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("<table width='600' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<div class='contentEditableContainer contentTextEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;'>");
            htmlText.append("<p>");
            htmlText.append("</p>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td height='5'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</div>");
            htmlText.append("<div class='movableContent'>");
            htmlText.append("<table width='660' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td style='background:#0d416b; border-radius:0px;-moz-border-radius:0px;-webkit-border-radius:0px'>");
            htmlText.append("<table width='655' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td colspan='3' height='20'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td width='90'>");
            htmlText.append("</td>");
            htmlText.append("<td width='660' align='center' style='text-align: center;'>");
            htmlText.append("<table width='660' cellpadding='0' cellspacing='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<div class='contentEditableContainer contentTextEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;color:#AAAAAA;'>");
            htmlText.append("<p style='text-align: center; font-size: 14px;'>");
            htmlText.append("<font color='#ffffff' face='Open Sans'>");
            htmlText.append(" ©Copyright 2016 Miracle Software Systems, Inc.<br>");
            htmlText.append("45625 Grand River Avenue<br>");
            htmlText.append("Novi, MI - USA");
            htmlText.append("</font>");
            htmlText.append("</p>");
            htmlText.append("<font color='#ffffff' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</div>");
            htmlText.append("<font color='#ffffff' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</div>");
            htmlText.append("<font color='#ffffff' face='Open Sans'>");
            htmlText.append("</font>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("<td width='90'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td colspan='3' height='20'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td width='195'>");
            htmlText.append("</td>");
            htmlText.append("<td width='190' align='center' style='text-align: center;'>");
            htmlText.append("<table width='190' cellpadding='0' cellspacing='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td width='40'>");
            htmlText.append("<div class='contentEditableContainer contentFacebookEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;color:#AAAAAA;'>");
            htmlText.append("<a href='https://www.facebook.com/miracle45625' target='_blank'>");
            htmlText.append("<img src='http://www.miraclesoft.com/newsletters/others/invite_interconnect_2015/images/fb.png' alt='facebook' width='32' height='32' data-max-width='40' data-customicon='true'>");
            htmlText.append("</a>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("</td>");
            htmlText.append("<td width='40'>");
            htmlText.append("<div class='contentEditableContainer contentTwitterEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;color:#AAAAAA;'>");
            htmlText.append("<a href='https://twitter.com/team_mss' target='_blank'>");
            htmlText.append("<img src='http://www.miraclesoft.com/newsletters/others/invite_interconnect_2015/images/tweet.png' alt='twitter' width='32' height='32' data-max-width='40' data-customicon='true'>");
            htmlText.append("</a>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("</td>");
            htmlText.append("<td width='40'>");
            htmlText.append("<div class='contentEditableContainer contentImageEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;color:#AAAAAA;'>");
            htmlText.append("<a href='https://plus.google.com/+Team_MSS/posts' target='_blank'>");
            htmlText.append("<img src='http://www.miraclesoft.com/newsletters/others/invite_interconnect_2015/images/googleplus.png' alt='Pinterest' width='32' height='32' data-max-width='40'>");
            htmlText.append("</a>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("</td>");
            htmlText.append("<td width='40'>");
            htmlText.append("<div class='contentEditableContainer contentImageEditable'>");
            htmlText.append("<div class='contentEditable' style='text-align: center;color:#AAAAAA;'>");
            htmlText.append("<a href='https://www.linkedin.com/company/miracle-software-systems-inc' target='_blank'>");
            htmlText.append("<img src='http://www.miraclesoft.com/newsletters/others/invite_interconnect_2015/images/linkedin.png' alt='Social media' width='32' height='32' data-max-width='40'>");
            htmlText.append("</a>");
            htmlText.append("</div>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("<td width='195'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td colspan='3' height='40'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</div>");
            htmlText.append("<div class='movableContent'>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>");
            htmlText.append("<tbody>");
            htmlText.append("<tr>");
            htmlText.append("<td style='background:#0d416b; border-radius:0px;-moz-border-radius:0px;-webkit-border-radius:0px' height='0'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</div>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</tbody>");
            htmlText.append("</table>");

            htmlText.append("<span class='gr__tooltip'>");
            htmlText.append("<span class='gr__tooltip-content'>");
            htmlText.append("</span>");
            htmlText.append("<i class='gr__tooltip-logo'>");
            htmlText.append("</i>");
            htmlText.append("<span class='gr__triangle'>");
            htmlText.append("</span>");
            htmlText.append("</span>");
            htmlText.append("</body>");
            htmlText.append("</html>");

            messageBodyPart.setContent(htmlText.toString(), "text/html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            transport.connect();

            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.BCC));

            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

        return "success";
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
