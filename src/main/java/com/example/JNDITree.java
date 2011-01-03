package com.example;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class JNDITree {
	private Context context = null;

	public JNDITree() {
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		System.out.println("Listing JNDI");
		printJNDITree("");
		System.out.println("DONE");
	}

	public JNDITree(Context context) throws NamingException {
		this.context = context;
	}

	public void printJNDITree(String ct) {
		try {
			printNE(context.list(ct), ct);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// e.printStackTrace();
			System.err.println("Can not find item with path: " + ct);
		}

	}

	private void printNE(NamingEnumeration ne, String parentctx)
			throws NamingException {
		while (ne.hasMoreElements()) {
			NameClassPair next = (NameClassPair) ne.nextElement();
			printEntry(next);
			increaseIndent();
			printJNDITree((parentctx.length() == 0) ? next.getName()
					: parentctx + "/" + next.getName());
			decreaseIndent();
		}
	}

	private void printEntry(NameClassPair next) {
		System.out.println(printIndent() + "-->" + next);
	}

	private int indentLevel = 0;

	private void increaseIndent() {
		indentLevel += 4;
	}

	private void decreaseIndent() {
		indentLevel -= 4;
	}

	private String printIndent() {
		StringBuffer buf = new StringBuffer(indentLevel);
		for (int i = 0; i < indentLevel; i++) {
			buf.append(" ");
		}
		return buf.toString();
	}
}
