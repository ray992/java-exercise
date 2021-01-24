package com.exercise.email;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailDemo {
    public static void main(String[] args) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient("89a6d401a3a5ee907e22b06a023d1048","15d80fef35dac4dbd969a4bf67e9a8db", new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "noreply@pearpayment.com")
                                        .put("Name", "pearpay"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "1065737061@qq.com")
                                                .put("Name", "yeqiang")))
                                //.put("Email", "leeventy@qq.com")
                                //.put("Name", "leeventy")))
                                .put(Emailv31.Message.SUBJECT, "【MoneyPay(曼尼配)】")
                                .put(Emailv31.Message.TEXTPART, "验证码：1234，切勿泄露或转发他人，以防帐号被盗。如非本人操作请忽略本邮件。验证码10分钟内有效。请勿回复此邮件。")
                                //.put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
                                .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
