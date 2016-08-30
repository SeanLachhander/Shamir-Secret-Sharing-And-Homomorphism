/* 
 *  Files: Share.java
 *  Courtesy: Robert Bisewski
 */
 
 //the necessary imports
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.Vector;
import java.math.BigInteger; //added
import java.util.Random;
import java.util.Arrays; // added

//this is where the class starts
public class ShareHomo extends JFrame implements ActionListener {

    //this string defines the text of the About Program button
    String aboutTxt = "Courtesy: Robert Bisewski, Former ACS Student of University of Winnipeg";
                         
    //this string defines the text of Display Instructions button
    String instructTxt = "Instructions:\n" +
                      "------------------\n\n" +
      
                         "Load/Enter Text: This opens a text\n" +
                         "file that the user selects and dumps\n" +
                         "its contents to the original text box.\n\n" +
                         
                         "Create Shares: This takes the contents\n" +
                         "of the original text box, creates five\n" +
                         "shares, and places them into their boxes.\n\n" +
                          
                         "Reconstruct Original: This takes the\n" +
                         "shares placed in the share boxes and\n" +
                         "uses them to recreate the original text.\n" +
                         "Click the checkboxes to decide which\n" +
                         "shares you wish to use.";

    //the filter that describes what files can be opened
    FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text File", "txt", "TXT");

    //the text-areas and the scrollbars used in this program
    private JTextArea originaltxt = new JTextArea("Original Numbers");
    private JScrollPane scrBar    = new JScrollPane(originaltxt);
    private JTextArea retxt       = new JTextArea("");
    private JScrollPane RscrBar   = new JScrollPane(retxt);
    private JTextArea share1      = new JTextArea("");
    private JScrollPane scrBar1   = new JScrollPane(share1);
    private JTextArea share2      = new JTextArea("");
    private JScrollPane scrBar2   = new JScrollPane(share2);
    private JTextArea share3      = new JTextArea("");
    private JScrollPane scrBar3   = new JScrollPane(share3);
    private JTextArea share4      = new JTextArea("");
    private JScrollPane scrBar4   = new JScrollPane(share4);
    private JTextArea share5      = new JTextArea("");
    private JScrollPane scrBar5   = new JScrollPane(share5);    

    //this specifies the checkboxes used with this program
    final JCheckBox chk1 = new JCheckBox("", false);
    final JCheckBox chk2 = new JCheckBox("", false);
    final JCheckBox chk3 = new JCheckBox("", false);
    final JCheckBox chk4 = new JCheckBox("", false);
    final JCheckBox chk5 = new JCheckBox("", false);

    //this buttons used in this program
    final JButton bttLoad    = new JButton("Load Numbers from File");
    final JButton bttCreate  = new JButton("Create Shares");
    final JButton bttRecon   = new JButton("Reconstruct Average");
    final JButton bttAveg    = new JButton("Compute Average");
    final JButton bttDisplay = new JButton("Display Instructions");
    final JButton bttAbout   = new JButton("About Program");
    final JButton bttQuit    = new JButton("Quit Program");
  
