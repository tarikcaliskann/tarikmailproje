package mailproje;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;



public class mailproje {
	  public static void sendMail(String to , String wr)
	    {

	                // Sender's email ID needs to be mentioned
	                String from = "tarikcaliskan03@gmail.com";

	                // Assuming you are sending email from through gmails smtp
	                String host = "smtp.gmail.com";

	                // Get system properties
	                Properties properties = System.getProperties();

	                // Setup mail server
	                properties.put("mail.smtp.host", host);
	                properties.put("mail.smtp.port", "465");
	                properties.put("mail.smtp.ssl.enable", "true");
	                properties.put("mail.smtp.auth", "true");

	                // Get the Session object.// and pass username and password
	                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	                    protected PasswordAuthentication getPasswordAuthentication() {

	                        return new PasswordAuthentication("tarikcaliskan03@gmail.com", "efydgpucxkbptzcn");

	                    }

	                });

	                // Used to debug SMTP issues
	                session.setDebug(true);

	                try {
	                    // Create a default MimeMessage object.
	                    MimeMessage message = new MimeMessage(session);

	                    // Set From: header field of the header.
	                    message.setFrom(new InternetAddress(from));

	                    // Set To: header field of the header.
	                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	                    // Set Subject: header field
	                    message.setSubject("EMAİL");
	                    
	                    // Now set the actual message
	                    message.setText(wr);

	                    System.out.println("sending to: " + to);
	                    // Send message
	                    Transport.send(message);
	                    System.out.println("Sent message successfully....");
	                } catch (MessagingException mex) {
	                    mex.printStackTrace();
	                }
	    }

    public static class Uye{

        public String name;
        public String surname;
        public String email;
        public String getName() {
            return name;
        }
        public Uye(String name, String surname, String email) {
            this.name = name;
            this.surname = surname;
            this.email = email;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    }
    public static class ElitUye extends Uye{


        public ElitUye(String name, String surname, String email) {
            super(name, surname, email);
        }
    }
    public static class GenelUye extends Uye{


        public GenelUye(String name, String surname, String email) {
            super(name, surname, email);
        }
    }


    public static void main(String[] args) {
        boolean flag=false;
        //giriş ekranı
        System.out.println("HOSGELDİNİZ \n   MENU");
        //yapılacak işlem seçimi
        System.out.println("Yapmak İstediğiniz İşlemi Seciniz:");
        System.out.println("1:Elit Uye Ekleme");
        System.out.println("2:Genel Uye Ekleme");
        System.out.println("3:Mail Gonderme");
        Scanner scan= new Scanner(System.in);
        String fileName = "User.txt";
        int choose=scan.nextInt();
        //switch case ile seçilen işlemi yapma
        switch(choose) {
            case 1:
                //kullanıcının bilgilerini alma
                Scanner scan1= new Scanner(System.in);
                System.out.println("kullanıcının ismini giriniz:");
                String isim=scan1.nextLine();
                Scanner scan2= new Scanner(System.in);
                System.out.println("kullanıcının soyismini giriniz:");
                String soyisim=scan2.nextLine();
                Scanner scan3= new Scanner(System.in);
                System.out.println("kullanıcının mailini giriniz:");
                String mail=scan3.nextLine();

                try {
                    //üyeleri yazacak dosya oluşturma
                    File myFile = new File(fileName);
                    if (!myFile.exists()) {
                        myFile.createNewFile();
                        flag=true;
                    }
                    //dosyanın içine elit üyeler ve genel üyeler başlığı yazdırma
                    if(flag==true) {
                        String baslik = "ELİT ÜYELER \n\n\n\n\n GENEL ÜYELER";
                        FileWriter f = new FileWriter(myFile, false);
                        BufferedWriter b = new BufferedWriter(f);
                        b.write(baslik);
                        b.close();
                    }
                    BufferedReader br
                            = new BufferedReader(new FileReader(myFile));

                    //dosya bilgileri girilen kişiyi elit üyeler başlığı altına yazdırma
                    ElitUye user = new ElitUye(isim,soyisim,mail);
                    String allStr = "";
                    String st;
                    String temp = user.name + "\t" + user.surname + "\t" + user.email;
                    while ((st = br.readLine()) != null) {
                        if(st.contains("ELİT ÜYELER")) {
                            allStr = allStr + st + "\n";
                            allStr = allStr + temp + "\n";
                        }
                        else {
                            allStr = allStr + st + "\n";
                        }


                    }
                    //dosyanın içine bilgileri girilen kişiyi elit üyeler başlığı altına yazdırma
                    System.out.println("----------------------------------");
                    System.out.println(allStr);
                    FileWriter myWriter = new FileWriter(myFile);
                    myWriter.write(allStr);
                    myWriter.close();

                }
                catch (IOException e) {
                    System.out.println("IOException Occured");
                    e.printStackTrace();
                }

                break;
            case 2:
                //kullanıcının bilgilerini alma
                Scanner scan4= new Scanner(System.in);
                System.out.println("kullanıcının ismini giriniz:");
                String isim2=scan4.nextLine();
                Scanner scan5= new Scanner(System.in);
                System.out.println("kullanıcının soyismini giriniz:");
                String soyisim2=scan5.nextLine();
                Scanner scan6= new Scanner(System.in);
                System.out.println("kullanıcının mailini giriniz:");
                String mail2=scan6.nextLine();

                try {
                    //üyeleri yazacak dosya oluşturma
                    File myFile = new File(fileName);
                    if (!myFile.exists()) {
                        myFile.createNewFile();
                        flag=true;
                    }
                    //dosyanın içine elit üyeler ve genel üyeler başlığı yazdırma
                    if(flag==true) {
                        String giris = "ELİT ÜYELER \n\n\n\n\n GENEL ÜYELER";
                        FileWriter f = new FileWriter(myFile, false);
                        BufferedWriter b = new BufferedWriter(f);
                        b.write(giris);
                        b.close();
                    }
                    BufferedReader br
                            = new BufferedReader(new FileReader(myFile));
                    //dosya bilgileri girilen kişiyi genel üyeler başlığı altına yazdırma
                    GenelUye user = new GenelUye(isim2,soyisim2,mail2);
                    String allStr = "";
                    String st;
                    String temp = user.name + "\t" + user.surname + "\t" + user.email;
                    while ((st = br.readLine()) != null) {
                        if(st.contains("GENEL ÜYELER")) {
                            allStr = allStr + st + "\n";
                            allStr = allStr + temp + "\n";
                        }
                        else {
                            allStr = allStr + st + "\n";
                        }

                    }
                    //dosyanın içine bilgileri girilen kişiyi elit üyeler başlığı altına yazdırma
                    System.out.println("----------------------------------");
                    System.out.println(allStr);

                    FileWriter myWriter = new FileWriter(myFile);
                    myWriter.write(allStr);
                    myWriter.close();

                }
                catch (IOException e) {
                    System.out.println("IOException Occured");
                    e.printStackTrace();
                }

                break;
            case 3:
                
                System.out.println("Hangi Uyelere Mail Atmak Istiyorsunuz?");
                System.out.println("1:Elit Uyelere Mail");
                System.out.println("2:Genel Uyelere Mail");
                System.out.println("3:Tum Uyelere Mail");
                Scanner scan7= new Scanner(System.in);
                int send=scan7.nextInt();
                switch(send) {
                    case 1:
                        try {
                            File myFile = new File(fileName);
                            if (!myFile.exists()) {
                                myFile.createNewFile();
                                flag=true;
                            }
                          //dosya baslangıc bilgileri
            	            if(flag==true) {
                   	          String giris="	GENEL ÜYELER\nn\n\n\n	ELİT ÜYELER\n";
                   	          FileWriter f= new FileWriter(myFile,false);
                 	            BufferedWriter b= new BufferedWriter(f);
                 	            b.write(giris);
                 	            b.close();
                               }
                            BufferedReader br= new BufferedReader(new FileReader(myFile));

                            String allStr = "";
                            Boolean elitFlag = false;
                            String st;
                            ArrayList<String> email = new ArrayList<String>();
                            
                            System.out.println("Atacıgınız maili girin:");
                            Scanner scan8= new Scanner(System.in);
                            String yazi=scan8.nextLine();
                            
                            while ((st = br.readLine()) != null) {

                                if(st.contains("GENEL ÜYELER")) {
                                    elitFlag = false;
                                }

                                if(elitFlag == true) {
                                    allStr = allStr + st + "\n";
                                }

                                if(st.contains("ELİT ÜYELER")) {
                                    elitFlag = true;
                                }
                            }

                            System.out.println("Elit kullanıcılara mail attınız.Mail atılan kullanıcılar: ");
                            System.out.println(allStr);


                        }
                        catch (IOException e) {
                            System.out.println("IOException Occured");
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            File myFile = new File(fileName);
                            if (!myFile.exists()) {
                                myFile.createNewFile();
                            }
                            BufferedReader br= new BufferedReader(new FileReader(myFile));

                            String allStr = "";
                            Boolean genelFlag = false;
                            String st;
                            ArrayList<String> email = new ArrayList<String>();
                            
                            System.out.println("Atacıgınız maili girin:");
                            Scanner scan8= new Scanner(System.in);
                            String yazi=scan8.nextLine();
                            while ((st = br.readLine()) != null) {

                                if(st.contains("ELİT ÜYELER")) {
                                    genelFlag = false;
                                }

                                if(genelFlag == true) {
                                	  StringTokenizer st1= new StringTokenizer(st , "\t");
                                      String strr = null;
                                      for (int i = 1; st1.hasMoreTokens(); i++){
                                          String str = st1.nextToken();
                                          if(str.contains("@")){
                                              strr = str;
                                              break;
                                          }
                                      }

                                      if(strr != null)
                                      {
                                          sendMail(strr, yazi);   
                                      }
                                      
                                    allStr = allStr + st + "\n";
                                }

                                if(st.contains("GENEL ÜYELER")) {
                                    genelFlag = true;
                                }
                            }

                            System.out.println("Genel kullanıcılara mail attınız. \nMail atılan kullanıcılar: ");
                            System.out.println(allStr);


                        }
                        catch (IOException e) {
                            System.out.println("IOException Occured");
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            File myFile = new File(fileName);
                            if (!myFile.exists()) {
                                myFile.createNewFile();
                            }
                            BufferedReader br
                                    = new BufferedReader(new FileReader(myFile));
                            boolean t=false;
                            String allStr = "";
                            String st;
                            ArrayList<String> email = new ArrayList<String>();
                            System.out.println("Atacıgınız maili girin:");
                            Scanner scan8= new Scanner(System.in);
                            String yazi=scan8.nextLine();

                            while ((st = br.readLine()) != null) {
            		        
            		        
                            			StringTokenizer st1 = new StringTokenizer(st , "\t");
                                    String strr = null;
                                    for (int i = 1; st1.hasMoreTokens(); i++){
                                        String str = st1.nextToken();
                                        if(str.contains("@")){
                                            strr = str;
                                            break;
                                        }
                                    }

                                    if(strr != null)
                                    {
                                        sendMail(strr, yazi);   
                                    }
                                    
            		        		allStr = allStr + st + "\n";
            		        	}
            		        	
            	
                    	
            		        
            		        
            		        System.out.println("Tüm kullanıcılara mail attınız. Mail atılan kullanıcılar: ");
            		        System.out.println(allStr);
            		        
            		        	
            	        }
            	        catch (IOException e) {
            	            System.out.println("IOException Occured");
            	            e.printStackTrace();
            	        }

                break;



        }

    }

}}