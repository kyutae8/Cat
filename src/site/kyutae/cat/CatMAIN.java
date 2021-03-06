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
	//패널 생성
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JPanel southwest = new JPanel();
	private JPanel southeast = new JPanel();
	//테이블 모델 구현!
	private String[] colm = {"번호","이름","종류","나이","성별","생일"};
	private JTable table = new JTable(new DefaultTableModel(colm,0));
	private JScrollPane scroll = new JScrollPane(table);
	//southwest 컴포넌트 만들기!
	private JLabel cnum = new JLabel("번호");
	private JLabel cname = new JLabel("이름");
	private JLabel ckind = new JLabel("종류");
	private JLabel cage = new JLabel("나이");
	private JLabel cgender = new JLabel("성별");
	private JLabel cbirth = new JLabel("생일");
	private JTextField cnumtext = new JTextField();
	private JTextField cnametext = new JTextField();
	private JTextField ckindtext = new JTextField();
	private JTextField cagetext = new JTextField();
	private String[] gender = {"암컷","수컷","중성화"};
	private JComboBox<String> cgendercombo = new JComboBox<String>(gender);
	private JTextField cbirthtext = new JTextField();
	//southeast 컴포넌트 만들기!
	private String imageurl = "C:\\Users\\\\82102\\eclipse-workspace\\semiproject2\\src\\catimage\\";
	private ImageIcon image = new ImageIcon(imageurl);
	private JLabel imageicon = new JLabel("사진을 보려면 사진보기를 이용");
	private String[] crud = {"검색(번호)","검색(이름)","수정","추가","삭제","사진보기"};
	private JComboBox<String> combobox = new JComboBox<String>(crud);
	private JButton order = new JButton("실행");
	private JButton cancel = new JButton("초기화");
	public CatMAIN() {
		//기본 텍스트 변경불가
		texteditfalse();
		//기본 전체 테이블뷰
		view();
		//테이블  수정불가
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		//맨 뒤 레이아웃 지정
		setLayout(new GridLayout(0,1));
		south.setLayout(new GridLayout(1,0));
		southwest.setLayout(null);
		southeast.setLayout(null);
		north.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"TABLE"));
		south.setBorder(new LineBorder(Color.black));
		southwest.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"TEXT"));
		southeast.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"ORDER"));
		//southwest 컴포넌트 위치설정
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
		//southeast 컴포넌트 위치설정
		imageicon.setBorder(new TitledBorder(new LineBorder(Color.black),"IMAGE"));
		imageicon.setBounds(50,30,300,200);
		combobox.setBounds(60,250,100,30);
		order.setBounds(190,250,60,30);
		cancel.setBounds(280,250,80,30);
		//north 컴포넌트 추가!
		north.add(scroll);
		//southwest 컴포넌트 추가!
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
		//southeast 컴포넌트 추가!
		southeast.add(imageicon);
		southeast.add(combobox);
		southeast.add(order);
		southeast.add(cancel);
		//패널 추가!
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
		
		//액션 이벤트 (콤보박스)
		combobox.addActionListener(e->{
			String select = (String) combobox.getSelectedItem();
			if (select.equals("검색(번호)")) {
				textnull();
				texteditfalse();
				cnumtext.setEditable(true);
			}
			if (select.equals("검색(이름)")) {
				textnull();
				texteditfalse();
				cnametext.setEditable(true);
			}
			if (select.equals("수정")) {
				textnull();
				texteditfalse();
				String input = JOptionPane.showInputDialog("수정할 번호를 입력하세요");
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
			if (select.equals("추가")) {
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
			if (select.equals("삭제")) {
				textnull();
				texteditfalse();
				cnumtext.setEditable(true);
			}
			if (select.equals("사진보기")) {
				textnull();
				cnumtext.setEditable(true);
			}
		});
		//액션 이벤트(명령버튼)
		order.addActionListener(e->{
			String select = (String) combobox.getSelectedItem();
			if (select.equals("추가")) {
				insert();
				view();
				textnull();
			}
			if (select.equals("검색(번호)")) {
					viewno();
					textnull();
			}
			if (select.equals("검색(이름)")) {
				viewname();
				textnull();
			}
			if (select.equals("수정")) {
				update();
				view();
			}
			if (select.equals("사진보기")) {
				viewphoto();
				textnull();
			}
			if (select.equals("삭제")) {
				delete();
				view();
				textnull();
			}
		});
		//초기화 버튼
		cancel.addActionListener(e->{
			textnull();
			texteditfalse();
			view();
		});
	}
	public static void main(String[] args) {
		new CatMAIN();
	}
	//텍스트 못쓰게만드는 메소드
	public void texteditfalse() {
		cnumtext.setEditable(false);
		cnametext.setEditable(false);
		ckindtext.setEditable(false);
		cagetext.setEditable(false);
		cgendercombo.setEnabled(false);
		cgendercombo.setEditable(false);
		cbirthtext.setEditable(false);
	}
	//텍스트 초기화하는 메소드
	public void textnull() {
		cnumtext.setText("");
		cnametext.setText("");
		ckindtext.setText("");
		cagetext.setText("");
		cbirthtext.setText("");
	}
	public void update() {
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"번호를 입력해 주세요.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"번호는 3자릿수 숫자로 입력해 주세요.");
			return;
		}
		if (cnametext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"이름을 입력해 주세요.");
			return;
		}
		String namereg = "^[가-힣a-zA-Z]{1,6}$";
		if (!Pattern.matches(namereg,cnametext.getText())) {
			JOptionPane.showMessageDialog(this,"이름은 1~6자리 한글 또는 영문입니다.");
			return;
		}
		if (ckindtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"종류를 입력해 주세요.");
			return;
		}
		String kindreg = "^[가-힣a-zA-Z]{1,10}$";
		if (!Pattern.matches(kindreg,ckindtext.getText())) {
			JOptionPane.showMessageDialog(this,"종류는 1~10자리 한글 또는 영문입니다.");
			return;
		}
		if (cagetext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"나이을 입력해 주세요.");
			return;
		}
		String agereg = "^\\d{1,2}[살]$";
		if (!Pattern.matches(agereg,cagetext.getText())) {
			JOptionPane.showMessageDialog(this,"나이는 1~2자릿수 숫자+살 입니다. ");
			return;
		}
		if (cbirthtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"생일을 입력해 주세요.");
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
			JOptionPane.showMessageDialog(this,"성공");
			texteditfalse();
			view();
		}else {
			JOptionPane.showMessageDialog(this,"실패");
			
		}
		imageicon.setIcon(null);
		imageicon.setText("사진을 보려면 사진보기를 이용");
	}
	public void insert() {
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"번호를 입력해 주세요.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"번호는 3자릿수 숫자로 입력해 주세요.");
			return;
		}
		if (cnametext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"이름을 입력해 주세요.");
			return;
		}
		String namereg = "^[가-힣a-zA-Z]{1,6}$";
		if (!Pattern.matches(namereg,cnametext.getText())) {
			JOptionPane.showMessageDialog(this,"이름은 1~6자리 한글 또는 영문입니다.");
			return;
		}
		if (ckindtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"종류를 입력해 주세요.");
			return;
		}
		String kindreg = "^[가-힣a-zA-Z]{1,10}$";
		if (!Pattern.matches(kindreg,ckindtext.getText())) {
			JOptionPane.showMessageDialog(this,"종류는 1~10자리 한글 또는 영문입니다.");
			return;
		}
		if (cagetext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"나이을 입력해 주세요.");
			return;
		}
		String agereg = "^\\d{1,2}[살]$";
		if (!Pattern.matches(agereg,cagetext.getText())) {
			JOptionPane.showMessageDialog(this,"나이는 1~2자릿수 숫자+살 입니다. ");
			return;
		}
		if (cbirthtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"생일을 입력해 주세요.");
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
			JOptionPane.showMessageDialog(this,"성공");
			texteditfalse();
			view();
		}else {
			JOptionPane.showMessageDialog(this,"실패");
			
		}
		imageicon.setIcon(null);
		imageicon.setText("사진을 보려면 사진보기를 이용");
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
			imageicon.setText("사진을 보려면 사진보기를 이용");
		}
	}
	public void viewno() {
		List<CatDTO> dto = CatDAO.getDao().searchno(Integer.parseInt(cnumtext.getText()));
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"번호를 입력해 주세요.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"번호는 3자리 숫자입니다.");
			return;
		}
		if (dto.isEmpty()) {
			JOptionPane.showMessageDialog(this,"검색결과가 없습니다.");
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
			imageicon.setText("사진을 보려면 사진보기를 이용");
		}
		
		JOptionPane.showMessageDialog(this,"성공");
	}
	public void viewname() {
		List<CatDTO> dto = CatDAO.getDao().searchname(cnametext.getText());
		if (cnametext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"이름을 입력해 주세요.");
			return;
		}
		String namereg = "^[가-힣a-zA-Z]{1,6}$";
		if (!Pattern.matches(namereg,cnametext.getText())) {
			JOptionPane.showMessageDialog(this,"1~6자리 한글 또는 영문입니다.");
			return;
		}
		if (dto.isEmpty()) {
			JOptionPane.showMessageDialog(this,"검색결과가 없습니다");
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
			imageicon.setText("사진을 보려면 사진보기를 이용");
		}
		JOptionPane.showMessageDialog(this,"성공");
	}
	public void delete() {
		int row = CatDAO.getDao().delete(Integer.parseInt(cnumtext.getText()));
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"번호를 입력해 주세요.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"번호는 3자리 숫자입니다.");
			return;
		}
		if (row>0) {
			JOptionPane.showMessageDialog(this,"성공");
		}else {
			JOptionPane.showMessageDialog(this,"실패");
		}
		imageicon.setIcon(null);
		imageicon.setText("사진을 보려면 사진보기를 이용");
	}
	public void viewphoto() {
		List<CatDTO> dto = CatDAO.getDao().searchno(Integer.parseInt(cnumtext.getText()));
		if (cnumtext.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"번호를 입력해 주세요.");
			return;
		}
		String noreg = "\\d{3}";
		if (!Pattern.matches(noreg,cnumtext.getText())) {
			JOptionPane.showMessageDialog(this,"번호는 3자리 숫자입니다.");
			return;
		}
		if (dto.isEmpty()) {
			JOptionPane.showMessageDialog(this,"검색결과가 없습니다.");
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
		
		JOptionPane.showMessageDialog(this,"성공");
	}
}