  //the default constructor for this program
  public ShareHomo() {
  
    //defines the details of the scrollbars
    originaltxt.setLineWrap(true);
    originaltxt.setWrapStyleWord(true);
    scrBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    scrBar1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share1.setLineWrap(true);
    share1.setWrapStyleWord(true);
    
    scrBar2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share2.setLineWrap(true);
    share2.setWrapStyleWord(true);
    
    scrBar3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share3.setLineWrap(true);
    share3.setWrapStyleWord(true);
    
    scrBar4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share4.setLineWrap(true);
    share4.setWrapStyleWord(true);
    
    scrBar5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share5.setLineWrap(true);
    share5.setWrapStyleWord(true);
    
    RscrBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    retxt.setLineWrap(true);
    retxt.setWrapStyleWord(true);
    
    //defines the size of several objects
    scrBar.setPreferredSize(new Dimension(170,160));
    scrBar1.setPreferredSize(new Dimension(170,160));
    chk1.setPreferredSize(new Dimension(175,15));
    scrBar2.setPreferredSize(new Dimension(170,160));
    chk2.setPreferredSize(new Dimension(175,15));
    scrBar3.setPreferredSize(new Dimension(170,160));
    chk3.setPreferredSize(new Dimension(175,15));
    scrBar4.setPreferredSize(new Dimension(170,160));
    chk4.setPreferredSize(new Dimension(175,15));
    scrBar5.setPreferredSize(new Dimension(170,160));
    chk5.setPreferredSize(new Dimension(175,15));
    RscrBar.setPreferredSize(new Dimension(170,160));
    bttLoad.setPreferredSize(new Dimension(170,25));
    bttCreate.setPreferredSize(new Dimension(170,25));
    bttRecon.setPreferredSize(new Dimension(170,25));
    bttAveg.setPreferredSize(new Dimension(170,25));
    bttDisplay.setPreferredSize(new Dimension(170,25));       
    bttAbout.setPreferredSize(new Dimension(170,25));
    bttQuit.setPreferredSize(new Dimension(170,25));
  
    //defines the panels used in this program
    JPanel menu = new JPanel(); menu.setBorder(BorderFactory.createTitledBorder("Menu Options:"));
    menu.setPreferredSize(new Dimension(200,220));   
    JPanel originalPan = new JPanel(); originalPan.setBorder(BorderFactory.createTitledBorder("Secret Numbers:"));
    originalPan.setPreferredSize(new Dimension(200,220));
    JPanel share1Pan = new JPanel(); 
    share1Pan.setBorder(BorderFactory.createTitledBorder("Share 1:"));
    share1Pan.setPreferredSize(new Dimension(200,220));
    JPanel share2Pan = new JPanel();
    share2Pan.setBorder(BorderFactory.createTitledBorder("Share 2:"));
    share2Pan.setPreferredSize(new Dimension(200,220));
    JPanel share3Pan = new JPanel();
    share3Pan.setBorder(BorderFactory.createTitledBorder("Share 3:"));
    share3Pan.setPreferredSize(new Dimension(200,220));
    JPanel share4Pan = new JPanel();
    share4Pan.setBorder(BorderFactory.createTitledBorder("Share 4:"));
    share4Pan.setPreferredSize(new Dimension(200,220));
    JPanel share5Pan = new JPanel();
    share5Pan.setBorder(BorderFactory.createTitledBorder("Share 5:"));
    share5Pan.setPreferredSize(new Dimension(200,220));
    JPanel rePan = new JPanel();
    rePan.setBorder(BorderFactory.createTitledBorder("Reconstructed Average:"));
    rePan.setPreferredSize(new Dimension(200,220));
    
    //defines the layouts of the Content Pane
    getContentPane().setLayout(new FlowLayout());
    
   //adds the panels to the Content Pane
   menu.add(bttLoad);
   menu.add(bttCreate);
   menu.add(bttRecon);
   menu.add(bttAveg);
   menu.add(bttDisplay);
   menu.add(bttAbout);
   menu.add(bttQuit);
   originalPan.add(scrBar);
   rePan.add(RscrBar);
   share1Pan.add(scrBar1);
   share1Pan.add(chk1);
   share2Pan.add(scrBar2);
   share2Pan.add(chk2);
   share3Pan.add(scrBar3);
   share3Pan.add(chk3);
   share4Pan.add(scrBar4);
   share4Pan.add(chk4);
   share5Pan.add(scrBar5);
   share5Pan.add(chk5);
   getContentPane().add(originalPan);
   getContentPane().add(share1Pan);
   getContentPane().add(share2Pan);
   getContentPane().add(share3Pan);
   getContentPane().add(rePan);
   getContentPane().add(share4Pan);
   getContentPane().add(share5Pan);
   getContentPane().add(menu);
   
   //adds ActionListeners to this program's components
   bttLoad.addActionListener(this);
   bttCreate.addActionListener(this);
   bttRecon.addActionListener(this);
   bttAveg.addActionListener(this);
   bttDisplay.addActionListener(this);
   bttAbout.addActionListener(this);
   bttQuit.addActionListener(this);
   
   //this sets essential values of the GUI
   setTitle("ICSI-526/426 Ass#4: SSS & Homomorphism");
   setSize(840,540);
   setResizable(false);
   addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
  }

  ////////////////////////////////////////////////////////
  //Basic Program Functions for Input/Output Starts Here// 
  ////////////////////////////////////////////////////////
  
  //this opens a file via the JFileChooser, returns file name & location
  public String SelectFile() {
  
    //variable declaration
    String path = null;
  
    //this creates a JFileChooser gui in order to select a file
    JFileChooser jfc = new JFileChooser();
    jfc.setFileFilter(fnef);
    int buttonClicked = jfc.showOpenDialog(new JLabel("Open File"));
    
    //this checks which button was pressed on the JFileChooser GUI
    if (buttonClicked == JFileChooser.APPROVE_OPTION) {
      path = "" + jfc.getCurrentDirectory() + "\\"
               + (jfc.getSelectedFile().getName()).toLowerCase();
    }
    return path;
  }

