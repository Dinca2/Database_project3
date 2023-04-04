import java.awt.*;  
import javax.swing.*;  
import java.awt.geom.*;
import java.util.*;
class EvalPerf {
    
    public static KeyType getLast(Map<KeyType, Comparable []> map)
    {
        int count = 2;
        KeyType it = map.entrySet().iterator().next().getKey();
        for (Map.Entry<KeyType, Comparable[]> it2 : map.entrySet()) {
            if (count == map.size()) {
                System.out.println(it2.getValue());
                return it2.getKey();
            }
            count++;
        }
        return it;
    }


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
        //Table studentTEST = Table.load("StudentTEST");
        //Table transcriptTEST = Table.load("TranscriptTEST");

        Table student1 = Table.load("Student5k");
        Table transcript1 = Table.load("Transcript5k");

        Table student2 = Table.load("Student10k");
        Table transcript2 = Table.load("Transcript10k");
        
        Table student3 = Table.load("Student15k");
        Table transcript3 = Table.load("Transcript15k");
        
        Table student4 = Table.load("Student20k");
        Table transcript4 = Table.load("Transcript20k");
        
        //student1.print();
        //transcript1.print();
        //studentTEST.print();
        //transcriptTEST.print();
        //Table test1 = student1.nonIndexJoin("id", "studId", transcript1);
        //test1.print();
        //Table test = professorTEST.select(t -> t[professorTEST.col("id")].equals(5000));
        //test.print();
        long [] speeds1 = new long[5];
        long [] speeds2 = new long[5];
        long [] speeds3 = new long[5];
        long [] speeds4 = new long[5];
        long speed1 = 0;
        long speed2 = 0;
        long speed3 = 0;
        long speed4 = 0;
        
        /* 
        for(int i = 0; i < 5; i++) {
            speed1 = 0;
            speed2 = 0;
            speed3 = 0;
            speed4 = 0;
            long startTime = System.currentTimeMillis();
            student1.nonIndexJoin("id", "studId", transcript1); //5k
            long endTime = System.currentTimeMillis();
            speed1 += (endTime - startTime);
            speeds1[i] = speed1;
            
            startTime = System.currentTimeMillis();
            student2.nonIndexJoin("id", "studId", transcript2); //10k
            endTime = System.currentTimeMillis();
            speed2 += (endTime - startTime);
            speeds2[i] = speed2;

            startTime = System.currentTimeMillis();
            student3.nonIndexJoin("id", "studId", transcript3); //15k
            endTime = System.currentTimeMillis();
            speed3 += (endTime - startTime);
            speeds3[i] = speed3;

            startTime = System.currentTimeMillis();
            student4.nonIndexJoin("id", "studId", transcript4); //20k
            endTime = System.currentTimeMillis();
            speed4 += (endTime - startTime);
            speeds4[i] = speed4;
        }
        System.out.println("==no index==");
        System.out.println("========5k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds1[i]);
        }
        System.out.println();
        
        System.out.println("========10k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds2[i]);
        }
        System.out.println();
        
        System.out.println("========15k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds3[i]);
        }
        System.out.println();
        
        System.out.println("========20k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds4[i]);
        }
*/
        for(int i = 0; i < 5; i++) {
            speed1 = 0;
            speed2 = 0;
            speed3 = 0;
            speed4 = 0;
            long startTime = System.currentTimeMillis();
            student1.indexJoin("id", "studId", transcript1); //5k
            long endTime = System.currentTimeMillis();
            speed1 += (endTime - startTime);
            speeds1[i] = speed1;
            
            startTime = System.currentTimeMillis();
            student2.indexJoin("id", "studId", transcript2); //10k
            endTime = System.currentTimeMillis();
            speed2 += (endTime - startTime);
            speeds2[i] = speed2;

            startTime = System.currentTimeMillis();
            student3.indexJoin("id", "studId", transcript3); //15k
            endTime = System.currentTimeMillis();
            speed3 += (endTime - startTime);
            speeds3[i] = speed3;

            startTime = System.currentTimeMillis();
            student4.indexJoin("id", "studId", transcript4); //20k
            endTime = System.currentTimeMillis();
            speed4 += (endTime - startTime);
            speeds4[i] = speed4;
        }   
        
