/*package springboot.minsa.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import springboot.minsa.models.Referencia;

@Component("referencia/reporteEstadoReferencias")
public class ListarReferenciaPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Referencia> referencias = (List<Referencia>) model.get("referencias");
		
		
		PdfPTable tablaReferencias = new PdfPTable(6);
		referencias.forEach(referencia -> {
			tablaReferencias.addCell("DNI");
			tablaReferencias.addCell(referencia.getDniPaciente().toString());

			tablaReferencias.addCell("Nombre Paciente");
			tablaReferencias.addCell(referencia.getNomPaciente());

			tablaReferencias.addCell("Apellido Paterno");
			tablaReferencias.addCell(referencia.getApePatPaciente());

			tablaReferencias.addCell("Apellido Materno");
			tablaReferencias.addCell(referencia.getApeMatPaciente());

			tablaReferencias.addCell("Apellido Especialidad");
			tablaReferencias.addCell(referencia.getEspecialidadDestino().getNombre());

			tablaReferencias.addCell("Estado");
			tablaReferencias.addCell(referencia.getStatus());
		});
		
		document.add(tablaReferencias);
		
		
		
		
	}

}*/