  //this reads the contents of the text area to a text file
  public void txtRead(String file) {
   
   //this buffers, then reads the file
    StringBuffer s = new StringBuffer();
    try {
      BufferedReader input = new BufferedReader(new FileReader(file));
      try {
        String line = "";
        while ((line = input.readLine()) != null) {s.append(line + "\n");}
      }
      finally {input.close();}
     }
     catch (Exception x){JOptionPane.showMessageDialog(null, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);}
    
   //this display the text
   originaltxt.setText(s.toString());
  }

  //this divides the original text into 5 separate shares
  public void txtShare() 
  {
    
    //Sean Lachhander -- Cryptography -- CSI 426 -- Assignment #4 -- Shamir Secret Sharing 
    
    String[] tmp = originaltxt.getText().split("\n"); // takes in shares and stores in string array
    int[] result = new int[tmp.length]; // result is length of string array
    for(int x = 0; x < tmp.length; x++){  // loops through and stores values in result array.
      result[x] = Integer.parseInt(tmp[x].trim());
    }
    
   Random random = new Random();  // random number generator
   int x = random.nextInt(6) + 5;
    
    int prime = 257;  // FIXED PRIME NUMBER. (mod) Given by professor.
    
    int k = 3;  // given on the assignment
    int n = 5; // given on the assignment
    int a1 = 6;  // set value 
    int a2 = 3;  // set value
    
    int[] secrets = new int[tmp.length];   // equation with f(1) as x.
    int i=1;  // set value for later use
    
    for(x = 0; x < tmp.length; x++){
      secrets[x] = result[x] + a1*i + a2 * (int)Math.pow(i,2);  // storing in secrets array using SSS formula given in class.

    }
    
    int[] secretsTwo = new int[tmp.length];  // same as above
    int two=2;
    for(x = 0; x < tmp.length; x++){
      secretsTwo[x] = result[x] + a1*two + a2 * (int)Math.pow(two,2);  // equation with f(2) as x

    }
    
    int[] secretsThree = new int[tmp.length];  // same as above
    int three = 3;
    for(x = 0; x < tmp.length; x++){
      secretsThree[x] = result[x] + a1*three + a2 * (int)Math.pow(three,2);  // equation with f(3) as x

    }
    
    int[] secretsFour = new int[tmp.length];  // same as above
    int four = 4;
    for(x = 0; x < tmp.length; x++){
      secretsFour[x] = result[x] + a1*four + a2 * (int)Math.pow(four,2); // equation with f(4) as x

    }
    
    int[] secretsFive = new int[tmp.length];  // same as above
    int five = 5;
    for(x = 0; x < tmp.length; x++){
      secretsFive[x] = result[x] + a1*four + a2 * (int)Math.pow(five,2);  // equation with f(5) as x

    }
    
    
    // following will print in the jtextareas.
    for(x = 0; x < tmp.length; x++){
     share1.append(String.valueOf(secrets[x]));  // display shares into share1 jtextarea
     share1.append("\n");
     
     
     share2.append(String.valueOf(secretsTwo[x])); // display shares into share2 jtextarea
     share2.append("\n");
     share3.append(String.valueOf(secretsThree[x])); // display shares into share3 jtextarea
     share3.append("\n");
     share4.append(String.valueOf(secretsFour[x]));  // display shares into share4 jtextarea
     share4.append("\n");
     share5.append(String.valueOf(secretsFive[x]));   // display shares into share5 jtextarea
     share5.append("\n");
    }
  }
  
