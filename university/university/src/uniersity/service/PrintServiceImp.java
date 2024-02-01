package uniersity.service;

public class PrintServiceImp implements PrintService {
	@Override
	public void printMainMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 교수 관리");
		System.out.println("2. 학생 관리");
		System.out.println("3. 과 관리");
		System.out.println("4. 강의 관리");
		System.out.print("메뉴 선택 : ");
	}
	
	public void professorMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 교수 등록");
		System.out.println("2. 교수 수정");
		System.out.println("3. 교수 삭제");
		System.out.println("4. 이전으로");
		System.out.print("메뉴 선택 : ");
		
	}
	
	
}
