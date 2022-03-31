package com.example.fuzzygrady;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Student {
    private String fName;
    private String lName;
    private String gender;
    private String matNum;
    private String dept;
    private String level;
    private String courseName;
    private double attendance=0.0;
    private double classParticipation=0.0;
    private double test=0.0;
    private double exam=0.0;
    private double fuzzyTotal=0.0;
    private double total=0.0;
    private String grade;
    private String fuzzyGrade;


    public void setGrade(){
        this.grade=this.presetGrade(this.total);
    }

    public void setFuzzyGrade(){
        this.fuzzyGrade=this.presetGrade(this.fuzzyTotal);
    }
    public void setFuzzyTotal(){
        this.fuzzyTotal=this.presetFuzzyTotal();
    }
    public void setTotal(){
        double att=(this.attendance/100)*5;
        double part=(this.classParticipation/100)*5;
        double tst=(this.test/100)*30;
        double exm=(this.exam/100)*60;
        this.total=att+part+tst+exm;
    }
    private String presetGrade(Double score){
        String res="";
        if (score <= 44) {
            res = "F";
        }else if(score>=45&&score<=49){
            res="E";
        }else if(score>=50&&score<=54){
            res="D";
        }else if(score>=55&&score<=59){
            res="C";
        }else if(score>=60&&score<=64){
            res="B";
        }else if(score>=65&&score<=70){
            res="B+";
        }else if(score>=71&&score<=80){
            res="A-";
        }else if(score>=81&&score<=90){
            res="A";
        }else if(score>=91&&score<=100){
            res="A+";
        }
        return res;

    }
    private double presetFuzzyTotal(){
        double att=(this.attendance/100)*5;
        double part=(this.classParticipation/100)*5;
        double tst=(this.test/100)*30;
        double exm=(this.exam/100)*60;

        final double  oldAtt=att;
        final double  oldPart=part;
        double res;
        res=att+part+tst+exm;
        List<Integer> list = new ArrayList<Integer>();

        if(( res<=44.0)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }

            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
                System.out.println(res);
//                if(res<50.0){
//                    res=50.0;
//                }
                if(res>48){


                    // add 5 element in ArrayList
                    list.add(45);
                    list.add(46);
                    list.add(47);
                    list.add(48);


                    res=this.getRandomElement(list);
                }
            }
            return res;
        }
        //if total is between 20-49 the system wants to help you
       else if((res>=45.0 && res<=49.0)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }

            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
                System.out.println(res);
//                if(res<50.0){
//                    res=50.0;
//                }
                if(res>52){


                    // add 5 element in ArrayList
                    list.add(50);
                    list.add(51);
                    list.add(52);



                    res=this.getRandomElement(list);
                }
            }
            return res;
        }

        else if((res>=50.0 && res<=54.0)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }

            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
                System.out.println(res);
//                if(res<50.0){
//                    res=50.0;
//                }
                if(res>57){


                    // add 5 element in ArrayList
                    list.add(55);
                    list.add(56);
                    list.add(57);



                    res=this.getRandomElement(list);
                }
            }
            return res;
        }
        else if((res>=55.0 && res<=59.0)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }

            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<60.0){
//                    res=60.0;
//                }
                if(res>62){

                    // add 5 element in ArrayList


                    list.add(60);
                    list.add(61);
                    list.add(62);

                    res=this.getRandomElement(list);
                }
            }
            return res;
        }

        else if((res>=60.0 && res<=64.0)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }

            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<60.0){
//                    res=60.0;
//                }
                if(res>67){

                    // add 5 element in ArrayList

                    list.add(65);
                    list.add(66);
                    list.add(67);


                    res=this.getRandomElement(list);
                }
            }
            return res;
        }
        else if((res>=65.0 && res<=70.0)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }

            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<70.0){
//                    res=70.0;
//                }
                if(res>75){

                    // add 5 element in ArrayList

                    list.add(71);
                    list.add(72);
                    list.add(73);
                    list.add(74);
                    list.add(75);

                    res=this.getRandomElement(list);
                }
            }
            return res;
        }





        else if((res>=71.0 && res<=80)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }


            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<75.0){
//                    res=75.0;
//                }
                if(res>85.0){
                    list.add(81);
                    list.add(82);
                    list.add(83);
                    list.add(84);
                    list.add(85);
                    res=this.getRandomElement(list);
                }
            }

            return res;
        }



        else if((res>=81.0 && res<=90)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }


            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<75.0){
//                    res=75.0;
//                }
                if(res>94.0){
                    list.add(91);
                    list.add(92);
                    list.add(93);
                    list.add(94);

                    res=this.getRandomElement(list);
                }
            }

            return res;
        }

        else if((res>=91.0 && res<=95)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }


            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<75.0){
//                    res=75.0;
//                }
                if(res>97.0){
                    list.add(96);
                    list.add(97);


                    res=this.getRandomElement(list);
                }
            }

            return res;
        }

        else if((res>=96.0 && res<=98)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }


            if(oldAtt!=att || oldPart!=part){
                res=att+part+tst+exm;
//                if(res<75.0){
//                    res=75.0;
//                }
                if(res>99.0){



                    res=99;
                }
            }

            return res;
        }
        else if((res>=99)){

            if(this.attendance>=80.0 && this.attendance<=100.0){
                att=att*2;
            }
            if(this.classParticipation>=80.0 && this.classParticipation<=100.0){
                part=part*2;
            }








                    res=100;



            return res;
        }
        return res;
    }

    private int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
//    public Student(){
//        super();
//    }

    public String getfName(){
        return this.fName;
    }

    public void setfName(String fName){
        this.fName=fName;
    }

    public String getlName(){
        return this.lName;
    }

    public void setlName(String lName){
        this.lName=lName;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender=gender;
    }


    public String getMatNum(){
        return this.matNum;
    }

    public void setMatNum(String matNum){
        this.matNum=matNum;
    }

    public String getDept(){
        return this.dept;
    }

    public void setDept(String dept){
        this.dept=dept;
    }
    public String getLevel(){
        return this.level;
    }

    public void setLevel(String level){
        this.level=level;
    }


    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseName(String courseName){
        this.courseName=courseName;
    }

    public double getAttendance(){
        return this.attendance;
    }

    public void setAttendance(double attendance){
        this.attendance=attendance;

    }


    public double getClassParticipation(){
        return this.classParticipation;
    }

    public void setClassParticipation(double classParticipation){
        this.classParticipation=classParticipation;

    }


    public double getTest(){
        return this.test;
    }

    public void setTest(double test){
        this.test=test;

    }

    public double getExam(){
        return this.exam;
    }

    public void setExam(double exam){
        this.exam=exam;

    }


    public double getFuzzyTotal(){
        return this.fuzzyTotal;
    }
    public double getTotal(){ return this.total; }

    public String getGrade() {
        return this.grade;
    }
    public String getFuzzyGrade(){
        return this.fuzzyGrade;
    }
}