  //this compute the average of shares and dumps the result to the shares area
  public void txtAveg() 
  {
    int sum = 0;
    int sumTwo = 0;
    int sumThree = 0;
    int sumFour = 0;
    int sumFive = 0;
    
    if(chk1.isSelected()){
      String[] solid = share1.getText().split("\n"); // comes in as a string array
      int[] array = new int[solid.length];  // int array length of the string array
      
      for(int x = 0; x < solid.length; x++){  // for loop will loop through and add into int sum.
        array[x] = Integer.parseInt(solid[x]);
        sum += array[x];  // will hold the sum of the array
      }
      
      BigInteger prime = new BigInteger("257"); // prime number set.. given in class
      long x = solid.length;
      BigInteger big1 = BigInteger.valueOf(x*sum); // holds solid.length * the sum..
      BigInteger big3 = null;
      
      big3 = big1.modInverse(prime); // basically is: bi1^-1 mod prime (value) holds after mod inverse operation
      share1.append(big3 + "\n");  // value is displayed in share1

    }

    if(chk2.isSelected()){
      String[] solidTwo = share2.getText().split("\n"); // comes in as a string array
      int[] arrayTwo = new int[solidTwo.length];  // int array length of the string array
      
      for(int x = 0; x < solidTwo.length; x++){  // for loop will loop through and add into int sum.
        arrayTwo[x] = Integer.parseInt(solidTwo[x]);
        sumTwo += arrayTwo[x]; // sum
      }
      
      BigInteger prime = new BigInteger("257");
      long y = solidTwo.length;
      BigInteger bi1 = BigInteger.valueOf(y*sumTwo);   // based on formula given in class.
      BigInteger bi3 = null;
      
      bi3 = bi1.modInverse(prime); // basically is: bi1^-1 mod bi2 (value) holds after mod inverse operation
      share2.append(bi3 + "\n");  // stores it in the share2 jtextarea
      
    }
    
    if(chk3.isSelected()){
     String[] solidThree = share3.getText().split("\n"); // comes in as a string array
      int[] arrayThree = new int[solidThree.length];  // int array length of the string array
      
      for(int x = 0; x < solidThree.length; x++){  // for loop will loop through and add into int sum.
        arrayThree[x] = Integer.parseInt(solidThree[x]);
        sumThree += arrayThree[x]; // sum
      }
      
      BigInteger prime = new BigInteger("257");  // prime # given by professor
      long z = solidThree.length;
      BigInteger b1 = BigInteger.valueOf(z*sumThree);
      BigInteger b3 = null;
      
      b3 = b1.modInverse(prime);
      share3.append(b3 + "\n");  // displays avg in share3
    }
    
    if(chk4.isSelected()){
      String[] solidFour = share4.getText().split("\n"); // comes in as a string array
      int[] arrayFour = new int[solidFour.length];  // int array length of the string array
      
      for(int x = 0; x < solidFour.length; x++){  // for loop will loop through and add into int sum.
        arrayFour[x] = Integer.parseInt(solidFour[x]);
        sumFour += arrayFour[x]; // sum
      }
      
      BigInteger prime = new BigInteger("257");
      long aa = solidFour.length;
      BigInteger t1 = BigInteger.valueOf(aa*sumFour);
      BigInteger t3 = null;
      
      t3 = t1.modInverse(prime);
      share4.append(t3 + "\n");  // displays the avg in share4
    }
    if(chk5.isSelected()){
      String[] solidFive = share5.getText().split("\n"); // comes in as a string array
      int[] arrayFive = new int[solidFive.length];  // int array length of the string array
      
      for(int x = 0; x < solidFive.length; x++){  // for loop will loop through and add into int sum.
        arrayFive[x] = Integer.parseInt(solidFive[x]);
        sumFive += arrayFive[x]; // sum
      }
      
      BigInteger prime = new BigInteger("257");
      long ya = solidFive.length;
      BigInteger five1 = BigInteger.valueOf(ya*sumFive);
      BigInteger five3 = null;
      
      five3 = five1.modInverse(prime);
      share5.append(five3 + "\n"); // displays avg in share5
    }
    
  }
  
