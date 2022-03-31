
package com.example.fuzzygrady;
import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.objects.ObjectRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static org.dizitart.no2.Document.createDocument;
import static org.dizitart.no2.filters.Filters.and;
import static org.dizitart.no2.filters.Filters.eq;


public class RegForm extends JFrame implements ActionListener{

    private Container c;
    private JLabel title;
    private JLabel  fName;
    private JTextField tfName;
    private JLabel lName;
    private JTextField tlName;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gendGrp;
    private JLabel matNum;
    private JTextField tmatNum;
    private JLabel dept;
    private JTextField tdept;
    private JLabel level;
    private JTextField tlevel;
    private JLabel courseName;
    private JTextField tcourseName;
    private JLabel attendance;
    private JTextField tattendance;
    private JLabel classParticipation;
    private JTextField tclassParticipation;
    private JLabel test;
    private JTextField ttest;
    private JLabel exam;
    private JTextField texam;
    private JButton submit;
    private JButton reset;
    private JButton viewer;
    private Student s;
    private Document doc;



    private Nitrite db;


    public RegForm(Nitrite db, Document doc){
            this.doc=doc;
            this.db=db;



            System.out.println("the id");
            System.out.println(String.valueOf(this.doc.get("_id")));

        setTitle("Fuzzy Grade Book");
        setBounds(300,90,900,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);


        c=getContentPane();
        c.setLayout(null);

        title= new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300,30);
        c.add(title);

        fName=new JLabel("First Name");
        fName.setFont(new Font("Arial", Font.PLAIN, 20));
        fName.setSize(100,20);
        fName.setLocation(100,100);
        c.add(fName);

        tfName= new JTextField();
        tfName.setFont(new Font("Arial", Font.PLAIN, 15));
        tfName.setSize(190,20);
        tfName.setLocation(200, 100);
        c.add(tfName);

        lName=new JLabel("Last Name");
        lName.setFont(new Font("Arial", Font.PLAIN, 20));
        lName.setSize(100,20);
        lName.setLocation(100,150);
        c.add(lName);

        tlName= new JTextField();
        tlName.setFont(new Font("Arial", Font.PLAIN, 15));
        tlName.setSize(190,20);
        tlName.setLocation(200, 150);
        c.add(tlName);

