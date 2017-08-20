package Example.bcParserApplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.bestcode.mathparser.IFunction;
import com.bestcode.mathparser.IMathParser;
import com.bestcode.mathparser.IParameter;
import com.bestcode.mathparser.MathParserFactory;

public class AppletbcParser extends Applet {

  boolean isStandalone = false;
  BorderLayout borderLayout1 = new BorderLayout();
  Panel panel1 = new Panel();
  BorderLayout borderLayout2 = new BorderLayout();
  Panel panel4 = new Panel();
  BorderLayout borderLayout3 = new BorderLayout();
  Panel panel5 = new Panel();
  Label label3 = new Label();
  BorderLayout borderLayout4 = new BorderLayout();
  TextField textFieldFunc = new TextField();
  Panel panel6 = new Panel();
  Button buttonRun = new Button();
  Label labelResult = new Label();
  Label label5 = new Label();
  List listFuncs = new List();
  Panel panel7 = new Panel();
  Panel panel8 = new Panel();
  Panel panel9 = new Panel();
  BorderLayout borderLayout5 = new BorderLayout();

  Choice choiceV = new Choice();
  Label label4 = new Label();
  Panel panel10 = new Panel();
  BorderLayout borderLayout6 = new BorderLayout();
  TextField textFieldX = new TextField();
  TextField textFieldY = new TextField();
  Panel panel2 = new Panel();
  Panel panel3 = new Panel();
  Label label1 = new Label();
  Label label2 = new Label();
  Label label6 = new Label();
  Choice choiceF = new Choice();

  Panel panel11 = new Panel();
  BorderLayout borderLayout7 = new BorderLayout();
  Panel panel12 = new Panel();
  Button button2 = new Button();
  TextField textValue = new TextField();
  Label label7 = new Label();
  TextField textVar = new TextField();
  Label label8 = new Label();

  
  private IMathParser parser = MathParserFactory.create();

  Panel panel13 = new Panel();
  BorderLayout borderLayout8 = new BorderLayout();
  BorderLayout borderLayout9 = new BorderLayout();


  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public AppletbcParser() {
  }

  //Initialize the applet
  public void init() {
    try  {
      jbInit();
    }
    catch(Exception e)  {
      e.printStackTrace();
    }
  }

  static class FactFunctionDefinition implements IFunction {
		public int getNumberOfParams() {
			return 1; //Our function has 1 parameter in the expression.
		}
		public double run(IParameter[] p) {
			return factorial(p[0].getValue());
		}
		public double factorial (double x){
			if(x>1){
				return x*factorial(x-1);
			}else{
				return 1;
			}
		}
  }
  
