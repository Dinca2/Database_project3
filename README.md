# CSCI_4370 Project1
 
 names: Ethan Pham, Kevin Yang, Max Maher

 we have a performance evaluation in an excel file
 the average runtime for both join and select are as follows:
 no-index > treeMap > linHashMap > hashMap
 with Hash Map having the least run time. 

 Run EvalPerf.java for data
 If you want to change indexing method (no-index, tree, lin, hash)
 You must first change the index class variable in the Table constructor in Table.java
 Then regenerate the tables by running TestTable.java
 Only then can you rerun EvalPerf.java

 credit:
 Max: excel, TestTable.java
 Ethan: LinHashMap.java
 Kevin: index equi-join
