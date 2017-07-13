package com.bstek.cms.web.portal;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class PortalController {
	
	@DataProvider
	public List<Programa> loadDocuments() {	
		Programa pro = JpaUtil.linq(Programa.class).equal("name", "首页").isNull("parentId").findOne();
		List<Programa> programas = JpaUtil.linq(Programa.class).equal("parentId", pro.getId()).asc("order").list();
		for (Programa programa : programas) {
			List<Document> documents = JpaUtil
				.linq(Document.class)
				.in(ProgramaDocumentLink.class)
					.select("documentId")
					.equal("programaId", programa.getId())
				.end()
				.desc("top")
				.desc("createDate")	
				.list(0, 6);
			programa.setDocuments(documents);
		}
		return programas;
	}
	
	@DataProvider
	public List<Programa> loadHotNews() {	
		List<Programa> programas = JpaUtil.linq(Programa.class).like("name", "%热点").asc("createTime").list();
		for (Programa programa : programas) {
			List<Document> documents = JpaUtil
					.linq(Document.class)
					.in(ProgramaDocumentLink.class)
						.select("documentId")
						.equal("programaId", programa.getId())
					.end()
					.desc("top")
					.desc("createDate")	
					.list(0, 6);
			programa.setDocuments(documents);
		}		
		return programas;
	}

	@DataProvider	
	public List<Programa> loadTopPrograma() {
		return JpaUtil
			.linq(Programa.class)
			.isNull("parentId")
			.asc("order")
			.list();
	}
	
	@DataProvider
	public List<Document> loadDocumentByName(String name) {
		return JpaUtil
			.linq(Document.class)
			.equal("name", name)
			.list();
	}
	
	@DataProvider
	public void loadDocumentByProgramaName(Page<Document> page, Criteria criteria, String programaName) {
		JpaUtil
			.linq(Document.class)
			.where(criteria)
			.equal("programaName", programaName)
			.desc("top")
			.desc("createDate")
			.paging(page);
	}
	
	@Expose
	@Transactional
	public List<Document> saveBrowseNumber(String docId, Integer browseNumber) {
		JpaUtil
			.linu(Document.class)
			.equal("id", docId)
			.set("browseNumber", browseNumber)
			.update();
		
		return JpaUtil
			.linq(Document.class)
			.desc("browseNumber")
			.list(0, 50);
	}
	
	@Expose
	public void image() throws Exception {
//		String param = "http://www.baidu.com";
//		String url = "";
//		if (param.startsWith("http")) {
//			url = param;
//		} else {
//			url = "file:///" + param;
//		}
//
//		Desktop.getDesktop().browse(new URL(url).toURI());
//		Robot robot = new Robot();
//		robot.delay(3000);
//		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
//		int width = (int) d.getWidth();
//		int height = (int) d.getHeight();
//
//		robot.keyRelease(KeyEvent.VK_F11);
//		robot.delay(1000);
//		Image image = robot.createScreenCapture(new Rectangle(0, 0, width, height));
//		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		Graphics g = bi.createGraphics();
//		g.drawImage(image, 0, 0, width, height - 10, null);
//		// 保存图片
//		ImageIO.write(bi, "jpg", new File("D:/" + new Date() + ".jpg"));

		System.out.println("---------00000000000000--------------");
	}
	

}