  //Component initialization
  private void jbInit() throws Exception {
  	//Somewhere, we want to add out user defined functions:
  	parser.createFunc("FACT", new FactFunctionDefinition()); //once this is done, users can use FACT in their expressions.
  	
    this.setSize(new Dimension(400,300));
    this.setLayout(borderLayout1);
    panel1.setLayout(borderLayout2);
    panel4.setLayout(borderLayout3);
    label3.setText("Function to evaluate: (Pick from list or type)");
    panel5.setLayout(borderLayout4);
    buttonRun.setName("Evaluate");
    buttonRun.setLabel("Evaluate");
    buttonRun.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        buttonRun_actionPerformed(e);
      }
    });
    panel6.setLayout(borderLayout8);
    labelResult.setText("N/A                                             ");
    label5.setText("Result:");
    listFuncs.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        listFuncs_actionPerformed(e);
      }
    });
    panel7.setLayout(borderLayout5);
    label4.setText("Functions:");
    panel10.setLayout(borderLayout6);
    textFieldX.setColumns(20);
    textFieldY.setColumns(20);
    label1.setText("X Value:");
    label2.setText("Y Value:");
    label6.setText("Variables:");
    panel11.setLayout(borderLayout7);
    button2.setLabel("Add");
    button2.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        button2_actionPerformed(e);
      }
    });
    textValue.setName("textValue");
    textValue.setText("5000");
    label7.setText("Value:");
    textVar.setText("MYVAR");
    label8.setText("Custom Variable:");
    panel13.setLayout(borderLayout9);
    borderLayout8.setHgap(2);
    choiceV.addItemListener(new java.awt.event.ItemListener() {

      public void itemStateChanged(ItemEvent e) {
        choiceV_itemStateChanged(e);
      }
    });
    this.add(panel1, BorderLayout.NORTH);
    panel1.add(panel7, BorderLayout.EAST);
    panel7.add(panel9, BorderLayout.WEST);
    panel9.add(label4, null);
    panel9.add(choiceF, null);
    panel7.add(panel8, BorderLayout.SOUTH);
    panel8.add(label6, null);
    panel8.add(choiceV, null);
    panel1.add(panel10, BorderLayout.WEST);
    panel10.add(panel2, BorderLayout.NORTH);
    panel2.add(label1, null);
    panel2.add(textFieldX, null);
    panel10.add(panel3, BorderLayout.SOUTH);
    panel3.add(label2, null);
    panel3.add(textFieldY, null);
    this.add(panel4, BorderLayout.SOUTH);
    panel4.add(panel5, BorderLayout.SOUTH);
    panel5.add(textFieldFunc, BorderLayout.NORTH);
    panel5.add(panel6, BorderLayout.CENTER);
    panel6.add(panel13, BorderLayout.CENTER);
    panel13.add(label5, BorderLayout.WEST);
    panel13.add(labelResult, BorderLayout.CENTER);
    panel6.add(buttonRun, BorderLayout.WEST);
    panel4.add(label3, BorderLayout.NORTH);
    listFuncs.add("SIN(3.14)+5^2+POW(2,7)-MAX(10,20)");
    listFuncs.add("{ [ SIN(X)^2 ] + COS(1) } * PI/2");
    listFuncs.add("LOG(1-X^2+X^5)+Y");
    listFuncs.add("3.6 + MIN(X, Y)");
    listFuncs.add("EXP(-1.53389*(X-32))*POW(Y, 0.13547)");
    listFuncs.add("5 + IF(X<>0, 3/X, 0)");
    listFuncs.add("3 + X^Y");
    listFuncs.add("IF( Y>=X, 6, 8 )");
    listFuncs.add("IF( (Y>X)&(Y<10), 6, 8 )");
    
    this.add(panel11, BorderLayout.CENTER);
    panel11.add(listFuncs, BorderLayout.CENTER);
    panel11.add(panel12, BorderLayout.NORTH);
    panel12.add(label8, null);
    panel12.add(textVar, null);
    panel12.add(label7, null);
    panel12.add(textValue, null);
    panel12.add(button2, null);

    Object[] funcs = parser.getFunctions();
    for (int i=0; i<funcs.length; i++){
      choiceF.add(funcs[i].toString());
    }
    Object[] vars = parser.getVariables();
    for (int i=0; i<vars.length; i++){
      choiceV.add(vars[i].toString());
    }
  }

  //Start the applet
  public void start() {
  }

  //Stop the applet
  public void stop() {
  }

  //Destroy the applet
  public void destroy() {
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  //Main method
  public static void main(String[] args) {
    AppletbcParser applet = new AppletbcParser();
    applet.isStandalone = true;
    Frame frame = new Frame();
    frame.setTitle("Applet Frame");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    
    frame.addWindowListener(new ExitListener(frame));
    
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }
  public void listFuncs_actionPerformed(ActionEvent e) {
    textFieldFunc.setText(listFuncs.getSelectedItem());
  }
  public void calculate(){
    try{
      labelResult.setText("Starting calculation");
      String exp = textFieldFunc.getText();
      double x = 0, y = 0;
      //MathParser2 parser = MathParserFactory.create();
      parser.setExpression(exp);
      //we should not require the user enter X value if it is
      //not used in the expression:
      if (parser.isVariableUsed("X")){
        try{
          x = Double.valueOf(textFieldX.getText()).doubleValue();
        }
        catch(Exception ex){
          labelResult.setText("X value is not valid.");
          return;
        }
        parser.setX(x);
      }

      //we should not require the user enter Y value if it is
      //not used in the expression:
      if (parser.isVariableUsed("Y")){
        try{
          y = Double.valueOf(textFieldY.getText()).doubleValue();
        }
        catch(Exception ex){
          labelResult.setText("Y value is not valid.");
          return;
        }
        parser.setY(y);
      }

      parser.setOptimizationOn(true);
      try {
        //give it a million tries and see how it goes:
        /*
        long t = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
          parser.getValue();
        }
        System.out.println(System.currentTimeMillis()- t);
        */
        labelResult.setText(Double.toString(parser.getValue()));
      }
      catch(Exception ex){
        labelResult.setText(ex.getMessage());
      }
    }
    catch(Exception except){
      labelResult.setText(except.getMessage());
    }
  }

  void buttonRun_actionPerformed(ActionEvent e) {
    calculate();
  }

  void button2_actionPerformed(ActionEvent e) {
    double x;
    String varName = textVar.getText();
    try{
      x = Double.valueOf(textValue.getText()).doubleValue();
    }
    catch(Exception ex){
      labelResult.setText("Variable '" + varName + "' value is not valid.");
      return;
    }
    try{
      parser.setVariable(varName, x);
    }catch(Exception ex){
      labelResult.setText(ex.getMessage());
      return;
    }
    try{
      this.textFieldX.setText(String.valueOf(parser.getX()));
      this.textFieldY.setText(String.valueOf(parser.getY()));

      int count = choiceV.getItemCount();
      String item;
      for(int i=0; i<count; i++){
        item = choiceV.getItem(i);
        if (varName.equals(item)){
          labelResult.setText(varName + " value is set to " + x);
          return; //return without adding tiem to list.
        }
      }
      //if variable is not in the list we should add it:
      choiceV.add(varName);
      labelResult.setText(varName + " is created with value: " + x);

    }catch(Exception ex){}
  }

  void choiceV_itemStateChanged(ItemEvent e) {
    try{
      String item = (String)e.getItem();
      this.textVar.setText(item);
      this.textValue.setText(String.valueOf(parser.getVariable(item)));
    }catch(Exception ex){
      labelResult.setText(ex.getMessage());
    }
  }
}

final class ExitListener extends WindowAdapter {
  Frame frame_;
  /**
   * Constructor for ExitListener.
   */
  public ExitListener(Frame aFrame) {
    super();
    frame_ = aFrame;
  }

  public void windowClosing(WindowEvent event) {
    if(frame_!=null)
      frame_.dispose();
  }
}

