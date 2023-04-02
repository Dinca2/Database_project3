
/*****************************************************************************************
 * @file  MovieDB.java
 *
 * @author   John Miller
 */

import static java.lang.System.out;

/*****************************************************************************************
 * The MovieDB class makes a Movie Database.  It serves as a template for making other
 * databases.  See "Database Systems: The Complete Book", second edition, page 26 for more
 * information on the Movie Database schema.
 */
class TestTable
{
    /*************************************************************************************
     * Main method for creating, populating and querying a Movie Database.
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
                
       
        var tups = new int [] { 20000, 1000, 2000, 10000, 10000 };
        var resultTest = test.generate (tups);
        
        Table student = new Table ("Student20k", "id name address status", "Integer String String String", "id");
        Table professor = new Table ("Professor20k", "id name deptId", "Integer String String", "id");
        Table course = new Table ("Course20k", "crsCode deptId crsName descr", "String String String String", "crsCode");
        Table teaching = new Table ("Teaching20k", "crsCode semester profId", "String String Integer", "crcCode semester");
        Table transcript = new Table ("Transcript20k", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");

        var tables = new Table [] {student, professor, course, teaching, transcript};
        for (var i = 0; i < tables.length; i++) {
            for (var j = 0; j < resultTest[i].length; j++) {
                tables[i].insert(resultTest [i][j]);
            }
            tables[i].save();
        }


       
       
    } // main

} // testtable class

