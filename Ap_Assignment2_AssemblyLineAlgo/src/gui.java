import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.SystemColor;


public class gui {

	int stations;
	private JFrame frame;
	private static Fastest_Way temp;
	static int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp= new Fastest_Way();
					gui window = new gui(temp);
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui(Fastest_Way temp) {
		initialize(temp);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Fastest_Way temp) {
		stations=temp.n;
		int yaxis=50;
		frame = new JFrame ();
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				update();
			}
		});
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				update();
			}
		});
		
		//entry
		JButton btn=new JButton("Entry");
		btn.setBounds(20, yaxis+76, 90, 23);
		frame.getContentPane().add(btn);	
		
		JLabel label;
		
		//entry labels
		label = new JLabel(temp.entry[0]+"");
		label.setBounds(120, yaxis+56, 46, 14);
        
        frame.getContentPane().add(label);
        
        label = new JLabel(temp.entry[1]+"");
        label.setBounds(120, yaxis+106, 46, 14);
        frame.getContentPane().add(label);
		
        //stations and labels
        for(int i=0;i<stations;i++){
			int x=120*i+160;
			JButton tempBtn = new JButton(temp.exec[0][i]+"");
			tempBtn.setBounds(x, yaxis+36, 55, 23);
			frame.getContentPane().add(tempBtn);
			
			JButton tempBtn1 = new JButton(temp.exec[1][i]+"");
			tempBtn1.setBounds(x, yaxis+116, 55, 23);
			frame.getContentPane().add(tempBtn1);
			
			if(i<stations-1){
				
				//straight
				label = new JLabel(0+"");
				label.setBounds(x+80, yaxis+30, 46, 14);
				frame.getContentPane().add(label);
				
				label = new JLabel(0+"");
				label.setBounds(x+80, yaxis+126, 46, 14);
				frame.getContentPane().add(label);
				
				//tilted
				label = new JLabel(temp.transfer[0][i]+"");
				label.setBounds(x+75, yaxis+65, 46, 14);
				frame.getContentPane().add(label);
				
				label = new JLabel(temp.transfer[1][i]+"");
				label.setBounds(x+75, yaxis+95, 46, 14);
				frame.getContentPane().add(label);
			}
		}
        int x=120*stations+140;
		
        //exit labels
        label = new JLabel(temp.exit[0]+"");
      	label.setBounds(x-20, yaxis+56, 46, 14);
      	frame.getContentPane().add(label);
      
      	label = new JLabel(temp.exit[1]+"");
      	label.setBounds(x-20, yaxis+106, 46, 14);
      	frame.getContentPane().add(label);
      		
        //exit
		btn=new JButton("Exit");
		btn.setBounds(x, yaxis+76, 90, 23);
		frame.getContentPane().add(btn);
		
		//arrows
        frame.getContentPane().add ( new JPanel() {
            public void paintComponent ( Graphics g ) {
            	int yaxis=50;
            	//entry
            	drawArrowLine( g,110,yaxis+76,160,yaxis+59,5,5,false);
                drawArrowLine( g,110,yaxis+99,160,yaxis+116,5,5,false);
                for(int i=0;i<stations-1;i++){
        			//stations
                	int x1=120*i+215,x2=120*(i+1)+160;
        			//straight
                	drawArrowLine( g,x1,yaxis+46,x2,yaxis+46,5,5,false);
        			drawArrowLine( g,x1,yaxis+126,x2,yaxis+126,5,5,false);
        			//tilted
        			drawArrowLine( g,x1,yaxis+59,x2,yaxis+116,5,5,false);
        			drawArrowLine( g,x1,yaxis+116,x2,yaxis+59,5,5,false);
        		}
                //exit
                int x1=120*(stations-1)+215,x2=120*(stations)+140;
                drawArrowLine( g,x1,yaxis+59,x2,yaxis+76,5,5,false);
                drawArrowLine( g,x1,yaxis+116,x2,yaxis+99,5,5,false);
            }
        }
        , BorderLayout.CENTER );
        
        frame.setSize ( temp.n*150+200, 300 );
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.setVisible (true);
        frame.getContentPane().setLayout(null);
        
        JLabel lblAssemblyLineAlgorithm = new JLabel("Assembly Line Algorithm");
        lblAssemblyLineAlgorithm.setForeground(SystemColor.windowText);
        lblAssemblyLineAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAssemblyLineAlgorithm.setBounds(262, 0, 230, 38);
        frame.getContentPane().add(lblAssemblyLineAlgorithm);
        frame.getContentPane().requestFocus();
		
	}
	private void update(){
		JLabel label;
		JButton btn;
		int x=0;
		
		if(count==0){
			btn=(JButton)frame.getContentPane().getComponent(x);
			btn.setForeground(Color.RED);
		
			if(temp.f1[0]<=temp.f2[0]){
				label=(JLabel)frame.getContentPane().getComponent(x+1);
				label.setForeground(Color.RED);
				btn=(JButton)frame.getContentPane().getComponent(x+3);
				btn.setForeground(Color.RED);
			}
			else{
				label=(JLabel)frame.getContentPane().getComponent(x+2);
				label.setForeground(Color.RED);
				btn=(JButton)frame.getContentPane().getComponent(x+4);
				btn.setForeground(Color.RED);
			}
			frame.revalidate();
			frame.repaint();
			count++;
		}
		else if(count<temp.n){
			temp.fastest_way(count);
			x=(count-1)*6+5;
			if(temp.f1[count]<=temp.f2[count]){
				if(temp.l1[count]==1){
					label=(JLabel)frame.getContentPane().getComponent(x);
					label.setForeground(Color.RED);
				}
				else{
					label=(JLabel)frame.getContentPane().getComponent(x+3);
					label.setForeground(Color.RED);
				}
				btn=(JButton)frame.getContentPane().getComponent(x+4);
				btn.setForeground(Color.RED);
			}
			else{
				if(temp.l2[count]==1){
					label=(JLabel)frame.getContentPane().getComponent(x+1);
					label.setForeground(Color.RED);
				}
				else{
					label=(JLabel)frame.getContentPane().getComponent(x+2);
					label.setForeground(Color.RED);
				}
				btn=(JButton)frame.getContentPane().getComponent(x+5);
				btn.setForeground(Color.RED);
			}
			frame.revalidate();
			frame.repaint();
			count++;
		}
		else if(count==temp.n){
			x=(temp.n-1)*6+3;
			temp.result();
			if(temp.out[1]==1){
				label=(JLabel)frame.getContentPane().getComponent(x+2);
				label.setForeground(Color.RED);
			}
			else{
				label=(JLabel)frame.getContentPane().getComponent(x+3);
				label.setForeground(Color.RED);
			}
			btn=(JButton)frame.getContentPane().getComponent(x+4);
			btn.setForeground(Color.RED);
			frame.revalidate();
			frame.repaint();
			count++;
		}
	
	}
	private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h,boolean checked){
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};
        
        if(checked)
        	g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }
}