        System.out.println("========5k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds1[i]);
        }
        System.out.println();
        
        System.out.println("========10k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds2[i]);
        }
        System.out.println();
        
        System.out.println("========15k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds3[i]);
        }
        System.out.println();
        
        System.out.println("========20k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds4[i]);
        }
        
        KeyType num1 = getLast(student1.index);
        KeyType num2 = getLast(student2.index);
        KeyType num3 = getLast(student3.index);
        KeyType num4 = getLast(student4.index);
        speed1 = 0;
        speed2 = 0;
        speed3 = 0;
        speed4 = 0;
        for(int i = 0; i < 5; i++) {
            speed1 = 0;
            speed2 = 0;
            speed3 = 0;
            speed4 = 0;
            long startTime = System.currentTimeMillis();
            student1.select(num1); //5k
            long endTime = System.currentTimeMillis();
            speed1 += (endTime - startTime);
            speeds1[i] = speed1;
            
            startTime = System.currentTimeMillis();
            student2.select(num2); //10k
            endTime = System.currentTimeMillis();
            speed2 += (endTime - startTime);
            speeds2[i] = speed2;

            startTime = System.currentTimeMillis();
            student3.select(num3); //15k
            endTime = System.currentTimeMillis();
            speed3 += (endTime - startTime);
            speeds3[i] = speed3;

            startTime = System.currentTimeMillis();
            student4.select(num4); //20k
            endTime = System.currentTimeMillis();
            speed4 += (endTime - startTime);
            speeds4[i] = speed4;
        }   
        
        System.out.println("========5k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds1[i]);
        }
        System.out.println();
        
        System.out.println("========10k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds2[i]);
        }
        System.out.println();
        
        System.out.println("========15k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds3[i]);
        }
        System.out.println();
        
        System.out.println("========20k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds4[i]);
        }
        /* 
        for(int i = 0; i < 5; i++) {
            speed1 = 0;
            speed2 = 0;
            speed3 = 0;
            speed4 = 0;
            long startTime = System.currentTimeMillis();
            student1.select(t -> t[student1.col("status")].equals("status10000")); //5k
            long endTime = System.currentTimeMillis();
            speed1 += (endTime - startTime);
            speeds1[i] = speed1;
            
            startTime = System.currentTimeMillis();
            student2.select(t -> t[student2.col("status")].equals("status10000")); //10k
            endTime = System.currentTimeMillis();
            speed2 += (endTime - startTime);
            speeds2[i] = speed2;

            startTime = System.currentTimeMillis();
            student3.select(t -> t[student3.col("status")].equals("status10000")); //15k
            endTime = System.currentTimeMillis();
            speed3 += (endTime - startTime);
            speeds3[i] = speed3;

            startTime = System.currentTimeMillis();
            student4.select(t -> t[student4.col("status")].equals("status10000")); //20k
            endTime = System.currentTimeMillis();
            speed4 += (endTime - startTime);
            speeds4[i] = speed4;
        }   
        System.out.println("==no index==");
        System.out.println("========5k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds1[i]);
        }
        System.out.println();
        
        System.out.println("========10k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds2[i]);
        }
        System.out.println();
        
        System.out.println("========15k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds3[i]);
        }
        System.out.println();
        
        System.out.println("========20k speeds=======");
        for(int i = 0; i < 5; i++) {
            System.out.println(speeds4[i]);
        }
        */
        /* 
        JFrame frame = new JFrame();  
        // set size, layout and location for frame.  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.add(new Plot(speeds));  
        frame.setSize(600, 600);  
        frame.setLocation(200, 200);  
        frame.setVisible(true);  
        */
    } //main

} //evalperf
