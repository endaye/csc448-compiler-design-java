package compiler.syntaxparse;
import java.io.*;

/**
 * Case in notebook 编译原理 ch2.5.5 图2-27
 * 输入: 9-5+2
 * 输出: 96-2+
 * @author yzhang
 * @date 20150524
 * @next_goal 添加乘除法：有运算顺序和括号
 */

public class Parser {
	
	static int lookahead;
	
	public Parser() throws IOException {
		lookahead = System.in.read();
	}
	
	public void expr() throws IOException {
		term();
		while (true) {
			if (lookahead == '+') {
				match('+');
				term();
				System.out.write('+');
			} 
			else if (lookahead == '-') {
				match('-');
				term();
				System.out.write('-');
			}
//			else if (lookahead == '*') {
//				match('*');
//				term();
//				System.out.write('*');
//			}
//			else if (lookahead == '/') {
//				match('/');
//				term();
//				System.out.write('/');
//			}
			else return;
		}
	}
	
	void term() throws IOException {
		if (Character.isDigit((char)lookahead)) {
			System.out.write((char)lookahead);
			match(lookahead);
		}
		else {
			throw new Error("Syntax error");
		}
	}
	
	void match(int t) throws IOException {
		if (lookahead == t) {
			lookahead = System.in.read();
		} else {
			throw new Error("Syntax error");
		}
	}

}
