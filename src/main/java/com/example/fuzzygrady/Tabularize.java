package com.example.fuzzygrady;
import org.dizitart.no2.Document;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class Tabularize {

    private JFrame f;
    private ArrayList<Document> students;
    public Tabularize(ArrayList<Document> students){

    this.students=students;

        f=new JFrame();
        String  col[]={"S/N","First Name","Last Name","Gender","Matric Number","Department","Level",
                "Course Name","Attendance","Class Participation","Test","Exam","Total","Fuzzy Total","Grade","Fuzzy " +
                "Grade"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        // The 0 argument is number rows.

        final JTable table = new JTable(tableModel);

        for(int counter=0; counter<this.students.size(); counter++){

            Object[] data={counter+1, (this.students.get(counter)).get("fName"),
                    this.students.get(counter).get("lName"), this.students.get(counter).get("gender"),
                    this.students.get(counter).get("matNum"), this.students.get(counter).get("dept"),
                    this.students.get(counter).get("level"), this.students.get(counter).get("courseName"),
                    this.students.get(counter).get("attendance"),
                    this.students.get(counter).get("classParticipation")
                    , this.students.get(counter).get("test"),this.students.get(counter).get("exam"),
                    this.students.get(counter).get("total"),
                    this.students.get(counter).get("fuzzyTotal"),
                    this.students.get(counter).get("grade"),
                    this.students.get(counter).get("fuzzyGrade")
            };

           tableModel.addRow(data);
        }




        table.setCellSelectionEnabled(true);
        ListSelectionModel select= table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = table.getSelectedRows();
                int[] columns = table.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) table.getValueAt(row[i], columns[j]);
                    } }
                System.out.println("Table element selected is: " + Data);
            }
        });








    table.setBounds(60,80,900,900);
    JScrollPane sp=new JScrollPane(table);
    f.add(sp);
    f.setSize(1000,800);
    f.setVisible(true);







    }
}
