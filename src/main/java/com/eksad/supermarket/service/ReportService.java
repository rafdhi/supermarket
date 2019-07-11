	package com.eksad.supermarket.service;
	
	import java.math.BigDecimal;
	import java.math.BigInteger;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.eksad.supermarket.dao.TransactionDao;
	import com.eksad.supermarket.entity.TransactionReport;
	
	import net.sf.jasperreports.engine.JasperCompileManager;
	import net.sf.jasperreports.engine.JasperExportManager;
	import net.sf.jasperreports.engine.JasperFillManager;
	import net.sf.jasperreports.engine.JasperPrint;
	import net.sf.jasperreports.engine.JasperReport;
	import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
	
	@Service
	public class ReportService {
		
		@Autowired
		TransactionDao transactionDao;
		
		BigDecimal overall = new BigDecimal("0");
		
		public String generateReport() {
			
			try {
				List<Object[]> treport = transactionDao.transactionReport();
				List<TransactionReport> transactionList = new ArrayList<>();

				for(Object[] tr : treport) {
					TransactionReport transaction = new TransactionReport();
					transaction.setId((BigInteger) tr[0]);
					transaction.setDate((Date) tr[1]);
					transaction.setProduct((String) tr[2]);
					transaction.setPrice((BigDecimal) tr[3]);
					transaction.setQuantity((Integer) tr[4]);
					transaction.setTotal((BigDecimal) tr[5]);
					overall = overall.add(transaction.getTotal());
					transactionList.add(transaction);
				}
				
				
				//jasper report location
				String reportPath = "C:\\Users\\User-PC\\Documents\\supermarket\\supermarket\\src\\main\\resources";
				JasperReport jasperReport = JasperCompileManager.compileReport(reportPath+"\\transaction_detail.jrxml");
				
				//datasource
				JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(transactionList);
				
				//parameter
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("created by", "Rafdhi HM");
				map.put("overall", this.overall);
				
				JasperPrint jasperPrint = JasperFillManager
						.fillReport(jasperReport, map, jrBeanCollectionDataSource);
				
				JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath+"\\transaction_report.pdf");
				
				System.out.println("Done");
	
				return "jasper report successfuly generated @path= "+ reportPath;
			} catch (Exception e) {
					e.printStackTrace();
				return "Error --> check console log";
			}
		}
		
	}
