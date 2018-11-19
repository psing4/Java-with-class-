package 최종발표;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class IncomeChart extends JFrame{
	ArrayList<Income> datas = new ArrayList<Income>();
	Income_DAO dao = new Income_DAO(); //DB연동 클래스
    public IncomeChart() {}
   
    // getChart() 메서드. Chart 를 만들어서 리턴함
    public JFreeChart getChart() {

        JFreeChart chart = ChartFactory.createBarChart(
        						"Profit chart", // title
                                "Category", // categoryAxisLabel
                                "Value", // valueAxisLabel
                                getDataSet(), // dataset
                                PlotOrientation.VERTICAL,// orientation
                                true, // legend
                                true, // tooltips
                                false); // url
        
        return chart;
    }

    // getDataSet() 메서드. dataset 을 만들어서 리턴함 - getChart() 내에서 사용
    private DefaultCategoryDataset getDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        String category1 = "company_pay";
        String category2 = "ideal_pay";
        
        // addValue() 메서드를 이용해서 값을 추가함
        datas = dao.getAll(); 
        for (Income i: datas)
        {
        	double no1=i.getCompany_pay();
        	double no2=i.getIdeal_pay();
        	String test = "id:"+i.getcompany_id()+" month: "+i.getMonth();
        	dataSet.addValue(no1, category1,test);
        	dataSet.addValue(no2, category2,test);
        	
        }
       
        
        return dataSet;
    }   
   
}
