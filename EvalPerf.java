import java.awt.*;  
import javax.swing.*;  
import java.awt.geom.*;

class EvalPerf {
   
    public static class Plot extends JPanel{  

        //initialize coordinates  
        long[] cord = {65, 20, 40, 80};  
        int marg = 60;  
        
        public Plot(long[] cord) {
            this.cord = cord;
        }
          
        protected void paintComponent(Graphics grf){  
            //create instance of the Graphics to use its methods  
            super.paintComponent(grf);  
            Graphics2D graph = (Graphics2D)grf;  
              
            //Sets the value of a single preference for the rendering algorithms.  
            graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
              
            // get width and height  
            int width = getWidth();  
            int height = getHeight();  
              
            // draw graph  
            graph.draw(new Line2D.Double(marg, marg, marg, height-marg));  
            graph.draw(new Line2D.Double(marg, height-marg, width-marg, height-marg));  
              
            //find value of x and scale to plot points  
            double x = (double)(width-2*marg)/(cord.length-1);  
            double scale = (double)(height-2*marg)/getMax();  
              
            //set color for points  
            graph.setPaint(Color.RED);  
              
            // set points to the graph  
            for(int i=0; i<cord.length; i++){  
                double x1 = marg+i*x;  
                double y1 = height-marg-scale*cord[i];  
                graph.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));  
            }  
        }  
          
        //create getMax() method to find maximum value  
        private long getMax(){  
            long max = -Integer.MAX_VALUE;  
            for(int i=0; i<cord.length; i++){  
                if(cord[i]>max)  
                    max = cord[i];  
                 
            }  
            return max;  
        } //getMax
    } //Plot
    public static void main (String [] args)
    {
        Table studentTEST = Table.load("StudentTEST");
        Table professorTEST = Table.load("ProfessorTEST");
        Table courseTEST = Table.load("CourseTEST");
        Table teachingTEST = Table.load("TeachingTEST");
        Table transcriptTEST = Table.load("TranscriptTEST");

        Table student1 = Table.load("Student5k");
        Table professor1 = Table.load("Professor5k");
        Table course1 = Table.load("Course5k");
        Table teaching1 = Table.load("Teaching5k");
        Table transcript1 = Table.load("Transcript5k");

        Table student2 = Table.load("Student10k");
        //Table professor2 = Table.load("Professor10k");
        //Table course2 = Table.load("Course10k");
        //Table teaching2 = Table.load("Teaching10k");
        Table transcript2 = Table.load("Transcript10k");
        
        Table student3 = Table.load("Student15k");
        //Table professor3 = Table.load("Professor15k");
        //Table course3 = Table.load("Course15k");
        //Table teaching3 = Table.load("Teaching15k");
        Table transcript3 = Table.load("Transcript15k");
        
        Table student4 = Table.load("Student20k");
        //Table professor4 = Table.load("Professor20k");
        //Table course4 = Table.load("Course20k");
        //Table teaching4 = Table.load("Teaching20k");
        Table transcript4 = Table.load("Transcript20k");
        
        //student1.print();
        //transcript1.print();
        studentTEST.print();
        transcriptTEST.print();
        Table test1 = studentTEST.join("studId", "id", transcriptTEST);
        test1.print();
        Table test = professorTEST.select(t -> t[professor1.col("id")].equals(teachingTEST.col("profId")));
        test.print();
        long [] speeds = new long[4];
        long speed1 = 0;
        long speed2 = 0;
        long speed3 = 0;
        long speed4 = 0;
        /*for(int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            student1.join("id", "studId", transcript1);
            long endTime = System.currentTimeMillis();
            speed1 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            student2.join("id", "studId", transcript2);
            endTime = System.currentTimeMillis();
            speed2 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            student3.join("id", "studId", transcript3);
            endTime = System.currentTimeMillis();
            speed3 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            student4.join("id", "studId", transcript4);
            endTime = System.currentTimeMillis();
            speed4 += (endTime - startTime);
        }*/
        for(int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            student1.join("id", "studId", transcript1);
            long endTime = System.currentTimeMillis();
            speed1 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            student2.join("id", "studId", transcript2);
            endTime = System.currentTimeMillis();
            speed2 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            student3.join("id", "studId", transcript3);
            endTime = System.currentTimeMillis();
            speed3 += (endTime - startTime);

            startTime = System.currentTimeMillis();
            student4.join("id", "studId", transcript4);
            endTime = System.currentTimeMillis();
            speed4 += (endTime - startTime);
        }
        speeds[0] = speed1/5;
        speeds[1] = speed2/5;
        speeds[2] = speed3/5;
        speeds[3] = speed4/5;
        for(int i = 0; i < 3; i++) {
            System.out.println(speeds[i]);
        }
        
        JFrame frame = new JFrame();  
        // set size, layout and location for frame.  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.add(new Plot(speeds));  
        frame.setSize(600, 600);  
        frame.setLocation(200, 200);  
        frame.setVisible(true);  
    } //main

} //evalperf
