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

import springboot.minsa.models.Referencia;

@Component("referencia/reporteEstadoReferencias")
public class ListarReferenciaExcel extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"reporte-estado-referencia.xls\"");
		Sheet hoja = workbook.createSheet("Referencias");
		
		Row filaTitulo = hoja.createRow(0);
		Cell celda = filaTitulo.createCell(0);
		
		celda.setCellValue("REPORTES ESTADO DE REFERENCIA");
		
		Row filaData = hoja.createRow(2);
		String[] columnas = {"DNI", "Nombres", "Apellido Paterno", "Apellido Materno", "Especialidad", "Estado"};
		
		for (int i = 0; i < columnas.length; i ++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		List<Referencia> referencias = (List<Referencia>) model.get("referencias");
		
		
		int numFila = 3;
		for (Referencia referencia: referencias) {
			
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue(referencia.getDniPaciente());
			filaData.createCell(1).setCellValue(referencia.getNomPaciente());
			filaData.createCell(2).setCellValue(referencia.getApePatPaciente());
			filaData.createCell(3).setCellValue(referencia.getApeMatPaciente());
			filaData.createCell(4).setCellValue(referencia.getEspecialidadDestino().getNombre());
			filaData.createCell(5).setCellValue(referencia.getStatus());
			
			numFila++;
		}
		
		
	}

}
