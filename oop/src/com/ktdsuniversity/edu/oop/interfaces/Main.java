package com.ktdsuniversity.edu.oop.interfaces;

public class Main {

	public static void main(String[] args) {

		// SomeInterface의 인스턴스 생성
//		SomeInterface intf = new SomeInterface(); // 인터페이스로 인스턴스 생성 불가 (Java의 모든 메서드는 구현이 되어있어야하기 때문에)
//		SomeInterface intf = new SomeClass();
//		intf.doSomething1();
//		intf.doSomething2();
//		intf.doSomething3();
//		System.out.println(intf.getSomething());
//		System.out.println(intf.getString());
//
//		SomeInterface intf2 = new SomeClassTwo();
//		intf2.doSomething1();
//		intf2.doSomething2();
//		intf2.doSomething3();
//		System.out.println(intf2.getSomething());
//		System.out.println(intf2.getString());

		// SystemOne can do MemberService
		MemberService sys1 = new SystemOne();
		sys1.deleteMe();
//		sys1.addPoint(3);
		((VipMemberService) sys1).addPoint(3);

		// SystemTwo is a SystemOne
		// SystemTwo can do VipMemberService, MemberService
		VipMemberService sys2 = new SystemTwo();
		sys2.deleteMe();
		sys2.addPoint(0);

		// SystemOne can do MemberService
		MemberService sys3 = new SystemOne();
		sys3.deleteMe();
//		sys3.addPoint();
//		((VipMemberService) sys3).addPoint();
//		((VipMemberService) (SystemTwo)sys3).addPoint();

//		VipMemberService sys4 = (SystemTwo)new SystemOne();

		// ArticleSystem can do ArticleService
		ArticleService artSys1 = new ArticleReplySystem();
		artSys1.delete();
//		artSys1.deleteReply();
		((ArticleReplySystem) artSys1).deleteReply();

		// ArticleSystem can do ReplyService
		ReplyService artSys2 = new ArticleReplySystem();
//		artSys2.delete();
		((ArticleService) artSys2).delete();
		artSys2.deleteReply();

//		ArticleReplySystem artSys3 = new ArticleReplySystem();
//		artSys3.delete();
//		artSys3.deleteReply();
	}
}
