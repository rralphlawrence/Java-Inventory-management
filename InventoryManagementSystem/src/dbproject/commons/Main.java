package dbproject.commons;

import java.awt.EventQueue;

import dbproject.views.LogIn;

public class Main {
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LogIn login = new LogIn();
						login.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