        gender=new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100,20);
        gender.setLocation(100,200);
        c.add(gender);

        male=new JRadioButton("Male");
        male.setFont(new Font("Arial",Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75,20);
        male.setLocation(200,200);
        c.add(male);

        female=new JRadioButton("Female");
        female.setFont(new Font("Arial",Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80,20);
        female.setLocation(275,200);
        c.add(female);

        gendGrp=new ButtonGroup();
        gendGrp.add(male);
        gendGrp.add(female);

        matNum=new JLabel("Matric Number");
        matNum.setFont(new Font("Arial", Font.PLAIN, 20));
        matNum.setSize(200,20);
        matNum.setLocation(100,250);
        c.add(matNum);

        tmatNum= new JTextField();
        tmatNum.setFont(new Font("Arial",Font.PLAIN, 15));
        tmatNum.setSize(190,20);
        tmatNum.setLocation(250,250);
        c.add(tmatNum);

        dept=new JLabel("Department");
        dept.setFont(new Font("Arial", Font.PLAIN, 20));
        dept.setSize(200,20);
        dept.setLocation(100,300);
        c.add(dept);

        tdept= new JTextField();
        tdept.setFont(new Font("Arial",Font.PLAIN, 15));
        tdept.setSize(190,20);
        tdept.setLocation(230,300);
        c.add(tdept);

        level=new JLabel("Level");
        level.setFont(new Font("Arial", Font.PLAIN, 20));
        level.setSize(200,20);
        level.setLocation(100,350);
        c.add(level);

        tlevel= new JTextField();
        tlevel.setFont(new Font("Arial",Font.PLAIN, 15));
        tlevel.setSize(190,20);
        tlevel.setLocation(180,350);
        c.add(tlevel);

        courseName=new JLabel("Course Name");
        courseName.setFont(new Font("Arial", Font.PLAIN, 20));
        courseName.setSize(200,20);
        courseName.setLocation(100,400);
        c.add(courseName);

        tcourseName= new JTextField();
        tcourseName.setFont(new Font("Arial",Font.PLAIN, 15));
        tcourseName.setSize(190,20);
        tcourseName.setLocation(240,400);
        c.add(tcourseName);


        attendance=new JLabel("Course Attendance (%)");
        attendance.setFont(new Font("Arial", Font.PLAIN, 20));
        attendance.setSize(250,20);
        attendance.setLocation(100,450);
        c.add(attendance);

        tattendance= new JTextField();
        tattendance.setFont(new Font("Arial",Font.PLAIN, 15));
        tattendance.setSize(190,20);
        tattendance.setLocation(320,450);
        c.add(tattendance);
        //ensureNumberInput( tattendance,  attendance,"Course Attendance (%)");


        classParticipation=new JLabel("Class Participation (%)");
        classParticipation.setFont(new Font("Arial", Font.PLAIN, 20));
        classParticipation.setSize(250,20);
        classParticipation.setLocation(100,500);
        c.add(classParticipation);

        tclassParticipation= new JTextField();
        tclassParticipation.setFont(new Font("Arial",Font.PLAIN, 15));
        tclassParticipation.setSize(190,20);
        tclassParticipation.setLocation(320,500);
        c.add(tclassParticipation);
        //ensureNumberInput( tclassParticipation,  classParticipation,"Class Participation (%)");



        test=new JLabel("Test Score (%)");
        test.setFont(new Font("Arial", Font.PLAIN, 20));
        test.setSize(250,20);
        test.setLocation(100,550);
        c.add(test);

        ttest= new JTextField();
        ttest.setFont(new Font("Arial",Font.PLAIN, 15));
        ttest.setSize(190,20);
        ttest.setLocation(320,550);
        c.add(ttest);
        //ensureNumberInput( ttest,  test,"Test Score (%)");



        exam=new JLabel("Exam Score (%)");
        exam.setFont(new Font("Arial", Font.PLAIN, 20));
        exam.setSize(250,20);
        exam.setLocation(100,600);
        c.add(exam);

        texam= new JTextField();
        texam.setFont(new Font("Arial",Font.PLAIN, 15));
        texam.setSize(190,20);
        texam.setLocation(320,600);
        c.add(texam);
        //ensureNumberInput( texam,  exam,"Exam Score (%)");

        submit= new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100,20);
        submit.setLocation(100,650);
        submit.addActionListener(this);
        c.add(submit);

        reset= new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100,20);
        reset.setLocation(300,650);
        reset.addActionListener(this);
        c.add(reset);


        viewer= new JButton("View Data");
        viewer.setFont(new Font("Arial", Font.PLAIN, 15));
        viewer.setSize(100,20);
        viewer.setLocation(500,650);
        viewer.addActionListener(this);
        c.add(viewer);

        setVisible(true);













    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==submit){
    //store data in JPA
            String gendr;
            if(male.isSelected())
                gendr="Male";
            else
                gendr="Female";
            double attendce= Double.parseDouble(tattendance.getText());
            double classParticipatn= Double.parseDouble(tclassParticipation.getText());
            double testr= Double.parseDouble(ttest.getText());
            double exame=Double.parseDouble(texam.getText());
            String matNum=tmatNum.getText();
//            Cursor<Student> cursor = this.repository.find(where("matNum").eq(matNum));
//            Student stud = cursor.firstOrNull();
            boolean redundant=false;
            NitriteCollection collection1 = db.getCollection("savedData");
            Cursor cursor = collection1.find(
                    // and clause
                    and(
                            // firstName == John
                            eq("matNum", matNum),
                            eq("loggedUser", this.doc.get("_id"))
                    )
            );
            for (Document document : cursor) {

                // process the document
                if((String.valueOf(document.get("matNum")).equals(matNum)) && (String.valueOf(document.get(
                        "loggedUser"))).equals(String.valueOf(this.doc.get("_id")))){
                    redundant=true;
                    break;
                }






            }


            if(redundant){

                JOptionPane.showMessageDialog(null, "Matric Number is Unique","Error",JOptionPane.ERROR_MESSAGE);

            }else{

                this.s = new Student();
                this.s.setfName(tfName.getText());
                this.s.setlName(tlName.getText());
                this.s.setGender(gendr);
                this.s.setMatNum(tmatNum.getText());
                this.s.setDept(tdept.getText());
                this.s.setLevel(tlevel.getText());
                this.s.setCourseName(tcourseName.getText());
                this.s.setAttendance(attendce);
                this.s.setClassParticipation(classParticipatn);
                this.s.setTest(testr);
                this.s.setExam(exame);
                this.s.setTotal();
                this.s.setFuzzyTotal();
                this.s.setGrade();
                this.s.setFuzzyGrade();

                Document doc1 = createDocument("fName", this.s.getfName())
                        .put("lName", this.s.getlName())
                        .put("gender",this.s.getGender())
                        .put("matNum",this.s.getMatNum())
                        .put("dept",this.s.getDept())
                        .put("level",this.s.getLevel())
                        .put("courseName",this.s.getCourseName())
                        .put("attendance",this.s.getAttendance())
                        .put("classParticipation",this.s.getClassParticipation())
                        .put("test",this.s.getTest())
                        .put("exam",this.s.getExam())
                        .put("total",this.s.getTotal())
                        .put("fuzzyTotal",this.s.getFuzzyTotal())
                        .put("grade",this.s.getGrade())
                        .put("fuzzyGrade",this.s.getFuzzyGrade())
                        .put("loggedUser",this.doc.get("_id"));
                collection1.insert(doc1);


                JOptionPane.showMessageDialog(null, "Student Data Added","Success",JOptionPane.INFORMATION_MESSAGE);

            }



        } else if(e.getSource()==reset){
            String empty="";
            ttest.setText(empty);
            tfName.setText(empty);
            tlName.setText(empty);
            texam.setText(empty);
            tclassParticipation.setText(empty);
            tattendance.setText(empty);
            tcourseName.setText(empty);
            tlevel.setText(empty);
            tdept.setText(empty);
            tmatNum.setText(empty);

            ttest.setEditable(true);
            tfName.setEditable(true);
            tlName.setEditable(true);
            texam.setEditable(true);
            tclassParticipation.setEditable(true);
            tattendance.setEditable(true);
            tcourseName.setEditable(true);
            tlevel.setEditable(true);
            tdept.setEditable(true);
            tmatNum.setEditable(true);
        } else if(e.getSource()==viewer){

            ArrayList<Document> students=new ArrayList<Document>();NitriteCollection collection2 = db.getCollection(
                    "savedData");
            Cursor cursor = collection2.find(
                    // and clause
                    and(
                            // firstName == John

                            eq("loggedUser", this.doc.get("_id"))
                    )
            );
            for (Document document : cursor) {

                // process the document

                System.out.println(document.get("total"));
                students.add(document);


            }

            Tabularize t = new Tabularize(students);


        }
    }





}
