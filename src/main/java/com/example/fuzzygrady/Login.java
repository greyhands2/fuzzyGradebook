package com.example.fuzzygrady;
import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static org.dizitart.no2.Document.createDocument;
import static org.dizitart.no2.filters.Filters.and;
import static org.dizitart.no2.filters.Filters.eq;

public  class Login extends JFrame implements ActionListener{
    private Container sc;
    private JLabel stitle;
    private JLabel uName;
    private JTextField tuName;
    private JLabel pass;
    private JPasswordField tPass;
    private JButton ssubmit;
    private JButton back;
    private boolean found=false;
    private Document doc=null;

    private Nitrite db;
    public Login(Nitrite db){

        this.db=db;
        setTitle("Sign Up");
        setBounds(300,90,900,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);


        sc=getContentPane();
        sc.setLayout(null);

        stitle= new JLabel("Login");
        stitle.setFont(new Font("Arial", Font.PLAIN, 30));
        stitle.setSize(300, 30);
        stitle.setLocation(300,30);
        sc.add(stitle);

        uName=new JLabel("Username");
        uName.setFont(new Font("Arial", Font.PLAIN, 20));
        uName.setSize(100,20);
        uName.setLocation(100,100);
        sc.add(uName);

        tuName= new JTextField();
        tuName.setFont(new Font("Arial", Font.PLAIN, 15));
        tuName.setSize(190,20);
        tuName.setLocation(200, 100);
        sc.add(tuName);

        pass=new JLabel("Password");

        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100,20);
        pass.setLocation(100,150);
        sc.add(pass);

        tPass= new JPasswordField();
        tPass.setEchoChar('*');
        tPass.setFont(new Font("Arial", Font.PLAIN, 15));
        tPass.setSize(190,20);
        tPass.setLocation(200, 150);
        sc.add(tPass);


        ssubmit= new JButton("Login");
        ssubmit.setFont(new Font("Arial", Font.PLAIN, 15));
        ssubmit.setSize(100,20);
        ssubmit.setLocation(100,250);
        ssubmit.addActionListener(this);
        sc.add(ssubmit);

        back= new JButton("Sign Up");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100,20);
        back.setLocation(300,250);
        back.addActionListener(this);
        sc.add(back);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ssubmit){
            //store data in JPA





            NitriteCollection collection = db.getCollection("fuzzygradey");

            Cursor cursor = collection.find(

                            and(
                                    eq("username",tuName.getText()),
                                    eq("password",String.valueOf(tPass.getPassword()))
                            )
            );

            for (Document document : cursor) {

                // process the document


                    this.found=true;
                    this.doc=document;
                    break;


            }

            if(this.found){
                this.dispose();

                RegForm f = new RegForm(this.db,this.doc);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Credentials","Error",JOptionPane.ERROR_MESSAGE);
            }



        } else if(e.getSource()==back){
            this.dispose();
            Signup s=new Signup(this.db);
        }
    }
}

