package com.rots87.mascotas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email extends AppCompatActivity implements View.OnClickListener {

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText email, sub, body;
    String correo, asunto, cuerpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.footprint);
        actionBar.setDisplayShowHomeEnabled(true);
        context = this;
        Button enviar = (Button) findViewById(R.id.btnEnviar);
        email = (EditText) findViewById(R.id.email);
        sub = (EditText) findViewById(R.id.asunto);
        body = (EditText) findViewById(R.id.cuerpo);

        enviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        correo = email.getText().toString();
        asunto = sub.getText().toString();
        cuerpo = sub.getText().toString();
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        session = Session.getDefaultInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication("tmaildeveloper@gmail.com","master38");
        }
        });

        pdialog = ProgressDialog.show(context, "", "Enviando Correo", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();

    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params){
            try{
                Message message = new MimeMessage(session);
                message.setReplyTo(InternetAddress.parse(correo));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("courseraandroidtask@mailinator.com"));
                message.setSubject(asunto);
                message.setContent(cuerpo,"text/html; charset=utf-8");
                Transport.send(message);

            } catch (MessagingException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        return null;
        }
    @Override
        protected void onPostExecute(String result){
        pdialog.dismiss();
        email.setText("");
        sub.setText("");
        body.setText("");
        Toast.makeText(getApplicationContext(),"Mensaje Enviado", Toast.LENGTH_SHORT).show();
    }
    }
}
