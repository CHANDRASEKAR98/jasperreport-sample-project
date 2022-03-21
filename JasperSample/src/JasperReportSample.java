import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperReportSample {

	public static void main(String[] args) throws JRException {
		
		// Compile jrxml file.
	       JasperReport jasperReport = JasperCompileManager
	               .compileReport("resources/sampleReport.jrxml");

	       // Parameters for report
	       Map<String, Object> parameters = new HashMap<String, Object>();

	       // DataSource
	       // This is simple example, no database.
	       // then using empty datasource.
	       JRDataSource dataSource = new JREmptyDataSource();

	       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
	               parameters, dataSource);

	   
	       // Make sure the output directory exists.
	       File outDir = new File("F:/jasperoutput");
	       outDir.mkdirs();

	       // Export to PDF.
	       JasperExportManager.exportReportToPdfFile(jasperPrint,
	               "F:/jasperoutput/StyledTextReport.pdf");
	       
	       System.out.println("Successfullly done!!");

	}

}
