
public class TestTable
{
    /*************************************************************************************
     * @param args the command-line arguments
     */
    public static void main (String [] args)
    {
        
        var test = new TupleGeneratorImpl ();

        test.addRelSchema ("Student",
                            "id name address status",
                            "Integer String String String",
                            "id",
                          null);
                
        test.addRelSchema ("Professor",
                            "id name deptId",
                            "Integer String String",
                            "id",
                            null);
                
        test.addRelSchema ("Course",
                            "crsCode deptId crsName descr",
                            "String String String String",
                            "crsCode",
                            null);
                
        test.addRelSchema ("Teaching",
                            "crsCode semester profId",
                            "String String Integer",
                            "crcCode semester",
                            new String [][] {{ "profId", "Professor", "id" },
                                                { "crsCode", "Course", "crsCode" }});
                
        test.addRelSchema ("Transcript",
                            "studId crsCode semester grade",
                            "Integer String String String",
                            "studId crsCode semester",
                            new String [][] {{ "studId", "Student", "id"},
                                                { "crsCode", "Course", "crsCode" },
                                                { "crsCode semester", "Teaching", "crsCode semester" }});                                                
        
        /*
        var TESTtups = new int [] { 100, 100, 100, 100, 100 };
        var TESTresultTest = test1.generate (TESTtups);
        
        Table TESTstudent = new Table ("StudentTEST", "id name address status", "Integer String String String", "id");
        Table TESTprofessor = new Table ("ProfessorTEST", "id name deptId", "Integer String String", "id");
        Table TESTcourse = new Table ("CourseTEST", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table TESTteaching = new Table ("TeachingTEST", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table TESTtranscript = new Table ("TranscriptTEST", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");
        */
        
        var tups = new int [] { 5000, 100, 100, 100, 5000 };
        var resultTest = test.generate (tups);
        
        Table student = new Table ("Student5k", "id name address status", "Integer String String String", "id");
        Table professor = new Table ("Professor5k", "id name deptId", "Integer String String", "id");
        Table course = new Table ("Course5k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching = new Table ("Teaching5k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript = new Table ("Transcript5k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester"); // crsCode semester
        
        /*
        var tups2 = new int [] { 10000,  100, 100, 100, 10000};
        var resultTest2 = test.generate (tups2);
        
        Table student2 = new Table ("Student10k", "id name address status", "Integer String String String", "id");
        Table professor2 = new Table ("Professor10k", "id name deptId", "Integer String String", "id");
        Table course2 = new Table ("Course10k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching2 = new Table ("Teaching10k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript2 = new Table ("Transcript10k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");
        */
        /*
        var tups3 = new int [] { 15000,  100, 100, 100, 15000 };
        var resultTest3 = test.generate (tups3);
        
        Table student3 = new Table ("Student15k", "id name address status", "Integer String String String", "id");
        Table professor3 = new Table ("Professor15k", "id name deptId", "Integer String String", "id");
        Table course3 = new Table ("Course15k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching3 = new Table ("Teaching15k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript3 = new Table ("Transcript15k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");

        */
        /* 
        var tups4 = new int [] { 20000,  100, 100, 100, 20000 };
        var resultTest4 = test.generate (tups4);
        
        Table student4 = new Table ("Student20k", "id name address status", "Integer String String String", "id");
        Table professor4 = new Table ("Professor20k", "id name deptId", "Integer String String", "id");
        Table course4 = new Table ("Course20k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching4 = new Table ("Teaching20k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript4 = new Table ("Transcript20k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");
        */
        var tables = new Table [] {student, professor, course, teaching, transcript};
        //var tables2 = new Table [] {student2, professor2, course2, teaching2, transcript2};
        //var tables3 = new Table [] {student3, professor3, course3, teaching3, transcript3};
        //var tables4 = new Table [] {student4, professor4, course4, teaching4, transcript4};
        

        /*var TESTtables = new Table [] {TESTstudent, TESTprofessor, TESTcourse, TESTteaching, TESTtranscript};
        for (var i = 0; i < TESTtables.length; i++) {
            for (var j = 0; j < TESTresultTest[i].length; j++) {
                TESTtables[i].insert(TESTresultTest[i][j]);
            }
            TESTtables[i].save();
        }
        */
        
        for (var i = 0; i < tables.length; i++) {
            for (var j = 0; j < resultTest[i].length; j++) {
                tables[i].insert(resultTest[i][j]);
            }
            tables[i].save();
        }

         /*
        for (var i = 0; i < tables2.length; i++) {
            for (var j = 0; j < resultTest2[i].length; j++) {
                tables2[i].insert(resultTest2[i][j]);
            }
            tables2[i].save();
        }
        */
        
        /*
        for (var i = 0; i < tables3.length; i++) {
            for (var j = 0; j < resultTest3[i].length; j++) {
                tables3[i].insert(resultTest3[i][j]);
            }
            tables3[i].save();
        }
        */
        /*
        for (var i = 0; i < tables4.length; i++) {
            for (var j = 0; j < resultTest4[i].length; j++) {
                tables4[i].insert(resultTest4[i][j]);
            }
            tables4[i].save();
        }
        */

    } // main

} // testtable class

