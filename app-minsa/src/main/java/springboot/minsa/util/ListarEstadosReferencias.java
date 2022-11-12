package springboot.minsa.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;


@Component("referencia/reporteReferenciaDia")
public class ListarEstadosReferencias extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        response.setHeader("Content-Disposition", "attachment; filename=\"total-estado-referencia.xls\"");
		Sheet hoja = workbook.createSheet("Referenciass");
		
		Row filaTitulo = hoja.createRow(0);
		Cell celda = filaTitulo.createCell(0);
		
		celda.setCellValue("REPORTES ESTADO DE REFERENCIA");
		
		Row filaData = hoja.createRow(2);
		String[] columnas = {"Pendientes", "Observadas", "Enviadas", "Citadas", "Alta", "Inhabilitadas", "Totales"};
		
		for (int i = 0; i < columnas.length; i ++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		
        List<Object> referenciasP = (List<Object>) model.get("referenciasP");		
		List<Object> referenciasO = (List<Object>) model.get("referenciasO");
		List<Object> referenciasE = (List<Object>) model.get("referenciasE");
		List<Object> referenciasC = (List<Object>) model.get("referenciasC");
		List<Object> referenciasA = (List<Object>) model.get("referenciasA");
		List<Object> referenciasAn = (List<Object>) model.get("referenciasAn");
		List<Object> referenciasT = (List<Object>) model.get("referenciasT");

		
		

		
		
        
    }

}
