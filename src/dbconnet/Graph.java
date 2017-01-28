package dbconnet;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph extends Frame implements ActionListener,WindowListener{
	private Button button1 = new Button("lineChat");
	private Button button2 = new Button("BarChat");
	private EventObject e;
	int datas[][];
	String name[];
	int i;
	
	public Graph(int datas[][],int i,String name[]){
		this.datas = datas;
		this.name = name;
		this.i = i;
		addWindowListener(this);
		setTitle("Graph");
		
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		for(int g = 0;g < i;g++){
			String s = String.valueOf(datas[1][g]);
			data.addValue(this.datas[2][g], this.name[g], s);
			System.out.println(datas[0][g]+","+s+","+datas[2][g]);
		}
		JFreeChart chart = ChartFactory.createLineChart("Import Volume",
                                   "Year",
                                   "Ton",
                                   data,
                                   PlotOrientation.VERTICAL,
                                   true,
                                   false,
                                   false);
		ChartPanel cpanel = new ChartPanel(chart);
		
		cpanel.add(button1);
		button1.addActionListener(this);
		cpanel.add(button2);
		button2.addActionListener(this);
		add(cpanel, BorderLayout.CENTER);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		for(int g = 0;g<i;g++){
			String s = String.valueOf(datas[1][g]);
			data.addValue(this.datas[2][g], this.name[g], s);
		}
		
		if(e.getSource() == button1){
			JFreeChart chart = ChartFactory.createLineChart("Import Volume",
                                   "Year",
                                   "Ton",
                                   data,
                                   PlotOrientation.VERTICAL,
                                   true,
                                   false,
                                   false);
			ChartPanel cpanel = new ChartPanel(chart);
			add(cpanel, BorderLayout.CENTER);
			setVisible(true);
		}
		else if(e.getSource() == button2){
			JFreeChart chart = ChartFactory.createBarChart("Import Volume",
                                   "Year",
                                   "Ton",
                                   data,
                                   PlotOrientation.VERTICAL,
                                   true,
                                   false,
                                   false);
			ChartPanel cpanel = new ChartPanel(chart);
			add(cpanel, BorderLayout.CENTER);
			setVisible(true);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
