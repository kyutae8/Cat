package site.kyutae.cat;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CatMAIN extends JFrame {
	private static final long serialVersionUID = 1L;
	//ÆÐ³Î »ý¼º
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JPanel southwest = new JPanel();
	private JPanel southeast = new JPanel();
	//Å×ÀÌºí ¸ðµ¨ ±¸Çö!
	private String[] colm = {"¹øÈ£","ÀÌ¸§","Á¾·ù","³ªÀÌ","¼ºº°","»ýÀÏ"};
	private JTable table = new JTable(new DefaultTableModel(colm,0));
	private JScrollPane scroll = new JScrollPane(table);
	//southwest ÄÄÆ÷³ÍÆ® ¸¸µé±â!
	private JLabel cnum = new JLabel("¹øÈ£");
	private JLabel cname = new JLabel("ÀÌ¸§");
	private JLabel ckind = new JLabel("Á¾·ù");
	private JLabel cage = new JLabel("³ªÀÌ");
	private JLabel cgender = new JLabel("¼ºº°");
	private JLabel cbirth = new JLabel("»ýÀÏ");
	private JTextField cnumtext = new JTextField();
	private JTextField cnametext = new JTextField();
	private JTextField ckindtext = new JTextField();
	private JTextField cagetext = new JTextField();
	private String[] gender = {"¾ÏÄÆ","¼öÄÆ","Áß¼ºÈ­"};
	private JComboBox<String> cgendercombo = new JComboBox<String>(gender);
	private JTextField cbirthtext = new JTextField();
	//southeast ÄÄÆ÷³ÍÆ® ¸¸µé±â!
	private String imageurl = "C:\\Users\\\\82102\\eclipse-workspace\\semiproject2\\src\\catimage\\";
	private ImageIcon image = new ImageIcon(imageurl);
	private JLabel imageicon = new JLabel("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
	private String[] crud = {"°Ë»ö(¹øÈ£)","°Ë»ö(ÀÌ¸§)","¼öÁ¤","Ãß°¡","»èÁ¦","»çÁøº¸±â"};
	private JComboBox<String> combobox = new JComboBox<String>(crud);
	private JButton order = new JButton("½ÇÇà");
	private JButton cancel = new JButton("ÃÊ±âÈ­");
	public CatMAIN() {
		//±âº» ÅØ½ºÆ® º¯°æºÒ°¡
		texteditfalse();
		//±âº» ÀüÃ¼ Å×ÀÌºíºä
		view();
		//Å×ÀÌºí  ¼öÁ¤ºÒ°¡
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		//¸Ç µÚ ·¹ÀÌ¾Æ¿ô ÁöÁ¤
		setLayout(new GridLayout(0,1));
		south.setLayout(new GridLayout(1,0));
		southwest.setLayout(null);
		southeast.setLayout(null);
		north.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"TABLE"));
		south.setBorder(new LineBorder(Color.black));
		southwest.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"TEXT"));
		southeast.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"ORDER"));
		//southwest ÄÄÆ÷³ÍÆ® À§Ä¡¼³Á¤
		cnum.setBounds(70,30,100,30);
		cname.setBounds(70,80,100,30);
		ckind.setBounds(70,130,100,30);
		cage.setBounds(70,180,100,30);
		cgender.setBounds(70,230,100,30);
		cbirth.setBounds(70,280,100,30);
		cnumtext.setBounds(170,30,120,30);
		cnametext.setBounds(170,80,120,30);
		ckindtext.setBounds(170,130,120,30);
		cagetext.setBounds(170,180,120,30);
		cgendercombo.setBounds(170,230,120,30);
		cbirthtext.setBounds(170,280,120,30);
		//southeast ÄÄÆ÷³ÍÆ® À§Ä¡¼³Á¤
		imageicon.setBorder(new TitledBorder(new LineBorder(Color.black),"IMAGE"));
		imageicon.setBounds(50,30,300,200);
		combobox.setBounds(60,250,100,30);
		order.setBounds(190,250,60,30);
		cancel.setBounds(280,250,80,30);
		//north ÄÄÆ÷³ÍÆ® Ãß°¡!
		north.add(scroll);
		//southwest ÄÄÆ÷³ÍÆ® Ãß°¡!
		southwest.add(cnum);
		southwest.add(cname);
		southwest.add(ckind);
		southwest.add(cage);
		southwest.add(cgender);
		southwest.add(cbirth);
		southwest.add(cnumtext);
		southwest.add(cnametext);
		southwest.add(ckindtext);
		southwest.add(cagetext);
		southwest.add(cgendercombo);
		southwest.add(cbirthtext);
		//southeast ÄÄÆ÷³ÍÆ® Ãß°¡!
		southeast.add(imageicon);
		southeast.add(combobox);
		southeast.add(order);
		southeast.add(cancel);
		//ÆÐ³Î Ãß°¡!
		add(north);
		south.add(southwest);
		south.add(southeast);
		add(south);
		
		setTitle("CAT");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//¾×¼Ç ÀÌº¥Æ® (ÄÞº¸¹Ú½º)
		combobox.addActionListener(e->{
			String select = (String) combobox.getSelectedItem();
			if (select.equals("°Ë»ö(¹øÈ£)")) {
				textnull();
				texteditfalse();
				cnumtext.setEditable(true);
			}
			if (select.equals("°Ë»ö(ÀÌ¸§)")) {
				textnull();
				texteditfalse();
				cnametext.setEditable(true);
			}
			if (select.equals("¼öÁ¤")) {
				textnull();
				texteditfalse();
				String input = JOptionPane.showInputDialog("¼öÁ¤ÇÒ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
				if (input==null) {
					textnull();
					texteditfalse();
				}else {
					cnumtext.setText(input);
					cnumtext.setEditable(false);
					cnametext.setEditable(true);
					ckindtext.setEditable(true);
					cagetext.setEditable(true);
					cgendercombo.setEnabled(true);
					cgendercombo.setEditable(true);
					cbirthtext.setEditable(true);
				}
			}
			if (select.equals("Ãß°¡")) {
				textnull();
				texteditfalse();
				cnumtext.setEditable(true);
				cnametext.setEditable(true);
				ckindtext.setEditable(true);
				cagetext.setEditable(true);
				cgendercombo.setEnabled(true);
				cgendercombo.setEditable(true);
				cbirthtext.setEditable(true);
			}
			if (select.equals("»èÁ¦")) {
				textnull();
				texteditfalse();
				cnumtext.setEditable(true);
			}
			if (select.equals("»çÁøº¸±â")) {
				textnull();
				cnumtext.setEditable(true);
			}
		});
		//¾×¼Ç ÀÌº¥Æ®(¸í·É¹öÆ°)
		order.addActionListener(e->{
			String select = (String) combobox.getSelectedItem();
			if (select.equals("Ãß°¡")) {
				insert();
				view();
				textnull();
			}
			if (select.equals("°Ë»ö(¹øÈ£)")) {
					viewno();
					textnull();
			}
			if (select.equals("°Ë»ö(ÀÌ¸§)")) {
				viewname();
				textnull();
			}
			if (select.equals("¼öÁ¤")) {
				update();
				view();
			}
			if (select.equals("»çÁøº¸±â")) {
				viewphoto();
				textnull();
			}
			if (select.equals("»èÁ¦")) {
				delete();
				view();
				textnull();
			}
		});
		//ÃÊ±âÈ­ ¹öÆ°
		cancel.addActionListener(e->{
			textnull();
			texteditfalse();
			view();
		});
	}
	public static void main(String[] args) {
		new CatMAIN();
	}
	//ÅØ½ºÆ® ¸ø¾²°Ô¸¸µå´Â ¸Þ¼Òµå
	public void texteditfalse() {
		cnumtext.setEditable(false);
		cnametext.setEditable(false);
		ckindtext.setEditable(false);
		cagetext.setEditable(false);
		cgendercombo.setEnabled(false);
		cgendercombo.setEditable(false);
		cbirthtext.setEditable(false);
	}
	//ÅØ½ºÆ® ÃÊ±âÈ­ÇÏ´Â ¸Þ¼Òµå
	public void textnull() {
		cnumtext.setText("");
		cnametext.setText("");
		ckindtext.setText("");
		cagetext.setText("");
		cbirthtext.setText("");
	}
	public void update() {
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"¹øÈ£´Â 3ÀÚ¸´¼ö ¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		if (cnametext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String namereg = "^[°¡-ÆRa-zA-Z]{1,6}$";
		if (!Pattern.matches(namereg,cnametext.getText())) {
			JOptionPane.showMessageDialog(this,"ÀÌ¸§Àº 1~6ÀÚ¸® ÇÑ±Û ¶Ç´Â ¿µ¹®ÀÔ´Ï´Ù.");
			return;
		}
		if (ckindtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Á¾·ù¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String kindreg = "^[°¡-ÆRa-zA-Z]{1,10}$";
		if (!Pattern.matches(kindreg,ckindtext.getText())) {
			JOptionPane.showMessageDialog(this,"Á¾·ù´Â 1~10ÀÚ¸® ÇÑ±Û ¶Ç´Â ¿µ¹®ÀÔ´Ï´Ù.");
			return;
		}
		if (cagetext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"³ªÀÌÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String agereg = "^\\d{1,2}[»ì]$";
		if (!Pattern.matches(agereg,cagetext.getText())) {
			JOptionPane.showMessageDialog(this,"³ªÀÌ´Â 1~2ÀÚ¸´¼ö ¼ýÀÚ+»ì ÀÔ´Ï´Ù. ");
			return;
		}
		if (cbirthtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"»ýÀÏÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String birthreg = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]||3[01])$";
		if (!Pattern.matches(birthreg,cbirthtext.getText())) {
			JOptionPane.showMessageDialog(this,"ex)YYYY-MM-DD ");
			return;
		}
		CatDTO dto = new CatDTO();
		dto.setCnum(Integer.parseInt(cnumtext.getText()));
		dto.setCname(cnametext.getText());
		dto.setCkind(ckindtext.getText());
		dto.setCage(cagetext.getText());
		dto.setCgender(cgendercombo.getSelectedItem().toString());
		dto.setCbirth(cbirthtext.getText());
		int row = CatDAO.getDao().update(dto);
		if (row>0) {
			JOptionPane.showMessageDialog(this,"¼º°ø");
			texteditfalse();
			view();
		}else {
			JOptionPane.showMessageDialog(this,"½ÇÆÐ");
			
		}
		imageicon.setIcon(null);
		imageicon.setText("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
	}
	public void insert() {
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"¹øÈ£´Â 3ÀÚ¸´¼ö ¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		if (cnametext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String namereg = "^[°¡-ÆRa-zA-Z]{1,6}$";
		if (!Pattern.matches(namereg,cnametext.getText())) {
			JOptionPane.showMessageDialog(this,"ÀÌ¸§Àº 1~6ÀÚ¸® ÇÑ±Û ¶Ç´Â ¿µ¹®ÀÔ´Ï´Ù.");
			return;
		}
		if (ckindtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Á¾·ù¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String kindreg = "^[°¡-ÆRa-zA-Z]{1,10}$";
		if (!Pattern.matches(kindreg,ckindtext.getText())) {
			JOptionPane.showMessageDialog(this,"Á¾·ù´Â 1~10ÀÚ¸® ÇÑ±Û ¶Ç´Â ¿µ¹®ÀÔ´Ï´Ù.");
			return;
		}
		if (cagetext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"³ªÀÌÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String agereg = "^\\d{1,2}[»ì]$";
		if (!Pattern.matches(agereg,cagetext.getText())) {
			JOptionPane.showMessageDialog(this,"³ªÀÌ´Â 1~2ÀÚ¸´¼ö ¼ýÀÚ+»ì ÀÔ´Ï´Ù. ");
			return;
		}
		if (cbirthtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"»ýÀÏÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String birthreg = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]||3[01])$";
		if (!Pattern.matches(birthreg,cbirthtext.getText())) {
			JOptionPane.showMessageDialog(this,"ex)YYYY-MM-DD ");
			return;
		}
		CatDTO dto = new CatDTO();
		dto.setCnum(Integer.parseInt(cnumtext.getText()));
		dto.setCname(cnametext.getText());
		dto.setCkind(ckindtext.getText());
		dto.setCage(cagetext.getText());
		dto.setCgender(cgendercombo.getSelectedItem().toString());
		dto.setCbirth(cbirthtext.getText());
		int row = CatDAO.getDao().inesrt(dto);
		if (row>0) {
			JOptionPane.showMessageDialog(this,"¼º°ø");
			texteditfalse();
			view();
		}else {
			JOptionPane.showMessageDialog(this,"½ÇÆÐ");
			
		}
		imageicon.setIcon(null);
		imageicon.setText("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
	}
	public void view() {
		List<CatDTO> list = CatDAO.getDao().viewAll();
		if (list.isEmpty()) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		for (CatDTO catDTO : list) {
			Vector<Object> data = new Vector<Object>();
			data.add(catDTO.getCnum());
			data.add(catDTO.getCname());
			data.add(catDTO.getCkind());
			data.add(catDTO.getCage());
			data.add(catDTO.getCgender());
			data.add(catDTO.getCbirth().substring(0,10));
			model.addRow(data);
			imageicon.setIcon(null);
			imageicon.setText("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
		}
	}
	public void viewno() {
		List<CatDTO> dto = CatDAO.getDao().searchno(Integer.parseInt(cnumtext.getText()));
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"¹øÈ£´Â 3ÀÚ¸® ¼ýÀÚÀÔ´Ï´Ù.");
			return;
		}
		if (dto.isEmpty()) {
			JOptionPane.showMessageDialog(this,"°Ë»ö°á°ú°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		for (CatDTO catDTO : dto) {
			
			Vector<Object> cat = new Vector<Object>();
			cat.add(catDTO.getCnum());
			cat.add(catDTO.getCname());
			cat.add(catDTO.getCkind());
			cat.add(catDTO.getCage());
			cat.add(catDTO.getCgender());
			cat.add(catDTO.getCbirth().substring(0,10));
			model.addRow(cat);
			imageicon.setIcon(null);
			imageicon.setText("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
		}
		
		JOptionPane.showMessageDialog(this,"¼º°ø");
	}
	public void viewname() {
		List<CatDTO> dto = CatDAO.getDao().searchname(cnametext.getText());
		if (cnametext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String namereg = "^[°¡-ÆRa-zA-Z]{1,6}$";
		if (!Pattern.matches(namereg,cnametext.getText())) {
			JOptionPane.showMessageDialog(this,"1~6ÀÚ¸® ÇÑ±Û ¶Ç´Â ¿µ¹®ÀÔ´Ï´Ù.");
			return;
		}
		if (dto.isEmpty()) {
			JOptionPane.showMessageDialog(this,"°Ë»ö°á°ú°¡ ¾ø½À´Ï´Ù");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		for (CatDTO catDTO : dto) {
				
			Vector<Object> cat = new Vector<Object>();
			cat.add(catDTO.getCnum());
			cat.add(catDTO.getCname());
			cat.add(catDTO.getCkind());
			cat.add(catDTO.getCage());
			cat.add(catDTO.getCgender());
			cat.add(catDTO.getCbirth().substring(0,10));
			model.addRow(cat);
			imageicon.setIcon(null);
			imageicon.setText("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
		}
		JOptionPane.showMessageDialog(this,"¼º°ø");
	}
	public void delete() {
		int row = CatDAO.getDao().delete(Integer.parseInt(cnumtext.getText()));
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"¹øÈ£´Â 3ÀÚ¸® ¼ýÀÚÀÔ´Ï´Ù.");
			return;
		}
		if (row>0) {
			JOptionPane.showMessageDialog(this,"¼º°ø");
		}else {
			JOptionPane.showMessageDialog(this,"½ÇÆÐ");
		}
		imageicon.setIcon(null);
		imageicon.setText("»çÁøÀ» º¸·Á¸é »çÁøº¸±â¸¦ ÀÌ¿ë");
	}
	public void viewphoto() {
		List<CatDTO> dto = CatDAO.getDao().searchno(Integer.parseInt(cnumtext.getText()));
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"¹øÈ£´Â 3ÀÚ¸® ¼ýÀÚÀÔ´Ï´Ù.");
			return;
		}
		if (dto.isEmpty()) {
			JOptionPane.showMessageDialog(this,"°Ë»ö°á°ú°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		for (CatDTO catDTO : dto) {
			
			Vector<Object> cat = new Vector<Object>();
			cat.add(catDTO.getCnum());
			cat.add(catDTO.getCname());
			cat.add(catDTO.getCkind());
			cat.add(catDTO.getCage());
			cat.add(catDTO.getCgender());
			cat.add(catDTO.getCbirth().substring(0,10));
			model.addRow(cat);
			image = new ImageIcon(imageurl+catDTO.getCnum()+".jpg");
			imageicon.setIcon(image);
			imageicon.setText("");
		}
		
		JOptionPane.showMessageDialog(this,"¼º°ø");
	}
}
