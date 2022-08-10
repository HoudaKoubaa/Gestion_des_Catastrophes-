package com.telcotec.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.telcotec.spring.entities.Sms;
import com.telcotec.spring.repository.SmsRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Component
public class SMSService implements ISMSService{
	@Autowired 
	SmsRepository sp;
	private final static String ACCOUNT_SID = "ACbd0465cdfb7161eab0df2b4ce624d803";
	   private final static String AUTH_TOKEN = "afa900da37d3304bc3139e53df6c89d0";
	   private final String FROM_NUMBER = "+18454426213";

    public void send(Sms sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
            }
   
    public String addSMS(Sms s) {
    	sp.save(s);
    	return "add";
    }
    
    
    
    public void sendSms()
    {Sms sms=new Sms();;
        String AK = "213e03f55f89c36b";
        String AS = "47134e0f3cc6d33df69dae8e022c0916";
        String CK = "47134e0f3cc6d33df69dae8e022c0916";

        String ServiceName = "sms-xx000000-1";
        String METHOD = "POST";
        try {
            URL    QUERY  = new URL("https://eu.api.ovh.com/1.0/sms/"+ServiceName+"/jobs");
            String BODY   = "{\"receivers\""+sms.getTo()+"\"message\":"+sms.getMessage()+"\"priority\":\"high\",\"senderForResponse\":true}";

            long TSTAMP  = new Date().getTime()/1000;

            //Création de la signature
            String toSign    = AS + "+" + CK + "+" + METHOD + "+" + QUERY + "+" + BODY + "+" + TSTAMP;
            String signature = "$1$" + HashSHA1(toSign);
            System.out.println(signature);

            HttpURLConnection req = (HttpURLConnection)QUERY.openConnection();
            req.setRequestProperty("Content-Type",      "application/json");
            req.setRequestProperty("X-Ovh-Application", AK);
            req.setRequestProperty("X-Ovh-Consumer",    CK);
            req.setRequestProperty("X-Ovh-Signature",   signature);
            req.setRequestProperty("X-Ovh-Timestamp",   "" + TSTAMP);

            if(!BODY.isEmpty())
            {
            	
                req.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(req.getOutputStream());
                wr.writeBytes(BODY);
                wr.flush();
                wr.close();
            }

            String inputLine;
            BufferedReader in;
            int responseCode = req.getResponseCode();
            if ( responseCode == 200 )
            {
                //Récupération du résultat de l'appel
                in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            }
            else
            {
                in = new BufferedReader(new InputStreamReader(req.getErrorStream()));
            }
            StringBuffer response   = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Affichage du résultat     
            System.out.println(response.toString());

        } catch (MalformedURLException e) {
            final String errmsg = "MalformedURLException: " + e;
        } catch (IOException e) {
            final String errmsg = "IOException: " + e;
        }
    }
    
    public static String HashSHA1(String text) 
    {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] sha1hash = new byte[40];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            sha1hash = md.digest();
            return convertToHex(sha1hash);
        } catch (NoSuchAlgorithmException e) {
            final String errmsg = "NoSuchAlgorithmException: " + text + " " + e;
            return errmsg;
        } catch (UnsupportedEncodingException e) {
            final String errmsg = "UnsupportedEncodingException: " + text + " " + e;
            return errmsg;
        }
    }
    
    private static String convertToHex(byte[] data)
    { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    }
    
    
   
}