  //this reconstructs the shares and dumps the result to the reconstructed text area
  public void txtRecon() 
  {
    
    int shareOneValue = 0; // start at value 0..
    
    int[] arrayValues = new int[10];     // this will have y1 y2 and y3
    int[] arrayValuesforX = new int[10];  // this will have x1 x2 and x3
    
   if(chk1.isSelected()){
     String[] solid = share1.getText().split("\n"); // comes in as a string array
     int[] array = new int[solid.length];  // int array length of the string array
     
     for(int x = 0; x < solid.length; x++){  // for loop will loop through and add into int sum.
       array[x] = Integer.parseInt(solid[x]);
     }
     shareOneValue = array[solid.length-1];
   }
   
   int shareTwoValue = 0;  // start at value 0
   
   if(chk2.isSelected()){

       String[] solidTwo = share2.getText().split("\n"); // comes in as a string array
     int[] arrayTwo = new int[solidTwo.length];  // int array length of the string array
     
     for(int x = 0; x < solidTwo.length; x++){  // for loop will loop through and add into int sum.
       arrayTwo[x] = Integer.parseInt(solidTwo[x]);
     }
     shareTwoValue = arrayTwo[solidTwo.length-1];
   }
   
   int shareThreeValue = 0;
   
   if(chk3.isSelected()){
       String[] solidThree = share3.getText().split("\n"); // comes in as a string array
     int[] arrayThree = new int[solidThree.length];  // int array length of the string array
     
     for(int x = 0; x < solidThree.length; x++){  // for loop will loop through and add into int sum.
       arrayThree[x] = Integer.parseInt(solidThree[x]);
     }
     shareThreeValue = arrayThree[solidThree.length-1];
   }
   
   int sharefourValue = 0;
   
   if(chk4.isSelected()){
     
       String[] solidFour = share4.getText().split("\n"); // comes in as a string array
     int[] arrayFour = new int[solidFour.length];  // int array length of the string array
     
     for(int x = 0; x < solidFour.length; x++){  // for loop will loop through and add into int sum.
       arrayFour[x] = Integer.parseInt(solidFour[x]);
     }
     sharefourValue = arrayFour[solidFour.length-1];
   }
   
   int shareFiveValue = 0;
   
   if(chk5.isSelected()){
       String[] solidFive = share5.getText().split("\n"); // comes in as a string array
     int[] arrayFive = new int[solidFive.length];  // int array length of the string array
     
     for(int x = 0; x < solidFive.length; x++){  // for loop will loop through and add into int sum.
       arrayFive[x] = Integer.parseInt(solidFive[x]);
     }
     shareFiveValue = arrayFive[solidFive.length-1];
   }
   
   for(int t = 0; t < 3; t++){
     if(shareOneValue != 0){
       arrayValues[t] = shareOneValue;
       arrayValuesforX[t] = 1;
       t++;
     }
     
     if(shareTwoValue != 0){
       arrayValues[t] = shareTwoValue;
       arrayValuesforX[t] = 2;
       t++;
     }
     
     if(shareThreeValue != 0){
       arrayValues[t] = shareThreeValue;
       arrayValuesforX[t] = 3;
       t++;
     }
     
     if(sharefourValue != 0){
       arrayValues[t] = sharefourValue;
       arrayValuesforX[t] = 4;
       t++;
     }
     
     if(shareFiveValue != 0){
       arrayValues[t] = shareFiveValue;
       arrayValuesforX[t] = 5;
       t++;
     }
     
   }
   
   for(int w = 0; w <3; w++){
     System.out.println("The value of y"+(w+1)+" is: "+ arrayValues[w]);       // y1, y2, y3
     System.out.println("The value of x"+(w+1) +" is: " + arrayValuesforX[w]);  // x1, x2, x3
   }
   
   int xx0 = 0;
   
   int y1 = arrayValues[0];
   int y2 = arrayValues[1];
   int y3 = arrayValues[2];
   
   int X1 = arrayValuesforX[0];
   int X2 = arrayValuesforX[1];
   int X3 = arrayValuesforX[2];
   
   //functionanswer is based on the formula given in class example!
   int functionAnswer = ((arrayValues[0] * (((xx0 - arrayValuesforX[1])*(xx0 - arrayValuesforX[2]))/(arrayValuesforX[0] - arrayValuesforX[1])*(arrayValuesforX[0] - arrayValuesforX[2]))) + (y2 * ((xx0 - X1)*(xx0-X3))/((X2-X1)*(X2-X3))) + (y3 * ((xx0-X1)*(xx0-X2))/((X3-X1)*(X3-X2)))) % 257;
   
    retxt.append(functionAnswer + "\n");  // value displayed in reconstructed avg.
   
  }

  //////////////////////////////////////////////////////
  //Basic Program Functions for Input/Output Ends Here// 
  //////////////////////////////////////////////////////
  

  //this determines what button has been pressed on the GUI
  public void actionPerformed(ActionEvent aE) {
    if (aE.getSource() == bttLoad)    {txtRead(SelectFile());}
    if (aE.getSource() == bttCreate)  {txtShare();}
    if (aE.getSource() == bttRecon)   {txtRecon();}
    if (aE.getSource() == bttAveg)    {txtAveg();}
    if (aE.getSource() == bttDisplay) {JOptionPane.showMessageDialog(null,instructTxt);}
    if (aE.getSource() == bttAbout)   {JOptionPane.showMessageDialog(null,aboutTxt);}
    if (aE.getSource() == bttQuit)    {System.exit(0);}
  }
  
  //this is the program's main method, which creates a new application with title, then checks if closes
  public static void main(String args[]) {
     SwingUtilities.invokeLater(new Runnable() {public void run() {ShareHomo gui = new ShareHomo(); gui.setVisible(true);}});
  }
}