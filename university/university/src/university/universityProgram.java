package university;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;
import uniersity.service.PrintService;
import uniersity.service.PrintServiceImp;

public class universityProgram implements Program {

private static final int professor_EXIT = 0;


private Scanner scan = new Scanner(System.in);


private PrintService printService= new PrintServiceImp();


	
	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/university/university.txt";
		//불러오기
		List<university> list = fileService.load(fileName);
		university = new university(list);
		do {
			try {
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				//메뉴를 잘못 입력하면 입력 버퍼에 잘못 입력된 메뉴가 남아있어서 비워줘야 함.
				//비워주지 않으면 무한 루프 발생
				scan.nextLine();
			}
		}while(menu != EXIT);
		//저장하기
		if(fileService.save(fileName, university.getList())) {
			System.out.println("저장이 완료됐습니다.");
		}else {
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	@Override
	public void printMenu() {
		printService.printMainMenu();
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			professormanagement(); /*교수 관리*/
			break;
		case 2:
			studentmanagement(); /*학생 관리*/
			break;
		case 3:
			clmanagement(); /*과 관리*/
			break;
		case 4:
			lecturemanagement(); /*강의 관리*/
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void lecturemanagement() {
		// TODO Auto-generated method stub
		
	}

	private void clmanagement() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	private void studentmanagement() {
		int menu;
		do {
			//학생 관리 메뉴 출력
			printService.studentMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runstudentMenu(menu);
		}while(menu != student_EXIT);
	}
	
	private void runstudentMenu(int menu) {
		switch(menu) {
		case 1:
			addstudentMenu(); /*학생 등록*/
			break;
		case 2:
			setstudentMenu();  /*학생 수정*/
			break;
		case 3:
			removestudentMenu(); /*학생 삭제*/
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	private void removestudentMenu() {
		//삭제할 학생 입력
		System.out.print("삭제할 학생 : ");
		scan.nextLine();//입력버퍼 엔터 처리
	    String word = scan.nextLine();
				
	
		if(university.removeWord(student)) {
		System.out.println("학생을 삭제했습니다.");
		}else {
		System.out.println("존재하지 않는 학생입니다.");
		}
		
	}

	private void setstudentMenu() {
		System.out.print("수정할 학생명 : ");
		scan.nextLine();//이전에 입력한 엔터 처리
		String oldStudent = scan.nextLine();
		System.out.print("새 학생명 : ");
		String newStudent = scan.nextLine();
		
		//단어를 수정
		if(university.setStudent(oldStudent, newStudent)) {
			System.out.println("학생명을 수정했습니다.");
		}else {
			System.out.println("학생명을 수정하지 못했습니다.");
		}
		
	}

	private void addstudentMenu() {
		
	System.out.print("학생 : ");
    scan.nextLine();//이전에 입력한 엔터를 처리
    String word = scan.nextLine();
				
				
    List<student> meanList = new ArrayList<student>();
	char isContinue = 'n';
	do {
	System.out.print("학생 : ");
	String student = scan.next();
					
	studentList.add(new student(student);
	System.out.print("학생을 추가하겠습니까?(y/n) : ");
	isContinue = scan.next().charAt(0);
					
	}while(isContinue == 'y');

	if(university == null) {
	System.out.println("학생이 없습니다.");
	return;
	}
				
				
    if(university.addWord(student)) {
	System.out.println("학생을 추가했습니다.");
    }else {
	System.out.println("학생이 이미 등록된 상태입니다.");
	}
		
	}

	private void professormanagement() {
		int menu;
		do {
			//교수 관리 메뉴 출력
			printService.professorMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runprofessorMenu(menu);
		}while(menu != professor_EXIT);
	}
	
	private void runprofessorMenu(int menu) {
		switch(menu) {
		case 1:
			addprofessorMenu(); /*교수 등록*/
			break;
		case 2:
			setprofessorMenu();  /*교수 수정*/
			break;
		case 3:
			removeprofessorMenu(); /*교수 삭제*/
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}

	private void removeprofessorMenu() {
		//삭제할 단어 입력
		System.out.print("삭제할 교수 : ");
		scan.nextLine();//입력버퍼 엔터 처리
		String word = scan.nextLine();
		
		//단어 삭제
		if(university.removeWord(professor)) {
			System.out.println("교수를 삭제했습니다.");
		}else {
			System.out.println("존재하지 않는 교수 목록입니다.");
		}
	}

	private void setprofessorMenu() {
		//수정할 단어와 새 단어를 입력
		System.out.print("수정할 교수명 : ");
		scan.nextLine();//이전에 입력한 엔터 처리
		String oldprofessor = scan.nextLine();
		System.out.print("새 교수명 : ");
		String newprofessor = scan.nextLine();
		
		//단어를 수정
		if(university.setprofessor(oldprofessor, newprofessor)) {
			System.out.println("교수명을 수정했습니다.");
		}else {
			//없는 단어를 수정하려고 했거나 이미 등록된 단어로 수정하려고 할 때
			System.out.println("교수명을 수정하지 못했습니다.");
		}
	}

	private void addprofessorMenu() {
		//단어, 품사, 뜻을 입력
		System.out.print("교수 : ");
		scan.nextLine();//이전에 입력한 엔터를 처리
		String word = scan.nextLine();
		
		//뜻들을 저장할 리스트
		List<professor> meanList = new ArrayList<professor>();
		char isContinue = 'n';
		do {
			System.out.print("교수 : ");
			String professor = scan.next();
			
			meanList.add(new Mean(professor);
			System.out.print("교수명을 추가하겠습니까?(y/n) : ");
			isContinue = scan.next().charAt(0);
			
		}while(isContinue == 'y');
		//단어장이 비어 있으면
		if(university == null) {
			System.out.println("교수명이 없습니다.");
			return;
		}
		
		//단어장에 추가
		if(university.addWord(professor)) {
			System.out.println("교수명을 추가했습니다.");
		}else {
			System.out.println("교수명이 이미 등록된 상태입니다.");
		}
		
	}
		
}

	
	


