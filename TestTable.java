
class TestTable
{
    /*************************************************************************************
     * @param args  the command-line arguments
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
                
        var tups = new int [] { 5000, 250, 500, 2500, 2500 };
        var resultTest = test.generate (tups);
        
        Table student = new Table ("Student5khash", "id name address status", "Integer String String String", "id");
        Table professor = new Table ("Professor5khash", "id name deptId", "Integer String String", "id");
        Table course = new Table ("Course5khash", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching = new Table ("Teaching5khash", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript = new Table ("Transcript5khash", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");

        /*var tups = new int [] { 10000, 500, 1000, 5000, 5000 };
        var resultTest = test.generate (tups);
        
        Table student = new Table ("Student10k", "id name address status", "Integer String String String", "id");
        Table professor = new Table ("Professor10k", "id name deptId", "Integer String String", "id");
        Table course = new Table ("Course10k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching = new Table ("Teaching10k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript = new Table ("Transcript10k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");

        var tups = new int [] { 15000, 750, 1500, 7500, 7500 };
        var resultTest = test.generate (tups);
        
        Table student = new Table ("Student15k", "id name address status", "Integer String String String", "id");
        Table professor = new Table ("Professor15k", "id name deptId", "Integer String String", "id");
        Table course = new Table ("Course15k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching = new Table ("Teaching15k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript = new Table ("Transcript15k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");

        var tups = new int [] { 20000, 1000, 2000, 10000, 10000 };
        var resultTest = test.generate (tups);
        
        Table student = new Table ("Student20k", "id name address status", "Integer String String String", "id");
        Table professor = new Table ("Professor20k", "id name deptId", "Integer String String", "id");
        Table course = new Table ("Course20k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching = new Table ("Teaching20k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript = new Table ("Transcript20k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");
        */
        var tables = new Table [] {student, professor, course, teaching, transcript};
        
        for (var i = 0; i < tables.length; i++) {
            for (var j = 0; j < resultTest[i].length; j++) {
                tables[i].insert(resultTest [i][j]);
            }
            tables[i].save();
        }


       
       
    } // main

} // testtable class

