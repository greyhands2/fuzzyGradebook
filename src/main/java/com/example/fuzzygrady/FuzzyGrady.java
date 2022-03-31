package com.example.fuzzygrady;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;

import java.util.ArrayList;
public class FuzzyGrady {
    private static ArrayList<Student> students= new ArrayList<Student>();
    public static void main(String[] args) {

        Nitrite db = Nitrite.builder()
                .compressed()
                .filePath("/tmp/test.db")
                .openOrCreate("fuzzyx","Level01@cess411");

            Signup s=new Signup(db);

    }
}
