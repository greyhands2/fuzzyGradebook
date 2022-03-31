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

public  class Signup extends JFrame implements ActionListener{
    private Container sc;
    private JLabel stitle;
    private JLabel  uName;
    private JTextField tuName;
    private JLabel pass;
    private JPasswordField tPass;
    private JButton ssubmit;
    private JButton log;

    private Nitrite db;

    public Signup(Nitrite db){

        this.db=db;
        setTitle("Sign Up");
        setBounds(300,90,900,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);


        sc=getContentPane();
        sc.setLayout(null);

        stitle= new JLabel("Registration Form");
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


        ssubmit= new JButton("Sign Up");
        ssubmit.setFont(new Font("Arial", Font.PLAIN, 15));
        ssubmit.setSize(100,20);
        ssubmit.setLocation(100,250);
        ssubmit.addActionListener(this);
        sc.add(ssubmit);

        log= new JButton("Login");
        log.setFont(new Font("Arial", Font.PLAIN, 15));
        log.setSize(100,20);
        log.setLocation(300,250);
        log.addActionListener(this);
        sc.add(log);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ssubmit){
            //store data in JPA



            boolean found=false;

            // Create a Nitrite Collection
            NitriteCollection collection = db.getCollection("fuzzygradey");
            Cursor cursor = collection.find(

                    and(
                            eq("username",tuName.getText()),
                            eq("password",String.valueOf(tPass.getPassword()))
                    )
            );

            for (Document document : cursor) {
                System.out.println(document.get("username"));
                // process the document
                if((String.valueOf(document.get("username")).equals(tuName.getText())) && (String.valueOf(document.get(
                        "password"))).equals(String.valueOf(tPass.getPassword()))){
                    found=true;
                    break;
                }







            }
            if(found){
                JOptionPane.showMessageDialog(null, "User Already Exists, Use The Login Button","Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                Document doc = createDocument("username", tuName.getText())
                        .put("password", String.valueOf(tPass.getPassword()));
                collection.insert(doc);
                this.dispose();
                Login l=new Login(this.db);
            }




        } else if(e.getSource()==log){
            this.dispose();
            Login l=new Login(this.db);
        }
    }
}
